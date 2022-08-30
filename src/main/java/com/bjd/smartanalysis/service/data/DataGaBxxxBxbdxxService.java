package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaBxxxBxbdxx;

import java.util.List;

public interface DataGaBxxxBxbdxxService extends IService<DataGaBxxxBxbdxx> {
    public List<DataGaBxxxBxbdxx> GetAllPerson(String xm);
    public List<DataGaBxxxBxbdxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaBxxxBxbdxx GetPersonByName(Integer projectId, String xm);
}
