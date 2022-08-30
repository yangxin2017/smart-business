package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaBxxxJtccbx;

import java.util.List;

public interface DataGaBxxxJtccbxService extends IService<DataGaBxxxJtccbx> {
    public List<DataGaBxxxJtccbx> GetAllPerson(String xm);
    public List<DataGaBxxxJtccbx> GetAllPersonList(Integer projectId, String xm);

    public DataGaBxxxJtccbx GetPersonByName(Integer projectId, String xm);
}
