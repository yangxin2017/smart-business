package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaZqxxCybdxx;

import java.util.List;

public interface DataGaZqxxCybdxxService extends IService<DataGaZqxxCybdxx> {
    public List<DataGaZqxxCybdxx> GetAllPerson(String xm);
    public List<DataGaZqxxCybdxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaZqxxCybdxx GetPersonByName(Integer projectId, String xm);
}
