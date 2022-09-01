package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaZrzybqgFdcq;
import com.bjd.smartanalysis.mapper.data.DataGaZrzybqgFdcqMapper;
import com.bjd.smartanalysis.service.data.DataGaZrzybqgFdcqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaZrzybqgFdcqServiceImpl extends ServiceImpl<DataGaZrzybqgFdcqMapper, DataGaZrzybqgFdcq> implements DataGaZrzybqgFdcqService {
    @Autowired
    DataGaZrzybqgFdcqMapper mapper;

    @Override
    public List<DataGaZrzybqgFdcq> GetAllPerson(String xm) {
        IPage<DataGaZrzybqgFdcq> page = new Page<>(1, 10);
        QueryWrapper<DataGaZrzybqgFdcq> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaZrzybqgFdcq> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaZrzybqgFdcq> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaZrzybqgFdcq GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaZrzybqgFdcq> queryWrapper = new QueryWrapper<>();
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
