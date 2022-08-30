package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaRmyhzh;

import java.util.List;

public interface DataGaRmyhzhService extends IService<DataGaRmyhzh> {
    public List<DataGaRmyhzh> GetAllPerson(String xm);
    public List<DataGaRmyhzh> GetAllPersonList(Integer projectId, String xm);

    public DataGaRmyhzh GetPersonByName(Integer projectId, String xm);
}
