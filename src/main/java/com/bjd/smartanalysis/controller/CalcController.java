package com.bjd.smartanalysis.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.unit.DataUnit;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjd.smartanalysis.common.CommonUtils;
import com.bjd.smartanalysis.common.ResponseData;
import com.bjd.smartanalysis.entity.DataType;
import com.bjd.smartanalysis.entity.data.*;
import com.bjd.smartanalysis.entity.graph.GraphLine;
import com.bjd.smartanalysis.entity.graph.GraphNode;
import com.bjd.smartanalysis.entity.graph.GraphResult;
import com.bjd.smartanalysis.service.data.*;
import com.bjd.smartanalysis.service.graph.GraphLineService;
import com.bjd.smartanalysis.service.graph.GraphNodeService;
import com.bjd.smartanalysis.service.graph.GraphResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@Api(value = "计算关系图", tags = {"计算关系图"})
@RequestMapping("calc")
public class CalcController {
    @Autowired
    private DataGaRydzdaService rydzdaService;
    @Autowired
    private DataGaQsgxService qsgxService;
    @Autowired
    private DataBankService bankService;
    @Autowired
    private DataGaJgfrxxService jgfrxxService;

    @Autowired
    private GraphLineService lineService;
    @Autowired
    private GraphNodeService nodeService;
    @Autowired
    private GraphResultService resultService;

    @Autowired
    private DataProjectService projectService;

    @Autowired
    private DataGaZrzybqgFdcqService fdcqService;
    @Autowired
    private DataGaQydjxxZyryService zyryService;
    @Autowired
    private DataGaJrjgzhZhjbxxService zhjbxxService;
    @Autowired
    private DataGaZrzybqgDyqService dyqService;
    @Autowired
    private DataGaBxxxBxbdxxService bxxxBxbdxxService;
    @Autowired
    private DataGaZqxxCyxxService cyxxService;
    @Autowired
    private DataGaQydjxxQyjbxxService qyjbxxService;

    private Double perMinMoney = 1000.0;

    private Integer MBR_LEVEL = 1;
    private Integer MQR_GS_LEVEL = 2;
    private Integer FXDX_QT_LEVEL = 3;

    private String MBR_CORLOR = "red";
    private String FXDX_CORLOR = "green";
    private String MQR_GS_CORLOR = "yellow";
    private String QT_CORLOR = "blue";


    @GetMapping("retime")
    @ApiOperation(value = "时间格式化", notes = "时间格式化")
    public ResponseData ReCalcJYSJ(){
        String time = "2013-06-06 22:35:32";


//        List<DataProject> projects = projectService.list();
//        for (DataProject p: projects) {
//            DealDataBank(p.getId());
//        }

        time = CommonUtils.DealTime(time);
        return ResponseData.OK(time);
    }
    private void DealDataBank(Integer projectId) {
        List<DataBank> banks = bankService.GetAllBanks(projectId);
        for (DataBank b: banks) {
            String jysj = b.getJYSJ();
            jysj = CommonUtils.DealTime(jysj);
            b.setJYSJ(jysj);
        }
        bankService.updateBatchById(banks, 1000);
    }

    @GetMapping("relation")
    @ApiOperation(value = "计算关系图", notes = "计算关系图")
    public ResponseData CalcRelation(Integer projectId) {
        List<DataGaRydzda> persons = rydzdaService.GetAllPersonList(projectId, "");
//        List<DataGaJgfrxx> companys = jgfrxxService.GetAllCompany(projectId);
        List<DataBank> banks = bankService.GetAllBanks(projectId);
        List<DataGaQydjxxQyjbxx> qyjbxxes = qyjbxxService.GetAllQys(projectId);

        for(DataBank db: banks) {
            if(db.getJYJE() == null || db.getJYJE().equals("")) {
                db.setJYYE("0");
            }
            // 去除空格
            if(db.getMC() != null) {
                db.setMC(db.getMC().trim());
            } else {
                db.setMC("");
            }
            db.setJYDFMC(db.getJYDFMC() != null ? db.getJYDFMC().trim() : "");
            db.setJYDFKH(db.getJYDFKH() != null ? db.getJYDFKH().trim() : "");
            db.setJYDFZH(db.getJYDFZH() != null ? db.getJYDFZH().trim() : "");
        }
        // 去除空格
        for(DataGaRydzda p : persons) {
            p.setXM(p.getXM() != null ? p.getXM().trim() : "");
        }
        // 去除空格
        for(DataGaQydjxxQyjbxx g: qyjbxxes) {
            g.setMC(g.getMC() != null ? g.getMC().trim() : "");
            if (g.getQYJGMC() != null) {
                g.setQYJGMC(g.getQYJGMC().trim());
            } else {
                g.setQYJGMC("");
            }
        }
        // 现金和空要单独处理
        for (DataBank b: banks) {
            String mc = b.getMC();
            String dfmc = b.getJYDFMC();
            if (mc != null && mc.equals("现金")) {
                if(dfmc != null && !dfmc.equals("")) {
                    b.setMC("现金(" + dfmc + ")");
                }
            } else if (dfmc != null && dfmc.equals("现金")) {
                if (mc != null && !mc.equals("")) {
                    b.setJYDFMC("现金(" + mc + ")");
                }
            }
            // 自助设备现金
            if (mc != null && mc.equals("自助设备现金")) {
                if(dfmc != null && !dfmc.equals("")) {
                    b.setMC("自助设备现金(" + dfmc + ")");
                }
            } else if (dfmc != null && dfmc.equals("自助设备现金")) {
                if (mc != null && !mc.equals("")) {
                    b.setJYDFMC("自助设备现金(" + mc + ")");
                }
            }
        }

        ///////
        nodeService.RemoveByProjectId(projectId);
        lineService.RemoveByProjectId(projectId);
        resultService.RemoveByProjectId(projectId);
        ///////
        CalcAndSaveNodeLine(persons, banks, qyjbxxes, projectId);
        ///////


        DataProject project = projectService.getById(projectId);
        if (project != null) {
            project.setFxtime(new Date());
            projectService.updateById(project);
        }
        return ResponseData.OK(null);
    }

    private void CalcAndSaveNodeLineNew(List<DataGaRydzda> persons, List<DataBank> banks, List<DataGaQydjxxQyjbxx> qyjbxxes, Integer projectId) {
        List<DataGaQsgx> allQsgxList = qsgxService.GetAllPersonList(projectId, "");

        // 所有目标人
        List<DataGaRydzda> allMBR = new ArrayList<>();
        for (DataGaRydzda p: persons) {
            if(p.getSfMbr() != null && p.getSfMbr()) {
                allMBR.add(p);
            }
        }
        /////////////////////////////////////////////////////////////////////////
        // 所有密切人
        List<DataGaRydzda> allMQR = new ArrayList<>();
        List<DataGaQsgx> allQsgx = qsgxService.GetAllPersonList(projectId, null);
        for (DataGaRydzda p: allMBR) {
            for(DataGaQsgx mq: allQsgx) {
                if(p.getXM().equals(mq.getXM1())) {
                    DataGaRydzda mp = GetByName(mq.getXM2(), persons);
                    if (mp != null) {
                        allMQR.add(mp);
                    }
                }
            }
        }
        ////////////////////////////////////////////////////////////////
        String nullName = "空";
        List<GraphNode> allNodes1 = SavePersonNode(projectId, persons, allMBR, banks, qyjbxxes, nullName);
        List<GraphNode> allNodes2 = SavePersonNode(projectId, persons, allMQR, banks, qyjbxxes, nullName);

    }
    private List<GraphNode> SavePersonNode(Integer projectId, List<DataGaRydzda> persons, List<DataGaRydzda> allMBR, List<DataBank> banks, List<DataGaQydjxxQyjbxx> qyjbxxes, String nullName) {
        List<GraphNode> allNodes = new ArrayList<>();
        for (DataGaRydzda p: allMBR) {
            // 保存目标人节点
            if(!IsExistNode(allNodes, "PERSON", p.getXM())) {
                GraphNode snode = new GraphNode();
                snode.setNodeName(p.getXM());
                snode.setNodeId(p.getId());
                snode.setNodeType("PERSON");
                snode.setProjectId(projectId);
                snode.setGroupId(0);
                allNodes.add(snode);
            }
            // zd key 是 交易对方名称 和 目标人的集合
            Map<String, List<DataBank>> zd = GroupMbrBankInfo(banks, p.getXM(), nullName);
            Set<String> keys = zd.keySet();
            for (String name: keys) {
                JSONObject o = GetNodeInfoByName(name, persons, allNodes, qyjbxxes);
                String nodeType = o.getString("nodeType");
                Integer nodeId = o.getInteger("nodeId");
                if(!IsExistNode(allNodes, nodeType, name)) {
                    GraphNode newNode = new GraphNode();
                    newNode.setNodeName(name);
                    newNode.setNodeId(nodeId);
                    newNode.setNodeType(nodeType);
                    newNode.setProjectId(projectId);
                    newNode.setGroupId(0);
                    allNodes.add(newNode);
                }
            }
            // 反向
            zd = GroupMbrBankInfoRevers(banks, p.getXM(), nullName);
            keys = zd.keySet();
            for (String name: keys) {
                JSONObject o = GetNodeInfoByName(name, persons, allNodes, qyjbxxes);
                String nodeType = o.getString("nodeType");
                Integer nodeId = o.getInteger("nodeId");
                if(!IsExistNode(allNodes, nodeType, name)) {
                    GraphNode newNode = new GraphNode();
                    newNode.setNodeName(name);
                    newNode.setNodeId(nodeId);
                    newNode.setNodeType(nodeType);
                    newNode.setProjectId(projectId);
                    newNode.setGroupId(0);
                    allNodes.add(newNode);
                }
            }
            ////////////////////
        }
        return allNodes;
    }

    private List<DataGaQydjxxQyjbxx> GetPointQY(Integer projectId, List<DataGaRydzda> mbrs, List<DataGaRydzda> mqrs, List<DataGaQydjxxQyjbxx> qyjbxxes) {
        List<DataGaQydjxxQyjbxx> pointQY = new ArrayList<>();

        for(DataGaRydzda p: mbrs) {
            for(DataGaQydjxxQyjbxx qy: qyjbxxes) {
                String mc = qy.getMC();
                String fr = qy.getFDDBR();
                String fname = "";
                if (fr != null && !fr.equals("")) {
                    fname = fr;
                }
                if (fname.equals("") && mc != null && !mc.equals("")) {
                    fname = mc;
                }
                if (p.getXM().equals(fname)) {
                    GraphNode pnode = nodeService.GetNodeByNodeIdAndType(projectId, p.getId(), "PERSON");
                    if (pnode != null) {
                        qy.setUserId(pnode.getId());
                    }
                    pointQY.add(qy);
                }
            }
        }
        for(DataGaRydzda p: mqrs) {
            for(DataGaQydjxxQyjbxx qy: qyjbxxes) {
                String mc = qy.getMC();
                String fr = qy.getFDDBR();
                String fname = "";
                if (fr != null && !fr.equals("")) {
                    fname = fr;
                }
                if (mc != null && !mc.equals("")) {
                    fname = mc;
                }
                if (p.getXM().equals(fname)) {
                    GraphNode pnode = nodeService.GetNodeByNodeIdAndType(projectId, p.getId(), "PERSON");
                    if (pnode != null) {
                        qy.setUserId(pnode.getId());
                    }
                    pointQY.add(qy);
                }
            }
        }
        return pointQY;
    }
    private Boolean IsExistNode(List<GraphNode> allNodes, String nodeType, String xm) {
        Boolean ishave = false;
        for (GraphNode node : allNodes) {
            if (node.getNodeType().equals(nodeType) && node.getNodeName().equals(xm)) {
                ishave = true;
                break;
            }
        }
        return ishave;
    }
    private GraphNode GetNotSELFNode(List<GraphNode> allNodes, String xm) {
        GraphNode res = null;
        for (GraphNode node : allNodes) {
            if (!node.getNodeType().equals("SELF") && node.getNodeName().equals(xm)) {
                res = node;
                break;
            }
        }
        return res;
    }
    private JSONObject GetNodeInfoByName(String name, List<DataGaRydzda> persons, List<GraphNode> allNodes, List<DataGaQydjxxQyjbxx> qyjbxxes) {
        JSONObject obj = new JSONObject();
        String nodeType = "NULL";
        Integer nodeId = null;

        GraphNode node = GetNotSELFNode(allNodes, name);
        if (node != null) {
            nodeType = node.getNodeType();
            nodeId = node.getNodeId();
        } else {
            for (DataGaRydzda p : persons) {
                if (name.equals(p.getXM())) {
                    nodeType = "PERSON";
                    nodeId = p.getId();
                    break;
                }
            }
            if (nodeType.equals("NULL")) {
                for (DataGaQydjxxQyjbxx p : qyjbxxes) {
                    if (name.trim().equals(p.getQYJGMC().trim())) {
                        nodeType = "COMPANY";
                        nodeId = p.getId();
                        break;
                    }
                }
            }
        }
        obj.put("nodeType", nodeType);
        obj.put("nodeId", nodeId);
        return obj;
    }
    private DataGaRydzda GetByName(String xm, List<DataGaRydzda> users) {
        DataGaRydzda p = null;
        for(DataGaRydzda u: users) {
            if(u.getXM().equals(xm)) {
                p = u;
                break;
            }
        }
        return p;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * NULL, MBR, FXDX, MQR, QT
     * @param persons
     * @param mbrs
     * @param allQsgxList
     * @param pid
     * @return
     */
    private String JudgePersonType(List<DataGaRydzda> persons, List<DataGaRydzda> mbrs, List<DataGaQsgx> allQsgxList, Integer pid) {
        DataGaRydzda person = null;
        for(DataGaRydzda p: persons) {
            if (p.getId().equals(pid)) {
                person = p;
                break;
            }
        }
        //////////////
        if (person != null) {
            if (person.getSfMbr() != null && person.getSfMbr()) {
                return "MBR";
            } else if(person.getSfFxdx() != null && person.getSfFxdx()) {
                return "FXDX";
            } else {
                //////////密切人
                boolean ismqr = IsMQR(mbrs, allQsgxList, person);
                if(ismqr) {
                    return "MQR";
                } else {
                    return "QT";
                }
            }
        }
        return "NULL";
    }

    private void CalcAndSaveNodeLine(List<DataGaRydzda> persons, List<DataBank> banks, List<DataGaQydjxxQyjbxx> qyjbxxes, Integer projectId) {
        Integer mbGroup = 0;
        Integer nodeGroup = 0;

        // 获取亲属关系表中project_id为projectId的所有数据
        List<DataGaQsgx> qsgxList = qsgxService.GetAllPersonList(projectId, "");
        List<DataGaQsgx> allQsgxList = qsgxService.GetAllPersonList(projectId, "");
        QueryWrapper <DataGaQsgx> queryWrapper = new QueryWrapper <>();

        List<DataGaRydzda> allMBR = new ArrayList<>();
        for (DataGaRydzda p: persons) {
            if(p.getSfMbr() != null && p.getSfMbr()) {
                allMBR.add(p);
            } else if (p.getSfFxdx() != null && p.getSfFxdx()) {
                allMBR.add(p);
            }
        }
        List<DataGaRydzda> allMQR = new ArrayList<>();


        Map<String, JSONObject> finalMap = new HashMap<>();

        for(DataGaRydzda p: persons) {
            boolean ismrq = IsMQR(allMBR, allQsgxList, p);
            // 判断是否目标人
            if(p.getSfMbr() == null || !p.getSfMbr()) {
                if(p.getSfFxdx() == null || !p.getSfFxdx()) {
                    if (!ismrq) {
                        continue;
                    }
                }
            }

            mbGroup++;
            queryWrapper.clear();
            // 查询亲属关系中projectId为projectId,XM1为p.getXM()或XM2为p.getXM()的数据，并且gx为密切人
            queryWrapper.eq("project_id", projectId).and(wrapper -> wrapper.eq("xm1", p.getXM()).or().eq("xm2", p.getXM())).eq("gx", "密切人");
            List<DataGaQsgx> qsgxList1 = qsgxService.list(queryWrapper);
            if(qsgxList1.size()==0){
            }


            String mbrName = p.getXM();
            String nullName = "空" + "(" + mbrName + ")";

            // zd key 是 交易对方名称 和 目标人的集合
            Map<String, List<DataBank>> zd = GroupMbrBankInfo(banks, mbrName, nullName);

            Set<String> keys = zd.keySet();

            GraphNode snode = nodeService.GetNodeByNodeIdAndType(projectId, p.getId(), "PERSON");
            if(snode == null) {
                snode = new GraphNode();
                snode.setNodeName(p.getXM());
                snode.setNodeId(p.getId());
                snode.setNodeType("PERSON");
                snode.setProjectId(projectId);
                snode.setGroupId(mbGroup);
                if(p.getSfMbr() != null && p.getSfMbr()) {
                    snode.setNodeLevel(MBR_LEVEL);
                    snode.setNodeColor(MBR_CORLOR);
                } else if (p.getSfFxdx() != null && p.getSfFxdx()) {
                    snode.setNodeLevel(FXDX_QT_LEVEL);
                    snode.setNodeColor(FXDX_CORLOR);
                } else if (ismrq) {
                    snode.setNodeColor(MQR_GS_CORLOR);
                    snode.setNodeLevel(MQR_GS_LEVEL);
                }
                nodeService.save(snode);
            }


            // k 包含 ：对方用户名（公司名）、卡号、账号、空
            for (String k: keys) {
                // 自己给自己转账。。暂不处理
                if (k.equals(p.getXM())) {
                    List<DataBank> myBanks = zd.get(k);
                    SaveSelfData(myBanks, projectId, p.getId());
                } else {
                    JSONObject nodeInfo = GetNodeType(k, persons, qyjbxxes, projectId);
                    Integer sId = nodeInfo.getInteger("Id");
                    Integer dnodeId = nodeInfo.getInteger("nodeId");//GetNameId(k, persons);
                    String dnodeType = nodeInfo.getString("nodeType");
                    ////判断人还是公司？？？？？？？？？？？？？

                    ////////////////////////////////////终点////////////////////////////
                    GraphNode dnode = null;
                    if (dnodeId != null) {
                        dnode = nodeService.GetNodeByNodeIdAndType(projectId, dnodeId, dnodeType, k);
                    }
                    if (sId != null) {
                        dnode = nodeService.getById(sId);
                    }
                    if (dnode == null) {
                        dnode = new GraphNode();
                        dnode.setNodeName(k);
                        dnode.setNodeType(dnodeType);
                        dnode.setNodeId(dnodeId);
                        dnode.setProjectId(projectId);
                        dnode.setGroupId(mbGroup);
                        if (dnodeType.equals("NULL")) {
                            dnode.setNodeColor(QT_CORLOR);
                            dnode.setNodeLevel(FXDX_QT_LEVEL);
                        } else if(dnodeType.equals("PERSON")) {
                            // 判断是目标人，密切人，分析对象，普通人
                            String personType = JudgePersonType(persons, allMBR, allQsgxList, dnodeId);
                            // NULL, MBR, FXDX, MQR, QT
                            if (personType.equals("NULL")) {
                                dnode.setNodeColor(QT_CORLOR);
                                dnode.setNodeLevel(FXDX_QT_LEVEL);
                            } else if (personType.equals("MBR")) {
                                dnode.setNodeColor(MBR_CORLOR);
                                dnode.setNodeLevel(MBR_LEVEL);
                            } else if (personType.equals("MQR")) {
                                dnode.setNodeColor(MQR_GS_CORLOR);
                                dnode.setNodeLevel(MQR_GS_LEVEL);
                            } else if (personType.equals("FXDX")) {
                                dnode.setNodeColor(FXDX_CORLOR);
                                dnode.setNodeLevel(FXDX_QT_LEVEL);
                            } else if (personType.equals("QT")) {
                                dnode.setNodeColor(QT_CORLOR);
                                dnode.setNodeLevel(FXDX_QT_LEVEL);
                            }
                        } else if (dnodeType.equals("COMPANY")) {
                            dnode.setNodeColor(MQR_GS_CORLOR);
                            dnode.setNodeLevel(MQR_GS_LEVEL);
                        }
                        nodeService.save(dnode);
                    }
                    /////////////////////////////////////////终点////////////////////////////

                    Double jeJIN = 0.0;
                    JSONArray jinIds = new JSONArray();
                    Double jeCHU = 0.0;
                    JSONArray chuIds = new JSONArray();

                    List <DataBank> saveBankList = new ArrayList<>();
                    for (DataBank db : zd.get(k)) {
                        boolean isIn = false;
                        for(DataBank sdb:saveBankList){
                            /*if(db.getJYSJ()==sdb.getJYSJ()&&db.getCXDXMC()==sdb.getCXDXMC()&&db.getJYYE().equals((sdb.getJYYE()))){*/
                            if(StringUtils.equals(db.getJYSJ(),sdb.getJYSJ())
                                    && StringUtils.equals(db.getCXDXMC(),sdb.getCXDXMC())
                                    && StringUtils.equals(db.getJYYE(),sdb.getJYYE())
                                    && StringUtils.equals(db.getJYJE(),sdb.getJYJE())){
                                isIn = true;
                            }
                        }
                        if(!isIn){
                            saveBankList.add(db);
                            Double tv = 0.0;
                            if(db.getJYJE() != null && !db.getJYJE().equals("")){
                               tv = Double.parseDouble(db.getJYJE());
                            }
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
                    }

                    // save Lines 正向查询 === 保存 出 的记录
                    if (jeJIN != 0) {
                        String key = dnode.getId() + "-" + snode.getId();
                        JSONObject tmp = finalMap.get(key);
                        if (tmp != null) {
//                            Double je = tmp.getDouble("je");
//                            JSONArray ids = tmp.getJSONArray("ids");
//                            je += jeJIN;
//                            for (int i=0;i<jinIds.size();i++) {
//                                ids.add(jinIds.getInteger(i));
//                            }
//                            tmp.put("je", je);
//                            tmp.put("ids", ids);
//                            finalMap.put(key, tmp);
                        } else {
                            JSONObject oout = new JSONObject();
                            oout.put("je", jeJIN);
                            oout.put("ids", jinIds);
                            finalMap.put(key, oout);
                        }

                    }
                    if (jeCHU != 0) {
                        String key = snode.getId() + "-" + dnode.getId();
                        JSONObject tmp = finalMap.get(key);
                        if (tmp != null) {
//                            Double je = tmp.getDouble("je");
//                            JSONArray ids = tmp.getJSONArray("ids");
//                            je += jeCHU;
//                            for (int i=0;i<chuIds.size();i++) {
//                                ids.add(chuIds.getInteger(i));
//                            }
//                            tmp.put("je", je);
//                            tmp.put("ids", ids);
//                            finalMap.put(key, tmp);
                        } else {
                            JSONObject oout = new JSONObject();
                            oout.put("je", jeCHU);
                            oout.put("ids", chuIds);
                            finalMap.put(key, oout);
                        }
                    }



                    // 亲属关系逻辑
                    // 如果qsgxList中包含XM1为snode.getNodeName()，XM2为dnode.getNodeName()的数据或者XM为dnode.getNodeName()
                    // XM2为snode.getNodeName()的数据，则给这两个节点nodeGroup赋值为nodeGroup
                    QueryWrapper <DataGaQsgx> queryWrapper1 = new QueryWrapper <>();
                    queryWrapper1.eq("project_id", projectId);
                    //.and(wrapper -> wrapper.ne("gx","密切人"));
                    List <DataGaQsgx> qsgxListd = qsgxService.list(queryWrapper1);
                    for (DataGaQsgx qsgx : qsgxListd) {
                        if (qsgx.getXM1().equals(snode.getNodeName()) && qsgx.getXM2().equals(dnode.getNodeName())) {
                            nodeGroup++;
                            String nodeNumber = String.valueOf(nodeGroup);
                            if(snode.getNodeGroup()!=null && snode.getNodeGroup().length()>0) {
                                nodeNumber = snode.getNodeGroup();
                            }
                            snode.setNodeGroup(nodeNumber);
                            dnode.setNodeGroup(nodeNumber);
                            nodeService.updateById(snode);
                            nodeService.updateById(dnode);
                        } else if (qsgx.getXM1().equals(dnode.getNodeName()) && qsgx.getXM2().equals(snode.getNodeName())) {
                            nodeGroup++;
                            String nodeNumber = String.valueOf(nodeGroup);
                            if(snode.getNodeGroup()!=null && snode.getNodeGroup().length()>0) {
                                nodeNumber = snode.getNodeGroup();
                            }
                            snode.setNodeGroup(nodeNumber);
                            dnode.setNodeGroup(nodeNumber);
                            nodeService.updateById(snode);
                            nodeService.updateById(dnode);
                        }
                    }
                }
            }


            // 反向查询
            zd = new HashMap<>();
            for (DataBank bk : banks) {
                String tmpMc = bk.getJYDFMC();
                if(tmpMc == null) {
                    tmpMc = "";
                }
                if(tmpMc.equals(mbrName)) {
                    JSONObject dfNameObj = this.GetMCReverse(bk);
                    String dfName = dfNameObj.getString("value");
                    if (dfName == null) {
                        dfName = "";
                    }
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
                if(p.getSfMbr() != null && p.getSfMbr()) {
                    eenode.setNodeLevel(MBR_LEVEL);
                    eenode.setNodeColor(MBR_CORLOR);
                } else if (p.getSfFxdx() != null && p.getSfFxdx()) {
                    eenode.setNodeLevel(FXDX_QT_LEVEL);
                    eenode.setNodeColor(FXDX_CORLOR);
                }
                nodeService.save(eenode);
            }
            // keys====对方的流水出现的
            for (String k: keys) {
                if (k.equals(p.getXM())) {
                } else {
//                    Integer ssNodeId = GetNameId(k, persons);
                    JSONObject nodeInfo = GetNodeType(k, persons, qyjbxxes, projectId);
                    Integer ssId = nodeInfo.getInteger("Id");
                    Integer ssNodeId = nodeInfo.getInteger("nodeId");//GetNameId(k, persons);
                    String dnodeType = nodeInfo.getString("nodeType");

                    ////////////////////////////////////////////////////////////////////////
                    GraphNode ssnode = null;
                    if (ssNodeId != null) {
                        ssnode = nodeService.GetNodeByNodeIdAndType(projectId, ssNodeId, dnodeType, k);
                    }
                    if (ssId != null) {
                        ssnode = nodeService.getById(ssId);
                    }
                    if (ssnode == null) {
                        ssnode = new GraphNode();
                        ssnode.setNodeName(k);
                        ssnode.setNodeType(dnodeType);
                        ssnode.setNodeId(ssNodeId);
                        ssnode.setProjectId(projectId);
                        ssnode.setGroupId(mbGroup);
                        ////////
                        if (dnodeType.equals("NULL")) {
                            ssnode.setNodeColor(QT_CORLOR);
                            ssnode.setNodeLevel(FXDX_QT_LEVEL);
                        } else if(dnodeType.equals("PERSON")) {
                            // 判断是目标人，密切人，分析对象，普通人
                            String personType = JudgePersonType(persons, allMBR, allQsgxList, ssNodeId);
                            // NULL, MBR, FXDX, MQR, QT
                            if (personType.equals("NULL")) {
                                ssnode.setNodeColor(QT_CORLOR);
                                ssnode.setNodeLevel(FXDX_QT_LEVEL);
                            } else if (personType.equals("MBR")) {
                                ssnode.setNodeColor(MBR_CORLOR);
                                ssnode.setNodeLevel(MBR_LEVEL);
                            } else if (personType.equals("MQR")) {
                                ssnode.setNodeColor(MQR_GS_CORLOR);
                                ssnode.setNodeLevel(MQR_GS_LEVEL);
                            } else if (personType.equals("FXDX")) {
                                ssnode.setNodeColor(FXDX_CORLOR);
                                ssnode.setNodeLevel(FXDX_QT_LEVEL);
                            } else if (personType.equals("QT")) {
                                ssnode.setNodeColor(QT_CORLOR);
                                ssnode.setNodeLevel(FXDX_QT_LEVEL);
                            }
                        } else if (dnodeType.equals("COMPANY")) {
                            ssnode.setNodeColor(MQR_GS_CORLOR);
                            ssnode.setNodeLevel(MQR_GS_LEVEL);
                        }

                        nodeService.save(ssnode);
                    }
                    //////////////////////////////////////////////////////////////////////

                    Double jeJIN = 0.0;
                    JSONArray jinIds = new JSONArray();
                    Double jeCHU = 0.0;
                    JSONArray chuIds = new JSONArray();

                    List <DataBank> saveBankList = new ArrayList<>();
                    for (DataBank db : zd.get(k)) {
                        boolean isIn = false;
                        for(DataBank sdb:saveBankList){
                            if(StringUtils.equals(db.getJYSJ(),sdb.getJYSJ())
                                    && StringUtils.equals(db.getCXDXMC(),sdb.getCXDXMC())
                                    && StringUtils.equals(db.getJYYE(),sdb.getJYYE())
                                    && StringUtils.equals(db.getJYJE(),sdb.getJYJE())){
                                isIn = true;
                            }
                        }
                        if(!isIn){
                            saveBankList.add(db);
                            Double tv = 0.0;
                            if(db.getJYJE() != null && !db.getJYJE().equals("")){
                                tv = Double.parseDouble(db.getJYJE());
                            }
                            if (tv > 0) {
                                if (tv > perMinMoney) {
                                    jeCHU += tv;
                                    chuIds.add(db.getId());
                                }
                            } else {
                                if (tv < -perMinMoney) {
                                    jeJIN += tv;
                                    jinIds.add(db.getId());
                                }
                            }
                        }
                    }

                    // save Lines 反向查询 === 保存 进 的记录
                    if (jeJIN != 0) {
                        String key = ssnode.getId() + "-" + eenode.getId();
                        JSONObject tmp = finalMap.get(key);
                        if (tmp != null) {
//                            Double je = tmp.getDouble("je");
//                            JSONArray ids = tmp.getJSONArray("ids");
//                            je += jeJIN;
//                            for (int i=0;i<jinIds.size();i++) {
//                                ids.add(jinIds.getInteger(i));
//                            }
//                            tmp.put("je", je);
//                            tmp.put("ids", ids);
//                            finalMap.put(key, tmp);
                        } else {
                            JSONObject oout = new JSONObject();
                            oout.put("je", jeJIN);
                            oout.put("ids", jinIds);
                            finalMap.put(key, oout);
                        }

                    }
                    if (jeCHU != 0) {
                        String key = eenode.getId() + "-" + ssnode.getId();
                        JSONObject tmp = finalMap.get(key);
                        if (tmp != null) {
//                            Double je = tmp.getDouble("je");
//                            JSONArray ids = tmp.getJSONArray("ids");
//                            je += jeCHU;
//                            for (int i=0;i<chuIds.size();i++) {
//                                ids.add(chuIds.getInteger(i));
//                            }
//                            tmp.put("je", je);
//                            tmp.put("ids", ids);
//                            finalMap.put(key, tmp);
                        } else {
                            JSONObject oout = new JSONObject();
                            oout.put("je", jeCHU);
                            oout.put("ids", chuIds);
                            finalMap.put(key, oout);
                        }

                    }
                }
            }
        }



        QueryWrapper <DataGaQsgx> qsgxQueryWrapper = new QueryWrapper<>();
        for(DataGaRydzda p: persons) {
            if(p.getSfMbr() == null || !p.getSfMbr()) {
                continue;
            }
            queryWrapper.clear();
            // 查询亲属关系中projectId为projectId,XM1为p.getXM()或XM2为p.getXM()的数据，并且gx为密切人
            queryWrapper.eq("project_id", projectId).and(wrapper -> wrapper.eq("xm1", p.getXM()).or().eq("xm2", p.getXM())).eq("gx", "密切人");
            List<DataGaQsgx> qsgxList1 = qsgxService.list(queryWrapper);
//            if(qsgxList1.size()==0){
//                // 判断是否目标人
//                if(p.getSfMbr() == null || !p.getSfMbr()) {
//                    continue;
//                }
//            }

            // 取project_id为projectId的数据，并且gx为密切人，XM1为p.getXM()或XM2为p.getXM()的数据
            qsgxQueryWrapper.clear();
            qsgxQueryWrapper.eq("project_id", projectId);
            qsgxQueryWrapper.eq("gx", "密切人");
            qsgxQueryWrapper.and(wrapper -> wrapper.eq("XM1", p.getXM()).or().eq("XM2", p.getXM()));
            List<DataGaQsgx> qsgxs = qsgxService.list(qsgxQueryWrapper);

            // 循环qsgxs
            for(DataGaQsgx qsgx: qsgxs) {
                // graphNode中是否包含xm1和xm2
                String xm1 = qsgx.getXM1();
                String xm2 = qsgx.getXM2();
                Integer xm1Id = GetNameId(xm1, persons);
                Integer xm2Id = GetNameId(xm2, persons);

                if(xm1Id == null || xm2Id == null) {
                    continue;
                }

                if (!xm1Id.equals(p.getId())) {
                    DataGaRydzda mqr = rydzdaService.getById(xm1Id);
                    allMQR.add(mqr);
                } else if (!xm2Id.equals(p.getId())) {
                    DataGaRydzda mqr = rydzdaService.getById(xm2Id);
                    allMQR.add(mqr);
                }

                GraphNode xm1Node = nodeService.GetNodeByNodeIdAndType(projectId, xm1Id, "PERSON");
                GraphNode xm2Node = nodeService.GetNodeByNodeIdAndType(projectId, xm2Id, "PERSON");
                if(xm1Node == null) {
                    xm1Node = new GraphNode();
                    xm1Node.setNodeName(xm1);
                    xm1Node.setNodeId(xm1Id);
                    xm1Node.setNodeType("PERSON");
                    xm1Node.setProjectId(projectId);
                    xm1Node.setGroupId(mbGroup);
                    xm1Node.setNodeLevel(MQR_GS_LEVEL);
                    xm1Node.setNodeColor(MQR_GS_CORLOR);
                    nodeService.save(xm1Node);
                }
                if(xm2Node == null) {
                    xm2Node = new GraphNode();
                    xm2Node.setNodeName(xm2);
                    xm2Node.setNodeId(xm2Id);
                    xm2Node.setNodeType("PERSON");
                    xm2Node.setProjectId(projectId);
                    xm2Node.setGroupId(mbGroup);
                    xm2Node.setNodeLevel(MQR_GS_LEVEL);
                    xm2Node.setNodeColor(MQR_GS_CORLOR);
                    nodeService.save(xm2Node);
                }

                // 保存关系
                GraphLine line = new GraphLine();
                line.setSid(xm1Node.getId());
                line.setEid(xm2Node.getId());
                line.setName("密切人");
                line.setRelationIds(qsgx.getId().toString());
                line.setProjectId(projectId);
                line.setGroupId(mbGroup);
                line.setLineType("NORMAL");
                lineService.save(line);

            }
        }

        // 新增亲属关系

        finalMap = saveCompanyLS(allMBR, allMQR, banks, qyjbxxes, persons, projectId, finalMap, allQsgxList);

        // 保存线
        Set<String> keyID = finalMap.keySet();
        for(String kk: keyID) {
            JSONObject obj = finalMap.get(kk);
            String[] kks = kk.split("-");

            GraphLine line = new GraphLine();
            line.setSid(Integer.parseInt(kks[0]));
            line.setEid(Integer.parseInt(kks[1]));
            line.setName(obj.getString("je"));
            line.setRelationIds(getIdsByArray(obj.getJSONArray("ids")));
            line.setProjectId(projectId);
            line.setGroupId(mbGroup);
            line.setLineType("NORMAL");
            lineService.save(line);
        }
    }

    /////////////////////////////////////////保存自己转自己的信息
    private void SaveSelfData(List<DataBank> banks, Integer projectId, Integer nodeId) {
        String nodeType = "SELF";

        List<DataBank> savedList = new ArrayList<>();

        JSONObject res = new JSONObject();

        for (DataBank b: banks) {
            String sourceKh = GetBankBFKH(b);
            String targetKh = GetBankJYDFKH(b);
            if (sourceKh.equals(targetKh)) {
                continue;
            }
            GraphNode snode = nodeService.GetNodeByNodeNameAndType(projectId, sourceKh, nodeType);
            if (snode == null) {
                snode = new GraphNode();
                snode.setNodeName(sourceKh);
                snode.setNodeType(nodeType);
                snode.setNodeId(nodeId);
                snode.setProjectId(projectId);
                snode.setGroupId(0);
                snode.setNodeColor(QT_CORLOR);
                snode.setNodeLevel(FXDX_QT_LEVEL);
                nodeService.save(snode);
            }
            ////
            GraphNode dnode = nodeService.GetNodeByNodeNameAndType(projectId, targetKh, nodeType);
            if (dnode == null) {
                dnode = new GraphNode();
                dnode.setNodeName(targetKh);
                dnode.setNodeType(nodeType);
                dnode.setNodeId(nodeId);
                dnode.setProjectId(projectId);
                dnode.setGroupId(0);
                dnode.setNodeColor(QT_CORLOR);
                dnode.setNodeLevel(FXDX_QT_LEVEL);
                nodeService.save(dnode);
            }
            /////判断重复数据
            boolean isIn = false;
            for(DataBank sdb:savedList){
                if(StringUtils.equals(b.getJYSJ(),sdb.getJYSJ())
                        && StringUtils.equals(b.getCXDXMC(),sdb.getCXDXMC())
                        && StringUtils.equals(b.getJYYE(),sdb.getJYYE())
                        && StringUtils.equals(b.getJYJE(),sdb.getJYJE())){
                    isIn = true;
                }
            }
            if(!isIn){
                String jsonKey = sourceKh + "-" + targetKh;
                JSONObject obj = res.getJSONObject(jsonKey);
                if (obj == null) {
                    obj = new JSONObject();
                    obj.put("JEJIN", 0.0);
                    obj.put("JECHU", 0.0);
                    obj.put("SID", snode.getId());
                    obj.put("EID", dnode.getId());
                    obj.put("BankIDSJIN", new JSONArray());
                    obj.put("BankIDSCHU", new JSONArray());
                }
                Double JEJIN = obj.getDouble("JEJIN");
                Double JECHU = obj.getDouble("JECHU");
                JSONArray BankIDSJIN = obj.getJSONArray("BankIDSJIN");
                JSONArray BankIDSCHU = obj.getJSONArray("BankIDSCHU");
                savedList.add(b);
                Double tv = 0.0;
                if(b.getJYJE() != null && !b.getJYJE().equals("")){
                    tv = Double.parseDouble(b.getJYJE());
                }
                if (tv > 0) {
                    JEJIN += tv;
                    BankIDSJIN.add(b.getId());
                } else {
                    JECHU += tv;
                    BankIDSCHU.add(b.getId());
                }
                obj.put("JEJIN", JEJIN);
                obj.put("JECHU", JECHU);
                obj.put("BankIDSJIN", BankIDSJIN);
                obj.put("BankIDSCHU", BankIDSCHU);
                res.put(jsonKey, obj);
            }

        }
        // save lines
        Set<String> keys = res.keySet();
        for(String k: keys) {
            JSONObject obj = res.getJSONObject(k);
            Double jeJIN = obj.getDouble("JEJIN");
            Double jeCHU = obj.getDouble("JECHU");
            Integer sid = obj.getInteger("SID");
            Integer eid = obj.getInteger("EID");
            JSONArray jinIdsJA = obj.getJSONArray("BankIDSJIN");
            JSONArray chuIdsJA = obj.getJSONArray("BankIDSCHU");
            List<Integer> jinIds = new ArrayList<>();
            List<Integer> chuIds = new ArrayList<>();
            for(int i=0;i<jinIdsJA.size();i++) {
                jinIds.add(jinIdsJA.getInteger(i));
            }
            for(int i=0;i<chuIdsJA.size();i++) {
                chuIds.add(chuIdsJA.getInteger(i));
            }
            // save Lines
            if (jeJIN != 0) {
                GraphLine lineJIN = new GraphLine();
                lineJIN.setSid(eid);
                lineJIN.setEid(sid);
                lineJIN.setName(jeJIN.toString());
                lineJIN.setRelationIds(getIdsByList(jinIds));
                lineJIN.setProjectId(projectId);
                lineJIN.setGroupId(0);
                lineJIN.setLineType(nodeType);
                lineService.save(lineJIN);
            }
            if (jeCHU != 0) {
                GraphLine lineCHU = new GraphLine();
                lineCHU.setSid(sid);
                lineCHU.setEid(eid);
                lineCHU.setName(jeCHU.toString());
                lineCHU.setRelationIds(getIdsByList(chuIds));
                lineCHU.setProjectId(projectId);
                lineCHU.setGroupId(0);
                lineCHU.setLineType(nodeType);
                lineService.save(lineCHU);
            }
        }
    }
    private String GetBankBFKH(DataBank bk) {
        String res = "NULL";

        String kh = bk.getBFKH();
        if (kh != null && !kh.equals("")) {
            res = kh;
        }
        String zh = bk.getBFZH();
        if (zh != null && !zh.equals("")) {
            res = zh;
        }
        return res;
    }
    private String GetBankJYDFKH(DataBank bk) {
        String res = "NULL";

        String kh = bk.getJYDFKH();
        if (kh != null && !kh.equals("")) {
            res = kh;
        }
        String zh = bk.getJYDFZH();
        if (zh != null && !zh.equals("")) {
            res = zh;
        }
        return res;
    }
    //////////////////////////////////////////

    private boolean isFxdxQy(List<DataGaQydjxxQyjbxx> pointQYFXDX, DataGaQydjxxQyjbxx qy) {
        boolean isfx = false;
        for (DataGaQydjxxQyjbxx q: pointQYFXDX) {
            if (q.getId().equals(qy.getId())) {
                isfx = true;
                break;
            }
        }
        return isfx;
    }
    private DataGaQydjxxQyjbxx getqyById(List<DataGaQydjxxQyjbxx> qyjbxxes, Integer id) {
        DataGaQydjxxQyjbxx qy = null;
        for (DataGaQydjxxQyjbxx q: qyjbxxes) {
            if (q.getId().equals(id)) {
                qy = q;
                break;
            }
        }
        return qy;
    }
    ////////////////////////////////////////公司相关的流水保存
    private Map<String, JSONObject> saveCompanyLS(List<DataGaRydzda> mbrs, List<DataGaRydzda> mqrs, List<DataBank> banks, List<DataGaQydjxxQyjbxx> qyjbxxes, List<DataGaRydzda> persons, Integer projectId, Map<String, JSONObject> finalMap, List<DataGaQsgx> allQsgxList) {
        // 目标人和密切人的公司筛查===
        List<DataGaQydjxxQyjbxx> pointQY = new ArrayList<>();
        List<DataGaQydjxxQyjbxx> pointQYFXDX = new ArrayList<>();

        for(DataGaRydzda p: mbrs) {
            for(DataGaQydjxxQyjbxx qy: qyjbxxes) {
                String mc = qy.getMC();
                String fr = qy.getFDDBR();
                String fname = "";
                if (fr != null && !fr.equals("")) {
                    fname = fr;
                }
                if (fname.equals("") && mc != null && !mc.equals("")) {
                    fname = mc;
                }
                if (p.getXM().equals(fname)) {
                    GraphNode pnode = nodeService.GetNodeByNodeIdAndType(projectId, p.getId(), "PERSON");
                    if (pnode != null) {
                        qy.setUserId(pnode.getId());
                    }
                    pointQY.add(qy);
                    // 分析对象的公司需要特出处理
                    if (p.getSfFxdx() != null && p.getSfFxdx()) {
                        pointQYFXDX.add(qy);
                    }
                }
            }
        }
        for(DataGaRydzda p: mqrs) {
            for(DataGaQydjxxQyjbxx qy: qyjbxxes) {
                String mc = qy.getMC();
                String fr = qy.getFDDBR();
                String fname = "";
                if (fr != null && !fr.equals("")) {
                    fname = fr;
                }
                if (mc != null && !mc.equals("")) {
                    fname = mc;
                }
                if (p.getXM().equals(fname)) {
                    GraphNode pnode = nodeService.GetNodeByNodeIdAndType(projectId, p.getId(), "PERSON");
                    if (pnode != null) {
                        qy.setUserId(pnode.getId());
                    }
                    pointQY.add(qy);
                }
            }
        }
        // 正向查
        for(DataGaQydjxxQyjbxx qy: pointQY) {
            String name = qy.getQYJGMC();
            if (name == null || name.equals("")) {
                continue;
            }

            GraphNode snode = nodeService.GetNodeByNodeIdAndType(projectId, qy.getId(), "COMPANY");
            if(snode == null) {
                snode = new GraphNode();
                snode.setNodeName(name);
                snode.setNodeId(qy.getId());
                snode.setNodeType("COMPANY-MB");
                snode.setProjectId(projectId);
                snode.setGroupId(0);
                if (!isFxdxQy(pointQYFXDX, qy)) {
                    snode.setNodeLevel(MQR_GS_LEVEL);
                    snode.setNodeColor(MQR_GS_CORLOR);
                } else {
                    snode.setNodeLevel(FXDX_QT_LEVEL);
                    snode.setNodeColor(FXDX_CORLOR);
                }
                nodeService.save(snode);
            } else {
                if (!isFxdxQy(pointQYFXDX, qy)) {
                    snode.setNodeLevel(MQR_GS_LEVEL);
                    snode.setNodeColor(MQR_GS_CORLOR);
                } else {
                    snode.setNodeLevel(FXDX_QT_LEVEL);
                    snode.setNodeColor(FXDX_CORLOR);
                }
                snode.setNodeType("COMPANY-MB");
                nodeService.updateById(snode);
            }

            // 保存关系
            GraphLine line = lineService.GetlineMod(projectId, snode.getId(), qy.getUserId(), "公司所有人");
            if (line == null) {
                line = new GraphLine();
                line.setSid(snode.getId());
                line.setEid(qy.getUserId());
                line.setName("公司所有人");
                line.setRelationIds("");
                line.setProjectId(projectId);
                line.setGroupId(0);
                line.setLineType("NORMAL");
                lineService.save(line);
            }


            // 公司和其他人的流水信息
            String nullName = "空(" + name + ")";
            Map<String, List<DataBank>> mapBanks = GroupMbrBankInfo(banks, name, nullName);
            Set<String> mapKeys = mapBanks.keySet();

            for(String k: mapKeys) {
                JSONObject nodeInfo = GetNodeType(k, persons, qyjbxxes, projectId);
                Integer sId = nodeInfo.getInteger("Id");
                Integer dnodeId = nodeInfo.getInteger("nodeId");//GetNameId(k, persons);
                String dnodeType = nodeInfo.getString("nodeType");
                if(dnodeType.equals("COMPANY")) {
                    dnodeType = "COMPANY";
                }

                GraphNode dnode = null;
                if (dnodeId != null) {
                    dnode = nodeService.GetNodeByNodeIdAndType(projectId, dnodeId, dnodeType, k);
                }
                if (sId != null) {
                    dnode = nodeService.getById(sId);
                }
                if (dnode == null) {
                    dnode = new GraphNode();
                    dnode.setNodeName(k);
                    dnode.setNodeType(dnodeType);
                    dnode.setNodeId(dnodeId);
                    dnode.setProjectId(projectId);
                    dnode.setGroupId(0);
                    /////////////////
                    if (dnodeType.equals("NULL")) {
                        dnode.setNodeColor(QT_CORLOR);
                        dnode.setNodeLevel(FXDX_QT_LEVEL);
                    } else if(dnodeType.equals("PERSON")) {
                        // 判断是目标人，密切人，分析对象，普通人
                        String personType = JudgePersonType(persons, mbrs, allQsgxList, dnodeId);
                        // NULL, MBR, FXDX, MQR, QT
                        if (personType.equals("NULL")) {
                            dnode.setNodeColor(QT_CORLOR);
                            dnode.setNodeLevel(FXDX_QT_LEVEL);
                        } else if (personType.equals("MBR")) {
                            dnode.setNodeColor(MBR_CORLOR);
                            dnode.setNodeLevel(MBR_LEVEL);
                        } else if (personType.equals("MQR")) {
                            dnode.setNodeColor(MQR_GS_CORLOR);
                            dnode.setNodeLevel(MQR_GS_LEVEL);
                        } else if (personType.equals("FXDX")) {
                            dnode.setNodeColor(FXDX_CORLOR);
                            dnode.setNodeLevel(FXDX_QT_LEVEL);
                        } else if (personType.equals("QT")) {
                            dnode.setNodeColor(QT_CORLOR);
                            dnode.setNodeLevel(FXDX_QT_LEVEL);
                        }
                    } else if (dnodeType.equals("COMPANY")) {
                        ///////////////////////
                        DataGaQydjxxQyjbxx qy2 = getqyById(qyjbxxes, dnodeId);
                        if (qy2 != null && !isFxdxQy(pointQYFXDX, qy2)) {
                            dnode.setNodeColor(MQR_GS_CORLOR);
                            dnode.setNodeLevel(MQR_GS_LEVEL);
                        } else {
                            snode.setNodeLevel(FXDX_QT_LEVEL);
                            snode.setNodeColor(FXDX_CORLOR);
                        }
                    }
                    nodeService.save(dnode);
                }

                Double jeJIN = 0.0;
                JSONArray jinIds = new JSONArray();
                Double jeCHU = 0.0;
                JSONArray chuIds = new JSONArray();

                List <DataBank> saveBankList = new ArrayList<>();
                for (DataBank db : mapBanks.get(k)) {
                    boolean isIn = false;
                    for(DataBank sdb:saveBankList){
                        /*if(db.getJYSJ()==sdb.getJYSJ()&&db.getCXDXMC()==sdb.getCXDXMC()&&db.getJYYE().equals((sdb.getJYYE()))){*/
                        if(StringUtils.equals(db.getJYSJ(),sdb.getJYSJ())
                                && StringUtils.equals(db.getCXDXMC(),sdb.getCXDXMC())
                                && StringUtils.equals(db.getJYYE(),sdb.getJYYE())
                                && StringUtils.equals(db.getJYJE(),sdb.getJYJE())){
                            isIn = true;
                        }
                    }
                    if(!isIn){
                        saveBankList.add(db);
                        Double tv = 0.0;
                        if(db.getJYJE() != null && !db.getJYJE().equals("")){
                            tv = Double.parseDouble(db.getJYJE());
                        }
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
                }

                if (jeJIN != 0) {
                    String key = dnode.getId() + "-" + snode.getId();
                    JSONObject tmp = finalMap.get(key);
                    if (tmp != null) {
//                        Double je = tmp.getDouble("je");
//                        JSONArray ids = tmp.getJSONArray("ids");
//                        je += jeJIN;
//                        for (int i=0;i<jinIds.size();i++) {
//                            ids.add(jinIds.getInteger(i));
//                        }
//                        tmp.put("je", je);
//                        tmp.put("ids", ids);
//                        finalMap.put(key, tmp);
                    } else {
                        JSONObject oout = new JSONObject();
                        oout.put("je", jeJIN);
                        oout.put("ids", jinIds);
                        finalMap.put(key, oout);
                    }
                }
                if (jeCHU != 0) {
                    String key = snode.getId() + "-" + dnode.getId();
                    JSONObject tmp = finalMap.get(key);
                    if (tmp != null) {
//                        Double je = tmp.getDouble("je");
//                        JSONArray ids = tmp.getJSONArray("ids");
//                        je += jeCHU;
//                        for (int i=0;i<chuIds.size();i++) {
//                            ids.add(chuIds.getInteger(i));
//                        }
//                        tmp.put("je", je);
//                        tmp.put("ids", ids);
//                        finalMap.put(key, tmp);
                    } else {
                        JSONObject oout = new JSONObject();
                        oout.put("je", jeCHU);
                        oout.put("ids", chuIds);
                        finalMap.put(key, oout);
                    }
                }
            }
        }
        // 反向查
        String nullName = "空";
        for(DataGaQydjxxQyjbxx qy: pointQY) {
            String name = qy.getQYJGMC();
            if (name == null || name.equals("")) {
                continue;
            }
            nullName = "空(" + name + ")";
            Map<String, List<DataBank>> mapBanks = new HashMap<>();
            for (DataBank bk : banks) {
                String tmpMc = bk.getJYDFMC();
                if(tmpMc == null) {
                    tmpMc = "";
                }
                if(tmpMc.equals(name)) {
                    JSONObject dfNameObj = this.GetMCReverse(bk);
                    String dfName = dfNameObj.getString("value");
                    if (dfName == null) {
                        dfName = "";
                    }
                    if(dfName.equals("")) {
                        if(!mapBanks.containsKey(nullName)) {
                            mapBanks.put(nullName, new ArrayList<>());
                        }
                        List<DataBank> arr = mapBanks.get(nullName);
                        arr.add(bk);
                    } else {
                        if(!mapBanks.containsKey(dfName)) {
                            mapBanks.put(dfName, new ArrayList<>());
                        }
                        List<DataBank> arr = mapBanks.get(dfName);
                        arr.add(bk);
                    }
                }
            }
            Set<String> keys = mapBanks.keySet();

            GraphNode eenode = nodeService.GetNodeByNodeIdAndType(projectId, qy.getId(), "COMPANY");
            if (eenode == null) {
                eenode = new GraphNode();
                eenode.setNodeName(name);
                eenode.setNodeId(qy.getId());
                eenode.setNodeType("COMPANY-MB");
                eenode.setProjectId(projectId);
                eenode.setGroupId(0);
                if (!isFxdxQy(pointQYFXDX, qy)) {
                    eenode.setNodeLevel(MQR_GS_LEVEL);
                    eenode.setNodeColor(MQR_GS_CORLOR);
                } else {
                    eenode.setNodeLevel(FXDX_QT_LEVEL);
                    eenode.setNodeColor(FXDX_CORLOR);
                }
                nodeService.save(eenode);
            } else {
                if (!isFxdxQy(pointQYFXDX, qy)) {
                    eenode.setNodeLevel(MQR_GS_LEVEL);
                    eenode.setNodeColor(MQR_GS_CORLOR);
                } else {
                    eenode.setNodeLevel(FXDX_QT_LEVEL);
                    eenode.setNodeColor(FXDX_CORLOR);
                }
                eenode.setNodeType("COMPANY-MB");
                nodeService.updateById(eenode);
            }

            // 保存关系
            GraphLine line = lineService.GetlineMod(projectId, eenode.getId(), qy.getUserId(), "公司所有人");
            if (line == null) {
                line = new GraphLine();
                line.setSid(eenode.getId());
                line.setEid(qy.getUserId());
                line.setName("公司所有人");
                line.setRelationIds("");
                line.setProjectId(projectId);
                line.setGroupId(0);
                line.setLineType("NORMAL");
                lineService.save(line);
            }

            // keys====对方的流水出现的
            for (String k: keys) {
                JSONObject nodeInfo = GetNodeType(k, persons, qyjbxxes, projectId);
                Integer ssId = nodeInfo.getInteger("Id");
                Integer ssNodeId = nodeInfo.getInteger("nodeId");//GetNameId(k, persons);
                String dnodeType = nodeInfo.getString("nodeType");
                if(dnodeType.equals("COMPANY")) {
                    dnodeType = "COMPANY";
                }

                GraphNode ssnode = null;
                if (ssNodeId != null) {
                    ssnode = nodeService.GetNodeByNodeIdAndType(projectId, ssNodeId, dnodeType, k);
                }
                if (ssId != null) {
                    ssnode = nodeService.getById(ssId);
                }
                if (ssnode == null) {
                    ssnode = new GraphNode();
                    ssnode.setNodeName(k);
                    ssnode.setNodeType(dnodeType);
                    ssnode.setNodeId(ssNodeId);
                    ssnode.setProjectId(projectId);
                    ssnode.setGroupId(0);
                    /////////////////
                    if (dnodeType.equals("NULL")) {
                        ssnode.setNodeColor(QT_CORLOR);
                        ssnode.setNodeLevel(FXDX_QT_LEVEL);
                    } else if(dnodeType.equals("PERSON")) {
                        // 判断是目标人，密切人，分析对象，普通人
                        String personType = JudgePersonType(persons, mbrs, allQsgxList, ssNodeId);
                        // NULL, MBR, FXDX, MQR, QT
                        if (personType.equals("NULL")) {
                            ssnode.setNodeColor(QT_CORLOR);
                            ssnode.setNodeLevel(FXDX_QT_LEVEL);
                        } else if (personType.equals("MBR")) {
                            ssnode.setNodeColor(MBR_CORLOR);
                            ssnode.setNodeLevel(MBR_LEVEL);
                        } else if (personType.equals("MQR")) {
                            ssnode.setNodeColor(MQR_GS_CORLOR);
                            ssnode.setNodeLevel(MQR_GS_LEVEL);
                        } else if (personType.equals("FXDX")) {
                            ssnode.setNodeColor(FXDX_CORLOR);
                            ssnode.setNodeLevel(FXDX_QT_LEVEL);
                        } else if (personType.equals("QT")) {
                            ssnode.setNodeColor(QT_CORLOR);
                            ssnode.setNodeLevel(FXDX_QT_LEVEL);
                        }
                    } else if (dnodeType.equals("COMPANY")) {
                        DataGaQydjxxQyjbxx qy2 = getqyById(qyjbxxes, ssNodeId);
                        if (qy2 != null && !isFxdxQy(pointQYFXDX, qy2)) {
                            ssnode.setNodeColor(MQR_GS_CORLOR);
                            ssnode.setNodeLevel(MQR_GS_LEVEL);
                        } else {
                            ssnode.setNodeLevel(FXDX_QT_LEVEL);
                            ssnode.setNodeColor(FXDX_CORLOR);
                        }
                    }
                    nodeService.save(ssnode);
                }
                Double jeJIN = 0.0;
                JSONArray jinIds = new JSONArray();
                Double jeCHU = 0.0;
                JSONArray chuIds = new JSONArray();

                List <DataBank> saveBankList = new ArrayList<>();
                for (DataBank db : mapBanks.get(k)) {
                    boolean isIn = false;
                    for(DataBank sdb:saveBankList){
                        if(StringUtils.equals(db.getJYSJ(),sdb.getJYSJ())
                                && StringUtils.equals(db.getCXDXMC(),sdb.getCXDXMC())
                                && StringUtils.equals(db.getJYYE(),sdb.getJYYE())
                                && StringUtils.equals(db.getJYJE(),sdb.getJYJE())){
                            isIn = true;
                        }
                    }
                    if(!isIn){
                        saveBankList.add(db);
                        Double tv = 0.0;
                        if(db.getJYJE() != null && !db.getJYJE().equals("")){
                            tv = Double.parseDouble(db.getJYJE());
                        }
                        if (tv > 0) {
                            if (tv > perMinMoney) {
                                jeCHU += tv;
                                chuIds.add(db.getId());
                            }
                        } else {
                            if (tv < -perMinMoney) {
                                jeJIN += tv;
                                jinIds.add(db.getId());
                            }
                        }
                    }
                }

                // save Lines
                if (jeJIN != 0) {
                    String key = ssnode.getId() + "-" + eenode.getId();
                    JSONObject tmp = finalMap.get(key);
                    if (tmp != null) {
//                        Double je = tmp.getDouble("je");
//                        JSONArray ids = tmp.getJSONArray("ids");
//                        je += jeJIN;
//                        for (int i=0;i<jinIds.size();i++) {
//                            ids.add(jinIds.getInteger(i));
//                        }
//                        tmp.put("je", je);
//                        tmp.put("ids", ids);
//                        finalMap.put(key, tmp);
                    } else {
                        JSONObject oout = new JSONObject();
                        oout.put("je", jeJIN);
                        oout.put("ids", jinIds);
                        finalMap.put(key, oout);
                    }
                }
                if (jeCHU != 0) {
                    String key = eenode.getId() + "-" + ssnode.getId();
                    JSONObject tmp = finalMap.get(key);
                    if (tmp != null) {
//                        Double je = tmp.getDouble("je");
//                        JSONArray ids = tmp.getJSONArray("ids");
//                        je += jeCHU;
//                        for (int i=0;i<chuIds.size();i++) {
//                            ids.add(chuIds.getInteger(i));
//                        }
//                        tmp.put("je", je);
//                        tmp.put("ids", ids);
//                        finalMap.put(key, tmp);
                    } else {
                        JSONObject oout = new JSONObject();
                        oout.put("je", jeCHU);
                        oout.put("ids", chuIds);
                        finalMap.put(key, oout);
                    }
                }
            }
        }

        ///
        return finalMap;

    }

    private boolean IsMQR(List<DataGaRydzda> mbrs, List<DataGaQsgx> qsgxList, DataGaRydzda checkPerson){
        boolean isMbr = false;
        for(DataGaRydzda p: mbrs) {
            if (p.getId().equals(checkPerson.getId())) {
                isMbr = true;
            }
        }
        if (isMbr) {
            return false;
        }

        boolean isExist = false;
        for(DataGaQsgx q: qsgxList) {
            if (q.getXM1().equals(checkPerson.getXM()) || q.getXM2().equals(checkPerson.getXM())){
                isExist = true;
            }
        }
        if (!isExist) {
            return false;
        }

        boolean isMrq = false;
        for(DataGaQsgx q: qsgxList) {
            String xm1 = q.getXM1();
            String xm2 = q.getXM2();
            for (DataGaRydzda p : mbrs) {
                String mbName = p.getXM();
                String mb2Name = checkPerson.getXM();
                if((xm1.equals(mbName) && xm2.equals(mb2Name)) || xm2.equals(mbName) && xm1.equals(mb2Name)) {
                    isMrq = true;
                }
            }
        }
        return isMrq;
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

    private Map<String, List<DataBank>> GroupMbrBankInfoRevers(List<DataBank> banks, String mbrName, String nullName) {
        Map<String, List<DataBank>> zd = new HashMap<>();
        for (DataBank bk : banks) {
            String tmpMc = bk.getJYDFMC();
            if(tmpMc == null) {
                tmpMc = "";
            }
            if(tmpMc.equals(mbrName)) {
                JSONObject dfNameObj = this.GetMCReverse(bk);
                String dfName = dfNameObj.getString("value");
                if (dfName == null) {
                    dfName = "";
                }
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
        return zd;
    }
    private Map<String, List<DataBank>> GroupMbrBankInfo(List<DataBank> banks, String mbrName, String nullName) {
        Map<String, List<DataBank>> zd = new HashMap<>();

        for (DataBank bk : banks) {
            String mcstr = bk.getMC();
            if (mcstr == null) {
                mcstr = "";
            }
            if(mcstr.equals(mbrName)) {
                JSONObject dfNameObj = this.GetJYDFMC(bk);
                String dfName = dfNameObj.getString("value");
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
        return zd;
    }

    private JSONObject GetJYDFMC(DataBank bk) {
        String mc = bk.getJYDFMC();
        JSONObject res = new JSONObject();
        if (mc != null && !mc.equals("")) {
            res.put("type", "MC");
            res.put("value", mc);
        } else {
            String kh = bk.getJYDFKH();
            if (kh != null && !kh.equals("")) {
                res.put("type", "KH");
                res.put("value", kh);
            } else {
                String zh = bk.getJYDFZH();
                if (zh != null && !zh.equals("")) {
                    res.put("type", "ZH");
                    res.put("value", zh);
                } else {
                    res.put("type", "NULL");
                    res.put("value", "");
                }
            }
        }
        return res;
    }
    private JSONObject GetMCReverse(DataBank bk) {
        String mc = bk.getMC();
        JSONObject res = new JSONObject();
        if (mc != null && !mc.equals("")) {
            res.put("type", "MC");
            res.put("value", mc);
        } else {
            String kh = bk.getBFKH();
            if (kh != null && !kh.equals("")) {
                res.put("type", "KH");
                res.put("value", kh);
            } else {
                String zh = bk.getBFZH();
                if (zh != null && !zh.equals("")) {
                    res.put("type", "ZH");
                    res.put("value", zh);
                } else {
                    res.put("type", "NULL");
                    res.put("value", "");
                }
            }
        }
        return res;
    }

    private JSONObject GetNodeType(String name, List<DataGaRydzda> persons, List<DataGaQydjxxQyjbxx> qyjbxxes, Integer projectId) {
        JSONObject obj = new JSONObject();
        String nodeType = "NULL";
        Integer nodeId = null;
        Integer Id = null;

        GraphNode node = nodeService.GetNodeByNodeNameAndTypeNotSELF(projectId, name, null);
        if (node != null) {
            nodeType = node.getNodeType();
            nodeId = node.getNodeId();
            Id = node.getId();
        } else {

            for (DataGaRydzda p : persons) {
                if (name.equals(p.getXM())) {
                    nodeType = "PERSON";
                    nodeId = p.getId();
                    break;
                }
            }
            if (nodeType.equals("NULL")) {
                for (DataGaQydjxxQyjbxx p : qyjbxxes) {
                    if (name.trim().equals(p.getQYJGMC().trim())) {
                        nodeType = "COMPANY";
                        nodeId = p.getId();
                        break;
                    }
                }
            }
        }
        obj.put("nodeType", nodeType);
        obj.put("nodeId", nodeId);
        obj.put("Id", Id);
        return obj;
    }

    @GetMapping("selfresults")
    @ApiOperation(value = "计算关系图结果-自己转自己", notes = "计算关系图结果-自己转自己")
    public ResponseData GetRelationSELF(Integer projectId, Integer userId){
        List<GraphNode> nodes = nodeService.GetNodeList(projectId, userId, "SELF");
        List<GraphLine> lines = lineService.GetLineList(projectId, "SELF");

        JSONObject result = new JSONObject();
        JSONArray resNodes = new JSONArray();
        JSONArray resLines = new JSONArray();


        List<Integer> nodeids = new ArrayList<>();
        for(GraphNode node: nodes) {
            JSONObject obj = new JSONObject();
            obj.put("groupId", node.getGroupId());
            obj.put("id", node.getId());
            obj.put("nodeType", node.getNodeType());
            obj.put("nodeId", node.getNodeId());
            obj.put("nodeName", node.getNodeName());
            obj.put("nodeGroup", node.getNodeGroup());
            resNodes.add(obj);
            nodeids.add(node.getId());
        }

        for(GraphLine line: lines) {
            for (Integer id: nodeids) {
                if (id.equals(line.getSid()) || id.equals(line.getEid())) {
                    continue;
                }
            }

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
            List<DataBank> datas2 = new ArrayList<>();
            for(DataBank data : datas){
                if(datas2.size() == 0){
                    datas2.add(data);
                }else{
                    boolean isExist = false;
                    for(DataBank data2 : datas2){
                        if(StringUtils.equals(data.getJYSJ(),data2.getJYSJ())
                                && StringUtils.equals(data.getCXDXMC(),data2.getCXDXMC())
                                && StringUtils.equals(data.getJYJE(),data2.getJYJE())
                                && StringUtils.equals(data.getJYYE(),data2.getJYYE())){
                            isExist = true;
                        }
                    }
                    if(!isExist){
                        datas2.add(data);
                    }
                }
            }
            obj.put("relation", datas2);
            resLines.add(obj);
        }
        result.put("nodes", resNodes);
        result.put("lines", resLines);
        return ResponseData.OK(result);
    }

    private GraphNode GetNodeById(Integer nodeId, List<GraphNode> nodes) {
        GraphNode node = null;
        for (GraphNode n: nodes) {
            if (nodeId.equals(n.getId())) {
                node = n;
                break;
            }
        }
        return node;
    }

    @GetMapping("results")
    @ApiOperation(value = "计算关系图结果", notes = "计算关系图结果")
    public ResponseData GetRelation(Integer projectId){
        List<GraphNode> nodes = nodeService.GetNodeListNOTSELF(projectId);
        List<GraphLine> lines = lineService.GetLineListNOTSELF(projectId);

        QueryWrapper <DataGaQsgx> queryWrapper = new QueryWrapper<>();

        JSONArray ns = new JSONArray();
        for(GraphNode node: nodes) {
            JSONObject obj = new JSONObject();
            obj.put("groupId", node.getGroupId());
            obj.put("id", node.getId());
            obj.put("nodeType", node.getNodeType());
            obj.put("nodeId", node.getNodeId());
            obj.put("nodeName", node.getNodeName());
            obj.put("nodeGroup", node.getNodeGroup());
            obj.put("nodeLevel", node.getNodeLevel());
            obj.put("nodeColor", node.getNodeColor());
            DataGaRydzda user = rydzdaService.getById(node.getNodeId());
            if (user != null) {
                queryWrapper.clear();
                queryWrapper.eq("project_id", projectId).and(wrapper -> wrapper.eq("xm1", user.getXM()).or().eq("xm2", user.getXM())).eq("gx", "密切人");
                List <DataGaQsgx> qsgxList = qsgxService.list(queryWrapper);
                if(qsgxList.size()>0){
                    user.setSfMbr(true);
                }
                obj.put("user", user);
            } else {
                obj.put("user", null);
            }
            DataGaQydjxxQyjbxx fx = qyjbxxService.getById(node.getNodeId());
            if (fx != null) {
                obj.put("company", fx);
            } else {
                obj.put("company", null);
            }


            // 获取该人详细信息
            QueryWrapper<DataGaZrzybqgFdcq> fdcqQueryWrapper = new QueryWrapper<>();
            fdcqQueryWrapper.eq("project_id", projectId);
            fdcqQueryWrapper.eq("mc", node.getNodeName());
            obj.put("fdcq", fdcqService.list(fdcqQueryWrapper));


            QueryWrapper <DataGaQydjxxZyry> qydjxxZyryQueryWrapper = new QueryWrapper<>();
            qydjxxZyryQueryWrapper.eq("project_id", projectId);
            qydjxxZyryQueryWrapper.eq("mc", node.getNodeName());
            obj.put("gs",zyryService.list(qydjxxZyryQueryWrapper));

            QueryWrapper <DataGaQsgx> qsgxQueryWrapper = new QueryWrapper<>();
            qsgxQueryWrapper.eq("project_id", projectId);
            qsgxQueryWrapper.ne("gx", "密切人").and(wrapper -> wrapper.eq("xm1", node.getNodeName()).or().eq("xm2", node.getNodeName()));
            obj.put("qsgx", qsgxService.list(qsgxQueryWrapper));

            QueryWrapper <DataGaQsgx> mqrQueryWrapper = new QueryWrapper<>();
            mqrQueryWrapper.eq("project_id", projectId);
            mqrQueryWrapper.eq("gx", "密切人").and(wrapper -> wrapper.eq("xm1", node.getNodeName()).or().eq("xm2", node.getNodeName()));
            obj.put("mqr", qsgxService.list(mqrQueryWrapper));

            QueryWrapper <DataGaJrjgzhZhjbxx> zhjbxxQueryWrapper = new QueryWrapper<>();
            zhjbxxQueryWrapper.eq("project_id", projectId);
            zhjbxxQueryWrapper.eq("mc", node.getNodeName());
            obj.put("yhk", zhjbxxService.list(zhjbxxQueryWrapper));

            QueryWrapper <DataGaZrzybqgDyq> dyqQueryWrapper = new QueryWrapper<>();
            dyqQueryWrapper.eq("project_id", projectId);
            dyqQueryWrapper.eq("mc", node.getNodeName());
            obj.put("dyq", dyqService.list(dyqQueryWrapper));

            QueryWrapper <DataGaBxxxBxbdxx> bxxxBxbdxxQueryWrapper = new QueryWrapper<>();
            bxxxBxbdxxQueryWrapper.eq("project_id", projectId);
            bxxxBxbdxxQueryWrapper.eq("zrrdxmc", node.getNodeName());
            obj.put("bxbd", bxxxBxbdxxService.list(bxxxBxbdxxQueryWrapper));

            QueryWrapper <DataGaZqxxCyxx> cyxxQueryWrapper = new QueryWrapper<>();
            cyxxQueryWrapper.eq("project_id", projectId);
            cyxxQueryWrapper.eq("xm", node.getNodeName());

            List<DataGaZqxxCyxx> cyxxList = cyxxService.list(cyxxQueryWrapper);
            List<DataGaZqxxCyxx> cyxxList2 = new ArrayList<>();
            for(DataGaZqxxCyxx cyxx : cyxxList){
                if(cyxxList2.size() == 0){
                    cyxxList2.add(cyxx);
                }else{
                    boolean isExist = false;
                    for(DataGaZqxxCyxx cyxx2 : cyxxList2){
                        if(cyxx.getZQDM()!=null&&cyxx2.getZQDM()!=null&&cyxx.getZQDM().equals(cyxx2.getZQDM())){
                            isExist = true;
                            if(cyxx.getCYRQ().compareTo(cyxx2.getCYRQ()) > 0){
                                cyxxList2.remove(cyxx2);
                                cyxxList2.add(cyxx);
                            }
                        }else{
                            isExist = false;
                        }
                    }
                    if(!isExist){
                        cyxxList2.add(cyxx);
                    }
                }
            }
            obj.put("cyxx", cyxxList2);

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

            Integer sid = line.getSid();
            Integer eid = line.getEid();
            if (sid == null || eid == null) {
                continue;
            }
            GraphNode snode = GetNodeById(sid, nodes);
            GraphNode enode = GetNodeById(eid, nodes);
            if (snode == null || enode == null) {
                continue;
            }
            Integer slevel = snode.getNodeLevel();
            Integer elevel = enode.getNodeLevel();
            if (slevel != null && elevel != null) {
                if (slevel > elevel) {
                    obj.put("lineColor", "red");
                } else {
                    obj.put("lineColor", "blue");
                }
            }

            String ids = line.getRelationIds();
            String[] idarrStr = ids.split(",");
            List<String> idArr = new ArrayList<>();
            for(String i: idarrStr) {
                idArr.add(i);
            }
            List<DataBank> datas = bankService.listByIds(idArr);
            List<DataBank> datas2 = new ArrayList<>();
            for(DataBank data : datas){
                if(datas2.size() == 0){
                    datas2.add(data);
                }else{
                    boolean isExist = false;
                    for(DataBank data2 : datas2){
                        /*&&
                        data.getJYDFZH()!=data2.getJYDFZH()
                        &&
                        data.getBFKH()!=data2.getBFKH()*/
                        if(StringUtils.equals(data.getJYSJ(),data2.getJYSJ())
                                && StringUtils.equals(data.getCXDXMC(),data2.getCXDXMC())
                                && StringUtils.equals(data.getJYJE(),data2.getJYJE())
                                && StringUtils.equals(data.getJYYE(),data2.getJYYE())){
                            isExist = true;
                        }
                    }
                    if(!isExist){
                        datas2.add(data);
                    }
                }
            }

            obj.put("relation", datas2);
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

    private String getIdsByArray(JSONArray arr) {
        String str = "";
        for(int i=0;i<arr.size();i++) {
            String id = arr.getString(i);
            str += id + ",";
        }
        if (!str.equals("")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}
