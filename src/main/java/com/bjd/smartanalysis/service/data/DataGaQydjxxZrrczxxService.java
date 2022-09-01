package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxZrrczxx;

import java.util.List;

public interface DataGaQydjxxZrrczxxService extends IService<DataGaQydjxxZrrczxx> {
    public List<DataGaQydjxxZrrczxx> GetAllPerson(String xm);
    public List<DataGaQydjxxZrrczxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaQydjxxZrrczxx GetPersonByName(Integer projectId, String xm);
}
