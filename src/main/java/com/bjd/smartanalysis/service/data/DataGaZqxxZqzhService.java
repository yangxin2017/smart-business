package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaZqxxZqzh;

import java.util.List;

public interface DataGaZqxxZqzhService extends IService<DataGaZqxxZqzh> {
    public List<DataGaZqxxZqzh> GetAllPerson(String xm);
    public List<DataGaZqxxZqzh> GetAllPersonList(Integer projectId, String xm);

    public DataGaZqxxZqzh GetPersonByName(Integer projectId, String xm);
}
