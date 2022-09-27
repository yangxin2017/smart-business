package com.bjd.smartanalysis.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

import java.util.*;

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

    private Double perMinMoney = 1000.0;

    @GetMapping("relation")
    @ApiOperation(value = "计算关系图", notes = "计算关系图")
    public ResponseData CalcRelation(Integer projectId) {
        List<DataGaRydzda> persons = rydzdaService.GetAllPersonList(projectId, "");
        List<DataGaJgfrxx> companys = jgfrxxService.GetAllCompany(projectId);
        List<DataBank> banks = bankService.GetAllBanks(projectId);
        for(DataBank db: banks) {
            if(db.getJYJE() == null || db.getJYJE().equals("")) {
                db.setJYYE("0");
            }
        }
        ///////
        nodeService.RemoveByProjectId(projectId);
        lineService.RemoveByProjectId(projectId);
        resultService.RemoveByProjectId(projectId);
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
        Integer nodeGroup = 0;

        // 获取亲属关系表中project_id为projectId的所有数据
        List<DataGaQsgx> qsgxList = qsgxService.GetAllPersonList(projectId, "");
        List<DataGaQsgx> allQsgxList = qsgxService.GetAllPersonList(projectId, "");
        QueryWrapper <DataGaQsgx> queryWrapper = new QueryWrapper <>();

        List<DataGaRydzda> allMBR = new ArrayList<>();
        for (DataGaRydzda p: persons) {
            if(p.getSfMbr() != null && p.getSfMbr()) {
                allMBR.add(p);
            }
        }

        for(DataGaRydzda p: persons) {
            boolean ismrq = IsMQR(allMBR, allQsgxList, p);
            // 判断是否目标人
            if(p.getSfMbr() == null || !p.getSfMbr()) {
                if(!ismrq) {
                    continue;
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
            String nullName = "空";
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
                nodeService.save(snode);
            }
            // k 包含 ：对方用户名（公司名）、卡号、账号、空
            for (String k: keys) {
                // 自己给自己转账。。暂不处理
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
                    for (DataBank db : zd.get(k)) {
                        // Double tv = Double.parseDouble(db.getJYJE());
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
                GraphNode xm1Node = nodeService.GetNodeByNodeIdAndType(projectId, xm1Id, "PERSON");
                GraphNode xm2Node = nodeService.GetNodeByNodeIdAndType(projectId, xm2Id, "PERSON");
                if(xm1Node == null) {
                    xm1Node = new GraphNode();
                    xm1Node.setNodeName(xm1);
                    xm1Node.setNodeId(xm1Id);
                    xm1Node.setNodeType("PERSON");
                    xm1Node.setProjectId(projectId);
                    xm1Node.setGroupId(mbGroup);
                    nodeService.save(xm1Node);
                }
                if(xm2Node == null) {
                    xm2Node = new GraphNode();
                    xm2Node.setNodeName(xm2);
                    xm2Node.setNodeId(xm2Id);
                    xm2Node.setNodeType("PERSON");
                    xm2Node.setProjectId(projectId);
                    xm2Node.setGroupId(mbGroup);
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
                lineService.save(line);

            }


        }
        // 新增亲属关系


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
            DataGaJgfrxx fx = jgfrxxService.getById(node.getNodeId());
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
//            // 如果line.getName()转为float类型小于0
//            if (Float.parseFloat(line.getName()) < 0) {
//                line.setName(Float.parseFloat(line.getName()) * -1 + "");
//                obj.put("sid", line.getEid());
//                obj.put("eid", line.getSid());
//            }else{
//                obj.put("sid", line.getSid());
//                obj.put("eid", line.getEid());
//            }
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
}
