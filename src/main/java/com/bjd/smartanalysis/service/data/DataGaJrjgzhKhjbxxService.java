package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaJrjgzhKhjbxx;

import java.util.List;

public interface DataGaJrjgzhKhjbxxService extends IService<DataGaJrjgzhKhjbxx> {
    public List<DataGaJrjgzhKhjbxx> GetAllPerson(String xm);
    public List<DataGaJrjgzhKhjbxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaJrjgzhKhjbxx GetPersonByName(Integer projectId, String xm);
}
