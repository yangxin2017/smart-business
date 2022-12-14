package com.bjd.smartanalysis.excellistener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.*;
import com.bjd.smartanalysis.service.data.*;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DataGaListener<T> extends AnalysisEventListener<T> {
    private DataGaRydzdaService rydzdaService;
    private DataGaQsgxService qsgxService;
    private IService service;
    private List<T> list = new ArrayList<>();
    private Integer projectId;
    private Integer eid;
    private SysErrorViewService errorViewService;

    private boolean isGS = false;

    public DataGaListener(IService service, Integer projectId,Integer eid,SysErrorViewService errorViewService) {
        this.service = service;
        this.projectId = projectId;
        this.eid = eid;
        this.errorViewService = errorViewService;
    }
    public DataGaListener(IService service, Integer projectId) {
        this.service = service;
        this.projectId = projectId;
    }

    @Override
    public void invoke(T o, AnalysisContext analysisContext) {
        try {
            Class curClass = o.getClass();
            Field curField = curClass.getDeclaredField("projectId");
            String name = curClass.getName();
            if (curField != null) {
                curField.setAccessible(true);
                curField.set(o, this.projectId);
            }
            if(curClass.getName().equals("com.bjd.smartanalysis.entity.data.DataGaRydzda")){
                this.rydzdaService = (DataGaRydzdaService) service;
                DataGaRydzda rydzda = (DataGaRydzda) o;
                // 调用service方法
                // 如果姓名数据库中存在，那么更新数据的数据
                DataGaRydzda ex = rydzdaService.GetPersonByName(projectId, rydzda.getXM());
                if (ex != null) {
                    rydzda.setSfMbr(ex.getSfMbr());
                    rydzda.setSFZH(ex.getSFZH());
                    rydzda.setId(ex.getId());
                    rydzdaService.updateById(rydzda);
                } else {
                    list.add(o);
                }

            } else if (curClass.getName().equals("com.bjd.smartanalysis.entity.data.DataGaQsgx")) {
                this.qsgxService = (DataGaQsgxService) service;
                if(!qsgxService.isExist(projectId,(DataGaQsgx)o)){
                    list.add(o);
                }else{
                    // 修改掉XM1为o.XM1并且XM2为o.XM2的数据
                    QueryWrapper<DataGaQsgx> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq("XM1", ((DataGaQsgx) o).getXM1());
                    queryWrapper.eq("XM2", ((DataGaQsgx) o).getXM2());
                    DataGaQsgx dataGaQsgx = qsgxService.getOne(queryWrapper);
                    dataGaQsgx.setXM1(((DataGaQsgx) o).getXM1());
                    dataGaQsgx.setXM2(((DataGaQsgx) o).getXM2());
                    dataGaQsgx.setGX(((DataGaQsgx) o).getGX());
                    dataGaQsgx.setSFZH1(((DataGaQsgx) o).getSFZH1());
                    dataGaQsgx.setSFZH2(((DataGaQsgx) o).getSFZH2());
                    qsgxService.updateById(dataGaQsgx);
                }
            } else if (curClass.getName().equals("com.bjd.smartanalysis.entity.data.DataGaJrjgzhZhjbxx")) {
                DataGaJrjgzhZhjbxxService ss = (DataGaJrjgzhZhjbxxService) service;
                DataGaJrjgzhZhjbxx jbxx = (DataGaJrjgzhZhjbxx) o;
                DataGaJrjgzhZhjbxx ex = ss.GetOne(projectId, jbxx.getMC(), jbxx.getKH());
                if (ex != null) {
                    jbxx.setId(ex.getId());
                    ss.updateById(jbxx);
                } else {
                    list.add(o);
                }
            } else if (curClass.getSimpleName().equals("DataGaGsDjxx")) {
                isGS = true;
                list.add(o);
            } else {
                list.add(o);
            }
            /*list.add(o);*/
        }catch (Exception ex){
            System.out.println(ex);
        }

        /*QueryWrapper<T> queryWrapper = new QueryWrapper<>(o);
        Object exist = service.getOne(queryWrapper);
        if(exist == null){
            list.add(o);
        }*/
        /*list.add(o);*/
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        ArrayList saveList = new ArrayList();
        // 判断导入的数据中是否包含sfzh为空的数据
        if(list.size() > 0){
            if(list.get(0).getClass().getName().equals("com.bjd.smartanalysis.entity.data.DataGaRydzda")){
                for (int i = 0; i < list.size(); i++) {
                    DataGaRydzda rydzda = (DataGaRydzda) list.get(i);
                    if(rydzda.getSFZH() == null || rydzda.getSFZH().equals("")){
                        // 在数据库中保存错误信息
                        Integer a = this.projectId;
                        Integer b = this.eid;
                        errorViewService.saveError(0, eid,"身份证号为空",rydzda.getXM());
                    }else{
                        Boolean isnotin = true;
                        // 查询saveList中是否包含sfzh为list.get(i)的sfzh的数据，如果有则跳过
                        for (int j = 0; j < saveList.size(); j++) {
                            DataGaRydzda rydzda1 = (DataGaRydzda) saveList.get(j);
                            if(rydzda1.getSFZH().equals(rydzda.getSFZH())){
                                isnotin = false;
                            }
                        }
                        if(isnotin){
                            saveList.add(list.get(i));
                        }
                    }
                }
            }else{

                if(isGS) {
                    if (list.size() > 1) {
                        DataGaGsDjxx gs = (DataGaGsDjxx)list.get(0);

                        if (gs != null) {
                            if (list.size() > 2) {
                                for (int i = 2; i < list.size(); i++) {
                                    DataGaGsDjxx gsTMP = (DataGaGsDjxx)list.get(i);

                                    DataGaGsDjxx gs1 = new DataGaGsDjxx();
                                    gs1.setProjectId(gs.getProjectId());
                                    gs1.setXM(gs.getXM());
                                    gs1.setZJLX(gs.getZJLX());
                                    gs1.setZJHM(gs.getZJHM());
                                    gs1.setNSRSBH(gs.getNSRSBH());
                                    gs1.setJZDZ(gs.getJZDZ());
                                    gs1.setDZYX(gs.getDZYX());
                                    gs1.setDHHM(gs.getDHHM());
                                    gs1.setDWMC(gsTMP.getZJLX());
                                    gs1.setZWMC(gsTMP.getZJHM());
                                    saveList.add(gs1);
                                }
                            } else {
                                saveList.add(gs);
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        saveList.add(list.get(i));
                    }
                }
            }
        }
        service.saveBatch(saveList);
    }
}
