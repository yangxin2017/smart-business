package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaJrjgzhGlzzhxx;

import java.util.List;

public interface DataGaJrjgzhGlzzhxxService extends IService<DataGaJrjgzhGlzzhxx> {
    public List<DataGaJrjgzhGlzzhxx> GetAllPerson(String xm);
    public List<DataGaJrjgzhGlzzhxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaJrjgzhGlzzhxx GetPersonByName(Integer projectId, String xm);
}
