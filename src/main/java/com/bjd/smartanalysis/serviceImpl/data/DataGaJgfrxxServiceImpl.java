package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaJgfrxx;
import com.bjd.smartanalysis.mapper.data.DataGaJgfrxxMapper;
import com.bjd.smartanalysis.service.data.DataGaJgfrxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaJgfrxxServiceImpl extends ServiceImpl<DataGaJgfrxxMapper, DataGaJgfrxx> implements DataGaJgfrxxService {
    @Autowired
    private DataGaJgfrxxMapper mapper;

    @Override
    public DataGaJgfrxx GetDataByXM(String xm) {
        QueryWrapper<DataGaJgfrxx> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("XM", xm);
        queryWrapper.last("limit 1");
        return mapper.selectOne(queryWrapper);
    }

    @Override
    public List<DataGaJgfrxx> GetAllCompany(Integer projectId) {
        QueryWrapper<DataGaJgfrxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        return mapper.selectList(queryWrapper);
    }
}
