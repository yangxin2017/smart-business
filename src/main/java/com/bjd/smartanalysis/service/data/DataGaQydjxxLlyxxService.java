package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxLlyxx;

import java.util.List;

public interface DataGaQydjxxLlyxxService extends IService<DataGaQydjxxLlyxx> {
    public List<DataGaQydjxxLlyxx> GetAllPerson(String xm);
    public List<DataGaQydjxxLlyxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaQydjxxLlyxx GetPersonByName(Integer projectId, String xm);
}
