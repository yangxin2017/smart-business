package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxQsjbxx;

import java.util.List;

public interface DataGaQydjxxQsjbxxService extends IService<DataGaQydjxxQsjbxx> {
    public List<DataGaQydjxxQsjbxx> GetAllPerson(String xm);
    public List<DataGaQydjxxQsjbxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaQydjxxQsjbxx GetPersonByName(Integer projectId, String xm);
}
