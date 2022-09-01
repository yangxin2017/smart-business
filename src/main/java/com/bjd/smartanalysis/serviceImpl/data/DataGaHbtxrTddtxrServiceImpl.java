package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaHbtxrTddtxr;
import com.bjd.smartanalysis.mapper.data.DataGaHbtxrTddtxrMapper;
import com.bjd.smartanalysis.service.data.DataGaHbtxrTddtxrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaHbtxrTddtxrServiceImpl extends ServiceImpl<DataGaHbtxrTddtxrMapper, DataGaHbtxrTddtxr> implements DataGaHbtxrTddtxrService {
    @Autowired
    DataGaHbtxrTddtxrMapper mapper;

    @Override
    public List<DataGaHbtxrTddtxr> GetAllPerson(String xm) {
        IPage<DataGaHbtxrTddtxr> page = new Page<>(1, 10);
        QueryWrapper<DataGaHbtxrTddtxr> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaHbtxrTddtxr> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaHbtxrTddtxr> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaHbtxrTddtxr GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaHbtxrTddtxr> queryWrapper = new QueryWrapper<>();
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
