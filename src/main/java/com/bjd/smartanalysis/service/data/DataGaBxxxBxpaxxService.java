package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaBxxxBxpaxx;

import java.util.List;

public interface DataGaBxxxBxpaxxService extends IService<DataGaBxxxBxpaxx> {
    public List<DataGaBxxxBxpaxx> GetAllPerson(String xm);
    public List<DataGaBxxxBxpaxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaBxxxBxpaxx GetPersonByName(Integer projectId, String xm);
}
