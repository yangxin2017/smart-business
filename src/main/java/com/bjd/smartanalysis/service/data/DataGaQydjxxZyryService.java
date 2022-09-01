package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxZyry;

import java.util.List;

public interface DataGaQydjxxZyryService extends IService<DataGaQydjxxZyry> {
    public List<DataGaQydjxxZyry> GetAllPerson(String xm);
    public List<DataGaQydjxxZyry> GetAllPersonList(Integer projectId, String xm);

    public DataGaQydjxxZyry GetPersonByName(Integer projectId, String xm);
}
