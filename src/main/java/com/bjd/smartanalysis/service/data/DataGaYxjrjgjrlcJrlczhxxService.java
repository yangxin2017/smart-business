package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaYxjrjgjrlcJrlczhxx;

import java.util.List;

public interface DataGaYxjrjgjrlcJrlczhxxService extends IService<DataGaYxjrjgjrlcJrlczhxx> {
    public List<DataGaYxjrjgjrlcJrlczhxx> GetAllPerson(String xm);
    public List<DataGaYxjrjgjrlcJrlczhxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaYxjrjgjrlcJrlczhxx GetPersonByName(Integer projectId, String xm);
}
