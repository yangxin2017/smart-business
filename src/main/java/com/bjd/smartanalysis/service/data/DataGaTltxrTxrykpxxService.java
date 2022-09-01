package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaTltxrTxrykpxx;

import java.util.List;

public interface DataGaTltxrTxrykpxxService extends IService<DataGaTltxrTxrykpxx> {
    public List<DataGaTltxrTxrykpxx> GetAllPerson(String xm);
    public List<DataGaTltxrTxrykpxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaTltxrTxrykpxx GetPersonByName(Integer projectId, String xm);
}
