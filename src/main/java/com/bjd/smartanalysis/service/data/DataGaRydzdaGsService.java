package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaRydzdaGs;

import java.util.List;

public interface DataGaRydzdaGsService extends IService<DataGaRydzdaGs> {
    public List<DataGaRydzdaGs> GetListByUserId(Integer userId);
}
