package com.bjd.smartanalysis.excellistener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaRydzda;
import com.bjd.smartanalysis.service.data.DataGaRydzdaService;
import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DataGaListener<T> extends AnalysisEventListener<T> {
    private IService service;
    private List<T> list = new ArrayList<>();
    private Integer projectId;

    public DataGaListener(IService service, Integer projectId) {
        this.service = service;
        this.projectId = projectId;
    }

    @Override
    public void invoke(T o, AnalysisContext analysisContext) {
        try {
            Class curClass = o.getClass();
            Field curField = curClass.getDeclaredField("projectId");
            if (curField != null) {
                curField.setAccessible(true);
                curField.set(o, this.projectId);
            }
        }catch (Exception ex){
        }
        list.add(o);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        service.saveBatch(list);
    }
}
