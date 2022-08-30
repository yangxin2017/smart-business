package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaBxxxBxryxx;

import java.util.List;

public interface DataGaBxxxBxryxxService extends IService<DataGaBxxxBxryxx> {
    public List<DataGaBxxxBxryxx> GetAllPerson(String xm);
    public List<DataGaBxxxBxryxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaBxxxBxryxx GetPersonByName(Integer projectId, String xm);
}
