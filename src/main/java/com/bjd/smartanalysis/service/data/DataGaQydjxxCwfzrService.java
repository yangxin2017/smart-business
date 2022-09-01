package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxCwfzr;

import java.util.List;

public interface DataGaQydjxxCwfzrService extends IService<DataGaQydjxxCwfzr> {
    public List<DataGaQydjxxCwfzr> GetAllPerson(String xm);
    public List<DataGaQydjxxCwfzr> GetAllPersonList(Integer projectId, String xm);

    public DataGaQydjxxCwfzr GetPersonByName(Integer projectId, String xm);
}
