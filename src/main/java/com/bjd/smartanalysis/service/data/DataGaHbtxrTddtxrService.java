package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaHbtxrTddtxr;

import java.util.List;

public interface DataGaHbtxrTddtxrService extends IService<DataGaHbtxrTddtxr> {
    public List<DataGaHbtxrTddtxr> GetAllPerson(String xm);
    public List<DataGaHbtxrTddtxr> GetAllPersonList(Integer projectId, String xm);

    public DataGaHbtxrTddtxr GetPersonByName(Integer projectId, String xm);
}
