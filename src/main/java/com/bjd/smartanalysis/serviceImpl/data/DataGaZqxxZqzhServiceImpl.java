package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaZqxxZqzh;
import com.bjd.smartanalysis.mapper.data.DataGaZqxxZqzhMapper;
import com.bjd.smartanalysis.service.data.DataGaZqxxZqzhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaZqxxZqzhServiceImpl extends ServiceImpl<DataGaZqxxZqzhMapper, DataGaZqxxZqzh> implements DataGaZqxxZqzhService {
    @Autowired
    DataGaZqxxZqzhMapper mapper;

    @Override
    public List<DataGaZqxxZqzh> GetAllPerson(String xm) {
        IPage<DataGaZqxxZqzh> page = new Page<>(1, 10);
        QueryWrapper<DataGaZqxxZqzh> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaZqxxZqzh> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaZqxxZqzh> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaZqxxZqzh GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaZqxxZqzh> queryWrapper = new QueryWrapper<>();
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
