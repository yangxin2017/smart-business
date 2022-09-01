package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaZqxxCyxx;

import java.util.List;

public interface DataGaZqxxCyxxService extends IService<DataGaZqxxCyxx> {
    public List<DataGaZqxxCyxx> GetAllPerson(String xm);
    public List<DataGaZqxxCyxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaZqxxCyxx GetPersonByName(Integer projectId, String xm);
}
