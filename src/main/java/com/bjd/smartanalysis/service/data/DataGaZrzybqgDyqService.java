package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaZrzybqgDyq;

import java.util.List;

public interface DataGaZrzybqgDyqService extends IService<DataGaZrzybqgDyq> {
    public List<DataGaZrzybqgDyq> GetAllPerson(String xm);
    public List<DataGaZrzybqgDyq> GetAllPersonList(Integer projectId, String xm);

    public DataGaZrzybqgDyq GetPersonByName(Integer projectId, String xm);
}
