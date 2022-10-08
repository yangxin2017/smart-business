package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaJrjgzhZhjbxx;

import java.util.List;

public interface DataGaJrjgzhZhjbxxService extends IService<DataGaJrjgzhZhjbxx> {
    public List<DataGaJrjgzhZhjbxx> GetAllPerson(String xm);
    public List<DataGaJrjgzhZhjbxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaJrjgzhZhjbxx GetOne(Integer projectId, String xm, String kh);

    public DataGaJrjgzhZhjbxx GetPersonByName(Integer projectId, String xm);
}
