package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaZqxxCybdxx;
import com.bjd.smartanalysis.mapper.data.DataGaZqxxCybdxxMapper;
import com.bjd.smartanalysis.service.data.DataGaZqxxCybdxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaZqxxCybdxxServiceImpl extends ServiceImpl<DataGaZqxxCybdxxMapper, DataGaZqxxCybdxx> implements DataGaZqxxCybdxxService {
    @Autowired
    DataGaZqxxCybdxxMapper mapper;

    @Override
    public List<DataGaZqxxCybdxx> GetAllPerson(String xm) {
        IPage<DataGaZqxxCybdxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaZqxxCybdxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaZqxxCybdxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaZqxxCybdxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaZqxxCybdxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaZqxxCybdxx> queryWrapper = new QueryWrapper<>();
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
