package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaJrlc;
import com.bjd.smartanalysis.mapper.data.DataGaJrlcMapper;
import com.bjd.smartanalysis.service.data.DataGaJrlcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaJrlcServiceImpl extends ServiceImpl<DataGaJrlcMapper, DataGaJrlc> implements DataGaJrlcService {
    @Autowired
    DataGaJrlcMapper mapper;

    @Override
    public List<DataGaJrlc> GetAllPerson(String xm) {
        IPage<DataGaJrlc> page = new Page<>(1, 10);
        QueryWrapper<DataGaJrlc> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaJrlc> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaJrlc> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaJrlc GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaJrlc> queryWrapper = new QueryWrapper<>();
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
