package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaZrzybqgFdcq;

import java.util.List;

public interface DataGaZrzybqgFdcqService extends IService<DataGaZrzybqgFdcq> {
    public List<DataGaZrzybqgFdcq> GetAllPerson(String xm);
    public List<DataGaZrzybqgFdcq> GetAllPersonList(Integer projectId, String xm);

    public DataGaZrzybqgFdcq GetPersonByName(Integer projectId, String xm);
}
