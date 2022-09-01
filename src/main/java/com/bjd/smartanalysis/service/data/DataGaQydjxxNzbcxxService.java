package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxNzbcxx;

import java.util.List;

public interface DataGaQydjxxNzbcxxService extends IService<DataGaQydjxxNzbcxx> {
    public List<DataGaQydjxxNzbcxx> GetAllPerson(String xm);
    public List<DataGaQydjxxNzbcxx> GetAllPersonList(Integer projectId, String xm);

    public DataGaQydjxxNzbcxx GetPersonByName(Integer projectId, String xm);
}
