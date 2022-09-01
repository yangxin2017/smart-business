package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaHlwzcxxCylxrxx;

import java.util.List;

public interface DataGaHlwzcxxCylxrxxService extends IService<DataGaHlwzcxxCylxrxx> {
    public List<DataGaHlwzcxxCylxrxx> GetAllPerson(String xm);
    public List<DataGaHlwzcxxCylxrxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaHlwzcxxCylxrxx GetPersonByName(Integer projectId, String xm);
}
