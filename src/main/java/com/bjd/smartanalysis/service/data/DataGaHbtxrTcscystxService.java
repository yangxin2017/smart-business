package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaHbtxrTcscystx;

import java.util.List;

public interface DataGaHbtxrTcscystxService extends IService<DataGaHbtxrTcscystx> {
    public List<DataGaHbtxrTcscystx> GetAllPerson(String xm);
    public List<DataGaHbtxrTcscystx> GetAllPersonList(Integer projectId, String xm);

    public DataGaHbtxrTcscystx GetPersonByName(Integer projectId, String xm);
}
