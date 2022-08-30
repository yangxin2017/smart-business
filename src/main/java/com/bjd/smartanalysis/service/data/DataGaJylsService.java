package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaJyls;

import java.util.List;

public interface DataGaJylsService extends IService<DataGaJyls> {
    public List<DataGaJyls> GetAllPerson(String xm);
    public List<DataGaJyls> GetAllPersonList(Integer projectId, String xm);

    public DataGaJyls GetPersonByName(Integer projectId, String xm);
}
