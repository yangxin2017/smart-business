package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaRmyhzh;
import com.bjd.smartanalysis.mapper.data.DataGaRmyhzhMapper;
import com.bjd.smartanalysis.service.data.DataGaRmyhzhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaRmyhzhServiceImpl extends ServiceImpl<DataGaRmyhzhMapper, DataGaRmyhzh> implements DataGaRmyhzhService {
    @Autowired
    DataGaRmyhzhMapper mapper;

    @Override
    public List<DataGaRmyhzh> GetAllPerson(String xm) {
        IPage<DataGaRmyhzh> page = new Page<>(1, 10);
        QueryWrapper<DataGaRmyhzh> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaRmyhzh> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaRmyhzh> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaRmyhzh GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaRmyhzh> queryWrapper = new QueryWrapper<>();
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
