package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaGsDjxx;

import java.util.List;

public interface DataGaGsDjxxService extends IService<DataGaGsDjxx> {
    public List<DataGaGsDjxx> GetAllPerson(String xm);
    public List<DataGaGsDjxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaGsDjxx GetPersonByName(Integer projectId, String xm);
}
