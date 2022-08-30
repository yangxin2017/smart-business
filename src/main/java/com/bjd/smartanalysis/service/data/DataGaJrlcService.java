package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaJrlc;

import java.util.List;

public interface DataGaJrlcService extends IService<DataGaJrlc> {
    public List<DataGaJrlc> GetAllPerson(String xm);
    public List<DataGaJrlc> GetAllPersonList(Integer projectId, String xm);

    public DataGaJrlc GetPersonByName(Integer projectId, String xm);
}
