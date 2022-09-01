package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaHlwzcxxHlwzcxx;

import java.util.List;

public interface DataGaHlwzcxxHlwzcxxService extends IService<DataGaHlwzcxxHlwzcxx> {
    public List<DataGaHlwzcxxHlwzcxx> GetAllPerson(String xm);
    public List<DataGaHlwzcxxHlwzcxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaHlwzcxxHlwzcxx GetPersonByName(Integer projectId, String xm);
}
