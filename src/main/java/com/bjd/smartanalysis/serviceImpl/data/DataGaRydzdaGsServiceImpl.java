package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaRydzdaGs;
import com.bjd.smartanalysis.mapper.data.DataGaRydzdaGsMapper;
import com.bjd.smartanalysis.service.data.DataGaRydzdaGsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaRydzdaGsServiceImpl extends ServiceImpl<DataGaRydzdaGsMapper, DataGaRydzdaGs> implements DataGaRydzdaGsService {
    @Autowired
    private DataGaRydzdaGsMapper mapper;

    @Override
    public List<DataGaRydzdaGs> GetListByUserId(Integer userId) {
        QueryWrapper<DataGaRydzdaGs> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return mapper.selectList(queryWrapper);
    }
}
