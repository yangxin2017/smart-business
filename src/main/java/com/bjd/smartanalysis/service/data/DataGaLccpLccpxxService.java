package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaLccpLccpxx;

import java.util.List;

public interface DataGaLccpLccpxxService extends IService<DataGaLccpLccpxx> {
    public List<DataGaLccpLccpxx> GetAllPerson(String xm);
    public List<DataGaLccpLccpxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaLccpLccpxx GetPersonByName(Integer projectId, String xm);
}
