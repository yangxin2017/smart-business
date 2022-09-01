package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxZxxx;

import java.util.List;

public interface DataGaQydjxxZxxxService extends IService<DataGaQydjxxZxxx> {
    public List<DataGaQydjxxZxxx> GetAllPerson(String xm);
    public List<DataGaQydjxxZxxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaQydjxxZxxx GetPersonByName(Integer projectId, String xm);
}
