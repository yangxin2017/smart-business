package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxQscyxx;

import java.util.List;

public interface DataGaQydjxxQscyxxService extends IService<DataGaQydjxxQscyxx> {
    public List<DataGaQydjxxQscyxx> GetAllPerson(String xm);
    public List<DataGaQydjxxQscyxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaQydjxxQscyxx GetPersonByName(Integer projectId, String xm);
}
