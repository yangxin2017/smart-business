package com.bjd.smartanalysis.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bjd.smartanalysis.common.ResponseData;
import com.bjd.smartanalysis.entity.DataType;
import com.bjd.smartanalysis.entity.data.DataBank;
import com.bjd.smartanalysis.entity.data.DataGaJgfrxx;
import com.bjd.smartanalysis.entity.data.DataGaRydzda;
import com.bjd.smartanalysis.entity.data.DataProject;
import com.bjd.smartanalysis.entity.graph.GraphLine;
import com.bjd.smartanalysis.entity.graph.GraphNode;
import com.bjd.smartanalysis.service.data.DataBankService;
import com.bjd.smartanalysis.service.data.DataGaJgfrxxService;
import com.bjd.smartanalysis.service.data.DataGaRydzdaService;
import com.bjd.smartanalysis.service.data.DataProjectService;
import com.bjd.smartanalysis.service.graph.GraphLineService;
import com.bjd.smartanalysis.service.graph.GraphNodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Api(value = "计算关系图", tags = {"计算关系图"})
@RequestMapping("calc")
public class CalcController {
    @Autowired
    private DataGaRydzdaService rydzdaService;
    @Autowired
    private DataBankService bankService;
    @Autowired
    private DataGaJgfrxxService jgfrxxService;

    @Autowired
    private GraphLineService lineService;
    @Autowired
    private GraphNodeService nodeService;

    @Autowired
    private DataProjectService projectService;

    private Double perMinMoney = 5000.0;

    @GetMapping("relation")
    @ApiOperation(value = "计算关系图", notes = "计算关系图")
    public ResponseData CalcRelation(Integer projectId) {
        List<DataGaRydzda> persons = rydzdaService.GetAllPersonList(projectId, "");
        List<DataGaJgfrxx> companys = jgfrxxService.GetAllCompany(projectId);
        List<DataBank> banks = bankService.GetAllBanks(projectId);
        ///////
        nodeService.RemoveByProjectId(projectId);
        lineService.RemoveByProjectId(projectId);
        ///////
        CalcAndSaveNodeLine(persons, banks, companys, projectId);
        ///////


        DataProject project = projectService.getById(projectId);
        if (project != null) {
            project.setFxtime(new Date());
            projectService.updateById(project);
        }
        return ResponseData.OK(null);
    }


    private void CalcAndSaveNodeLine(List<DataGaRydzda> persons, List<DataBank> banks, List<DataGaJgfrxx> companys, Integer projectId) {
        Integer mbGroup = 0;
        for(DataGaRydzda p: persons) {
            mbGroup++;
            if(p.getSfMbr() == null || !p.getSfMbr()) {
                continue;
            }
            String mbrName = p.getXM();
            String nullName = "空";
            Map<String, List<DataBank>> zd = new HashMap<>();

            for (DataBank bk : banks) {
                if(bk.getCXDXMC().equals(mbrName)) {
                    String dfName = bk.getJYDFMC();
                    if(dfName.equals("")) {
                        if(!zd.containsKey(nullName)) {
                            zd.put(nullName, new ArrayList<>());
                        }
                        List<DataBank> arr = zd.get(nullName);
                        arr.add(bk);
                    } else {
                        if(!zd.containsKey(dfName)) {
                            zd.put(dfName, new ArrayList<>());
                        }
                        List<DataBank> arr = zd.get(dfName);
                        arr.add(bk);
                    }
                }
            }
            Set<String> keys = zd.keySet();

            GraphNode snode = nodeService.GetNodeByNodeIdAndType(projectId, p.getId(), "PERSON");
            if(snode == null) {
                snode = new GraphNode();
                snode.setNodeName(p.getXM());
                snode.setNodeId(p.getId());
                snode.setNodeType("PERSON");
                snode.setProjectId(projectId);
                snode.setGroupId(mbGroup);
                nodeService.save(snode);
            }
            for (String k: keys) {
                // 自己给自己转账。。
                if (k.equals(p.getXM())) {
                } else {
                    JSONObject nodeInfo = GetNodeType(k, persons, companys);
                    Integer dnodeId = nodeInfo.getInteger("nodeId");//GetNameId(k, persons);
                    String dnodeType = nodeInfo.getString("nodeType");
                    ////判断人还是公司？？？？？？？？？？？？？

                    GraphNode dnode = null;
                    if (dnodeId != null) {
                        dnode = nodeService.GetNodeByNodeIdAndType(projectId, dnodeId, dnodeType);
                    }
                    if (dnode == null) {
                        dnode = new GraphNode();
                        dnode.setNodeName(k);
                        dnode.setNodeType(dnodeType);
                        dnode.setNodeId(dnodeId);
                        dnode.setProjectId(projectId);
                        dnode.setGroupId(mbGroup);
                        nodeService.save(dnode);
                    }

                    Double jeJIN = 0.0;
                    List<Integer> jinIds = new ArrayList<>();
                    Double jeCHU = 0.0;
                    List<Integer> chuIds = new ArrayList<>();
                    for (DataBank db : zd.get(k)) {
                        Double tv = Double.parseDouble(db.getJYJE());
                        if (tv > 0) {
                            if (tv > perMinMoney) {
                                jeJIN += tv;
                                jinIds.add(db.getId());
                            }
                        } else {
                            if (tv < -perMinMoney) {
                                jeCHU += tv;
                                chuIds.add(db.getId());
                            }
                        }
                    }

                    // save Lines
                    if (jeJIN != 0) {
                        GraphLine lineJIN = new GraphLine();
                        lineJIN.setSid(dnode.getId());
                        lineJIN.setEid(snode.getId());
                        lineJIN.setName(jeJIN.toString());
                        lineJIN.setRelationIds(getIdsByList(jinIds));
                        lineJIN.setProjectId(projectId);
                        lineJIN.setGroupId(mbGroup);
                        lineService.save(lineJIN);
                    }
                    if (jeCHU != 0) {
                        GraphLine lineCHU = new GraphLine();
                        lineCHU.setSid(snode.getId());
                        lineCHU.setEid(dnode.getId());
                        lineCHU.setName(jeCHU.toString());
                        lineCHU.setRelationIds(getIdsByList(chuIds));
                        lineCHU.setProjectId(projectId);
                        lineCHU.setGroupId(mbGroup);
                        lineService.save(lineCHU);
                    }
                }
            }


            // 反向查询
            zd = new HashMap<>();
            for (DataBank bk : banks) {
                if(bk.getJYDFMC().equals(mbrName)) {
                    String dfName = bk.getCXDXMC();
                    if(dfName.equals("")) {
                        if(!zd.containsKey(nullName)) {
                            zd.put(nullName, new ArrayList<>());
                        }
                        List<DataBank> arr = zd.get(nullName);
                        arr.add(bk);
                    } else {
                        if(!zd.containsKey(dfName)) {
                            zd.put(dfName, new ArrayList<>());
                        }
                        List<DataBank> arr = zd.get(dfName);
                        arr.add(bk);
                    }
                }
            }
            keys = zd.keySet();

            GraphNode eenode = nodeService.GetNodeByNodeIdAndType(projectId, p.getId(), "PERSON");
            if (eenode == null) {
                eenode = new GraphNode();
                eenode.setNodeName(p.getXM());
                eenode.setNodeId(p.getId());
                eenode.setNodeType("PERSON");
                eenode.setProjectId(projectId);
                eenode.setGroupId(mbGroup);
                nodeService.save(eenode);
            }
            // keys====对方的流水出现的
            for (String k: keys) {
                if (k.equals(p.getXM())) {
                } else {
//                    Integer ssNodeId = GetNameId(k, persons);
                    JSONObject nodeInfo = GetNodeType(k, persons, companys);
                    Integer ssNodeId = nodeInfo.getInteger("nodeId");//GetNameId(k, persons);
                    String dnodeType = nodeInfo.getString("nodeType");

                    GraphNode ssnode = null;
                    if (ssNodeId != null) {
                        ssnode = nodeService.GetNodeByNodeIdAndType(projectId, ssNodeId, dnodeType);
                    }
                    if (ssnode == null) {
                        ssnode = new GraphNode();
                        ssnode.setNodeName(k);
                        ssnode.setNodeType(dnodeType);
                        ssnode.setNodeId(ssNodeId);
                        ssnode.setProjectId(projectId);
                        ssnode.setGroupId(mbGroup);
                        nodeService.save(ssnode);
                    }
                    Double jeJIN = 0.0;
                    List<Integer> jinIds = new ArrayList<>();
                    Double jeCHU = 0.0;
                    List<Integer> chuIds = new ArrayList<>();
                    for (DataBank db : zd.get(k)) {
                        Double tv = Double.parseDouble(db.getJYJE());
                        if (tv > 0) {
                            if (tv > perMinMoney) {
                                jeJIN += tv;
                                jinIds.add(db.getId());
                            }
                        } else {
                            if (tv < -perMinMoney) {
                                jeCHU += tv;
                                chuIds.add(db.getId());
                            }
                        }
                    }
                    // save Lines
                    if (jeJIN != 0) {
                        GraphLine lineJIN = new GraphLine();
                        lineJIN.setSid(eenode.getId());
                        lineJIN.setEid(ssnode.getId());
                        lineJIN.setName(jeJIN.toString());
                        lineJIN.setRelationIds(getIdsByList(jinIds));
                        lineJIN.setProjectId(projectId);
                        lineJIN.setGroupId(mbGroup);
                        lineService.save(lineJIN);
                    }
                    if (jeCHU != 0) {
                        GraphLine lineCHU = new GraphLine();
                        lineCHU.setSid(eenode.getId());
                        lineCHU.setEid(ssnode.getId());
                        lineCHU.setName(jeCHU.toString());
                        lineCHU.setRelationIds(getIdsByList(chuIds));
                        lineCHU.setProjectId(projectId);
                        lineCHU.setGroupId(mbGroup);
                        lineService.save(lineCHU);
                    }
                }
            }
        }
    }

    private Integer GetNameId(String name, List<DataGaRydzda> users) {
        Integer id = null;
        for(DataGaRydzda u: users) {
            if(u.getXM().equals(name)) {
                id = u.getId();
                break;
            }
        }
        return id;
    }
    private JSONObject GetNodeType(String name, List<DataGaRydzda> persons, List<DataGaJgfrxx> companys) {
        JSONObject obj = new JSONObject();
        String nodeType = "NULL";
        Integer nodeId = null;
        for (DataGaRydzda p: persons) {
            if (name.equals(p.getXM())) {
                nodeType = "PERSON";
                nodeId = p.getId();
                break;
            }
        }
        if (nodeType.equals("NULL")) {
            for (DataGaJgfrxx p : companys) {
                if (name.trim().equals(p.getJGMC().trim())) {
                    nodeType = "COMPANY";
                    nodeId = p.getId();
                    break;
                }
            }
        }
        obj.put("nodeType", nodeType);
        obj.put("nodeId", nodeId);
        return obj;
    }


    @GetMapping("results")
    @ApiOperation(value = "计算关系图结果", notes = "计算关系图结果")
    public ResponseData GetRelation(Integer projectId){
        List<GraphNode> nodes = nodeService.GetNodeList(projectId);
        List<GraphLine> lines = lineService.GetLineList(projectId);

        JSONArray ns = new JSONArray();
        for(GraphNode node: nodes) {
            JSONObject obj = new JSONObject();
            obj.put("groupId", node.getGroupId());
            obj.put("id", node.getId());
            obj.put("nodeType", node.getNodeType());
            obj.put("nodeId", node.getNodeId());
            obj.put("nodeName", node.getNodeName());
            DataGaRydzda user = rydzdaService.getById(node.getNodeId());
            if (user != null) {
                obj.put("user", user);
            } else {
                obj.put("user", null);
            }
            DataGaJgfrxx fx = jgfrxxService.getById(node.getNodeId());
            if (fx != null) {
                obj.put("company", fx);
            } else {
                obj.put("company", null);
            }
            ns.add(obj);
        }

        JSONArray arr = new JSONArray();
        for(GraphLine line: lines) {
            JSONObject obj = new JSONObject();
            obj.put("groupId", line.getGroupId());
            obj.put("id", line.getId());
            obj.put("sid", line.getSid());
            obj.put("eid", line.getEid());
            obj.put("name", line.getName());
            String ids = line.getRelationIds();
            String[] idarrStr = ids.split(",");
            List<String> idArr = new ArrayList<>();
            for(String i: idarrStr) {
                idArr.add(i);
            }
            List<DataBank> datas = bankService.listByIds(idArr);
            obj.put("relation", datas);
            arr.add(obj);
        }

        JSONObject res = new JSONObject();
        res.put("nodes", ns);
        res.put("lines", arr);
        return ResponseData.OK(res);
    }

    private String getIdsByList(List<Integer> ids) {
        String str = "";
        for(Integer id: ids) {
            str += id.toString() + ",";
        }
        if (!str.equals("")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}