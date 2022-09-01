package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxBgbaxx;

import java.util.List;

public interface DataGaQydjxxBgbaxxService extends IService<DataGaQydjxxBgbaxx> {
    public List<DataGaQydjxxBgbaxx> GetAllPerson(String xm);
    public List<DataGaQydjxxBgbaxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaQydjxxBgbaxx GetPersonByName(Integer projectId, String xm);
}
