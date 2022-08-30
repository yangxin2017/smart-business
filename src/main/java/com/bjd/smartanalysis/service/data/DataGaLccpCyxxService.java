package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaLccpCyxx;

import java.util.List;

public interface DataGaLccpCyxxService extends IService<DataGaLccpCyxx> {
    public List<DataGaLccpCyxx> GetAllPerson(String xm);
    public List<DataGaLccpCyxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaLccpCyxx GetPersonByName(Integer projectId, String xm);
}
