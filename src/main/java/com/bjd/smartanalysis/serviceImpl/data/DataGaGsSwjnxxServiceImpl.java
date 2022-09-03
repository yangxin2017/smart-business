package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaGsSwjnxx;
import com.bjd.smartanalysis.mapper.data.DataGaGsSwjnxxMapper;
import com.bjd.smartanalysis.service.data.DataGaGsSwjnxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaGsSwjnxxServiceImpl extends ServiceImpl<DataGaGsSwjnxxMapper, DataGaGsSwjnxx> implements DataGaGsSwjnxxService {
    @Autowired
    DataGaGsSwjnxxMapper mapper;

    @Override
    public List<DataGaGsSwjnxx> GetAllPerson(String xm) {
        IPage<DataGaGsSwjnxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaGsSwjnxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaGsSwjnxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaGsSwjnxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaGsSwjnxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaGsSwjnxx> queryWrapper = new QueryWrapper<>();
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
