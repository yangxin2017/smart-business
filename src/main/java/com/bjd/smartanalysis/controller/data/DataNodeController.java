package com.bjd.smartanalysis.controller.data;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjd.smartanalysis.common.ResponseData;
import com.bjd.smartanalysis.entity.data.*;
import com.bjd.smartanalysis.service.data.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "目标人信息", tags = {"目标人信息"})
@RequestMapping("mbrData")
@RestController
public class DataNodeController {
    @Autowired
    private DataGaQsgxService qsgxService;
    @Autowired
    private DataGaRydzdaService rydzdaService;
    @Autowired
    private DataBankService bankService;
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


    @GetMapping("list")
    @ApiOperation(value = "获取数据", notes = "获取数据")
    public ResponseData GetList(Integer projectId) {
        QueryWrapper<DataGaRydzda> queryWrapper = new QueryWrapper<>();
        if(projectId != null){
            queryWrapper.eq("project_id", projectId);
        }
        List list = new ArrayList();
        queryWrapper.eq("sf_mbr", 1);
        List<DataGaRydzda> rydzdaList = rydzdaService.list(queryWrapper);

        for(DataGaRydzda rydzda : rydzdaList){
            JSONObject node = new JSONObject();
            node.put("xm", rydzda.getXM());
            node.put("xb", rydzda.getXB());
            node.put("sfzh", rydzda.getSFZH());
            node.put("zy", rydzda.getZY());
            node.put("csrq", rydzda.getCSRQ());
            node.put("zp", rydzda.getTXZP());
            node.put("user", rydzda);

            // 房产信息
            QueryWrapper <DataGaZrzybqgFdcq> fdcqQueryWrapper = new QueryWrapper<>();
            fdcqQueryWrapper.eq("project_id", projectId);
            fdcqQueryWrapper.eq("mc", rydzda.getXM());
            node.put("fdcq", fdcqService.list(fdcqQueryWrapper));

            // 公司主要成员
            QueryWrapper <DataGaQydjxxZyry> qydjxxZyryQueryWrapper = new QueryWrapper<>();
            qydjxxZyryQueryWrapper.eq("project_id", projectId);
            qydjxxZyryQueryWrapper.eq("mc", rydzda.getXM());
            node.put("gs",zyryService.list(qydjxxZyryQueryWrapper));

            // 亲属关系
            QueryWrapper <DataGaQsgx> qsgxQueryWrapper = new QueryWrapper<>();
            qsgxQueryWrapper.eq("project_id", projectId);
            qsgxQueryWrapper.ne("gx", "密切人").and(wrapper -> wrapper.eq("xm1", rydzda.getXM()).or().eq("xm2", rydzda.getXM()));
            node.put("qsgx", qsgxService.list(qsgxQueryWrapper));

            // 密切人
            QueryWrapper <DataGaQsgx> mqrQueryWrapper = new QueryWrapper<>();
            mqrQueryWrapper.eq("project_id", projectId);
            mqrQueryWrapper.eq("gx", "密切人").and(wrapper -> wrapper.eq("xm1", rydzda.getXM()).or().eq("xm2", rydzda.getXM()));
            node.put("mqr", qsgxService.list(mqrQueryWrapper));

            // 银行卡信息
            QueryWrapper <DataGaJrjgzhZhjbxx> zhjbxxQueryWrapper = new QueryWrapper<>();
            zhjbxxQueryWrapper.eq("project_id", projectId);
            zhjbxxQueryWrapper.eq("mc", rydzda.getXM());
            node.put("yhk", zhjbxxService.list(zhjbxxQueryWrapper));

            // 抵押贷款
            QueryWrapper <DataGaZrzybqgDyq> dyqQueryWrapper = new QueryWrapper<>();
            dyqQueryWrapper.eq("project_id", projectId);
            dyqQueryWrapper.eq("mc", rydzda.getXM());
            node.put("dyq", dyqService.list(dyqQueryWrapper));

            // 保险信息
            QueryWrapper <DataGaBxxxBxbdxx> bxxxBxbdxxQueryWrapper = new QueryWrapper<>();
            bxxxBxbdxxQueryWrapper.eq("project_id", projectId);
            bxxxBxbdxxQueryWrapper.eq("zrrdxmc", rydzda.getXM());
            node.put("bxbd", bxxxBxbdxxService.list(bxxxBxbdxxQueryWrapper));

            // 证券
            QueryWrapper <DataGaZqxxCyxx> cyxxQueryWrapper = new QueryWrapper<>();
            cyxxQueryWrapper.eq("project_id", projectId);
            cyxxQueryWrapper.eq("xm", rydzda.getXM());

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
            node.put("cyxx", cyxxList2);


            list.add(node);
        }

        return ResponseData.OK(list);
    }

    @GetMapping("allPeople")
    @ApiOperation(value = "获取所有人员", notes = "获取所有人员")
    public ResponseData GetAllPeople(Integer projectId) {
        QueryWrapper<DataGaRydzda> queryWrapper = new QueryWrapper<>();
        if(projectId != null){
            queryWrapper.eq("project_id", projectId);
        }
        List<DataGaRydzda> rydzdaList = rydzdaService.list(queryWrapper);

        return ResponseData.OK(rydzdaList);
    }

    @PostMapping("saveMbr")
    @ApiOperation(value = "保存目标人", notes = "保存目标人")
    // 接收两个参数
    public ResponseData SaveMbr(@RequestBody JSONObject params) {
        Integer projectId = params.getInteger("projectId");
        List<Integer> idLists = params.getJSONArray("idLists").toJavaList(Integer.class);

        QueryWrapper<DataGaRydzda> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", projectId);
        // 如果id在idLists中则将sf_mbr设置为1，否则设置为0
        List<DataGaRydzda> rydzdaList = rydzdaService.list(queryWrapper);
        for(DataGaRydzda rydzda : rydzdaList){
            if(idLists.contains(rydzda.getId())){
                rydzda.setSfMbr(true);
            }else{
                rydzda.setSfMbr(false);
            }
            rydzdaService.updateById(rydzda);
        }

        return ResponseData.OK("保存成功！");
    }
}
