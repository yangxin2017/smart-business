package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxQyjbxx;

import java.util.List;

public interface DataGaQydjxxQyjbxxService extends IService<DataGaQydjxxQyjbxx> {
    public List<DataGaQydjxxQyjbxx> GetAllPerson(String xm);
    public List<DataGaQydjxxQyjbxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaQydjxxQyjbxx GetPersonByName(Integer projectId, String xm);
}
