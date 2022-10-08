package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.common.PageData;
import com.bjd.smartanalysis.entity.data.DataGaRydzda;

import java.util.List;

public interface DataGaRydzdaService extends IService<DataGaRydzda> {
    public List<DataGaRydzda> GetAllPerson(String xm);
    public List<DataGaRydzda> GetAllPersonList(Integer projectId, String xm);

    public DataGaRydzda GetPersonByName(Integer projectId, String xm);
    public DataGaRydzda GetPersonByName(Integer projectId, String xm, String sfzh);
    //isExist
    public Boolean isExist(Integer projectId,DataGaRydzda dataGaRydzda);
}
