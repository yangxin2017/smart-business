package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaZrzybqgJsydzjdsyq;

import java.util.List;

public interface DataGaZrzybqgJsydzjdsyqService extends IService<DataGaZrzybqgJsydzjdsyq> {
    public List<DataGaZrzybqgJsydzjdsyq> GetAllPerson(String xm);
    public List<DataGaZrzybqgJsydzjdsyq> GetAllPersonList(Integer projectId, String xm);

    public DataGaZrzybqgJsydzjdsyq GetPersonByName(Integer projectId, String xm);
}
