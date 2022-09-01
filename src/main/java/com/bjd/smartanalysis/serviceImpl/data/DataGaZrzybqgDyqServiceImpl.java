package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaZrzybqgDyq;
import com.bjd.smartanalysis.mapper.data.DataGaZrzybqgDyqMapper;
import com.bjd.smartanalysis.service.data.DataGaZrzybqgDyqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaZrzybqgDyqServiceImpl extends ServiceImpl<DataGaZrzybqgDyqMapper, DataGaZrzybqgDyq> implements DataGaZrzybqgDyqService {
    @Autowired
    DataGaZrzybqgDyqMapper mapper;

    @Override
    public List<DataGaZrzybqgDyq> GetAllPerson(String xm) {
        IPage<DataGaZrzybqgDyq> page = new Page<>(1, 10);
        QueryWrapper<DataGaZrzybqgDyq> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaZrzybqgDyq> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaZrzybqgDyq> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaZrzybqgDyq GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaZrzybqgDyq> queryWrapper = new QueryWrapper<>();
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
