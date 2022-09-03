package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaGsSwjnxx;

import java.util.List;

public interface DataGaGsSwjnxxService extends IService<DataGaGsSwjnxx> {
    public List<DataGaGsSwjnxx> GetAllPerson(String xm);
    public List<DataGaGsSwjnxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaGsSwjnxx GetPersonByName(Integer projectId, String xm);
}
