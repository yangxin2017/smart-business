package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxCwfzr;
import com.bjd.smartanalysis.mapper.data.DataGaQydjxxCwfzrMapper;
import com.bjd.smartanalysis.service.data.DataGaQydjxxCwfzrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaQydjxxCwfzrServiceImpl extends ServiceImpl<DataGaQydjxxCwfzrMapper, DataGaQydjxxCwfzr> implements DataGaQydjxxCwfzrService {
    @Autowired
    DataGaQydjxxCwfzrMapper mapper;

    @Override
    public List<DataGaQydjxxCwfzr> GetAllPerson(String xm) {
        IPage<DataGaQydjxxCwfzr> page = new Page<>(1, 10);
        QueryWrapper<DataGaQydjxxCwfzr> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaQydjxxCwfzr> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaQydjxxCwfzr> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaQydjxxCwfzr GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaQydjxxCwfzr> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.eq("XM", xm);
        }
        queryWrapper.last("limit 1");
        return mapper.selectOne(queryWrapper);
    }
}
