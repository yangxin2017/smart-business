package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaTltxrTxryxx;

import java.util.List;

public interface DataGaTltxrTxryxxService extends IService<DataGaTltxrTxryxx> {
    public List<DataGaTltxrTxryxx> GetAllPerson(String xm);
    public List<DataGaTltxrTxryxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaTltxrTxryxx GetPersonByName(Integer projectId, String xm);
}
