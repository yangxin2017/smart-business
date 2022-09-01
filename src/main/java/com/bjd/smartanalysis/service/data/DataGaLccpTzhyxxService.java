package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaLccpTzhyxx;

import java.util.List;

public interface DataGaLccpTzhyxxService extends IService<DataGaLccpTzhyxx> {
    public List<DataGaLccpTzhyxx> GetAllPerson(String xm);
    public List<DataGaLccpTzhyxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaLccpTzhyxx GetPersonByName(Integer projectId, String xm);
}
