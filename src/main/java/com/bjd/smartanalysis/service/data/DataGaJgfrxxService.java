package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaJgfrxx;

import java.util.List;

public interface DataGaJgfrxxService extends IService<DataGaJgfrxx> {
    public  DataGaJgfrxx GetDataByXM(String xm);

    public List<DataGaJgfrxx> GetAllCompany(Integer projectId);
}
