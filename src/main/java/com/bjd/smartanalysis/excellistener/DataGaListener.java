package com.bjd.smartanalysis.excellistener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaQsgx;
import com.bjd.smartanalysis.entity.data.DataGaRydzda;
import com.bjd.smartanalysis.entity.data.SysErrorView;
import com.bjd.smartanalysis.service.data.DataBankService;
import com.bjd.smartanalysis.service.data.DataGaQsgxService;
import com.bjd.smartanalysis.service.data.DataGaRydzdaService;
import com.bjd.smartanalysis.service.data.SysErrorViewService;
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
                rydzdaService.isExist(projectId, rydzda);
                if(!rydzdaService.isExist(projectId,(DataGaRydzda)o)){
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
            }else{
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
                for (int i = 0; i < list.size(); i++) {
                    saveList.add(list.get(i));
                }
            }
        }
        service.saveBatch(saveList);
    }
}
