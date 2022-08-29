package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaZrzyb;

import java.util.List;

public interface DataGaZrzybService extends IService<DataGaZrzyb> {
    public List<DataGaZrzyb> GetAllPerson(String xm);
    public List<DataGaZrzyb> GetAllPersonList(Integer projectId, String xm);

    public DataGaZrzyb GetPersonByName(Integer projectId, String xm);
}
