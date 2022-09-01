package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaGsDjxx;
import com.bjd.smartanalysis.mapper.data.DataGaGsDjxxMapper;
import com.bjd.smartanalysis.service.data.DataGaGsDjxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaGsDjxxServiceImpl extends ServiceImpl<DataGaGsDjxxMapper, DataGaGsDjxx> implements DataGaGsDjxxService {
    @Autowired
    DataGaGsDjxxMapper mapper;

    @Override
    public List<DataGaGsDjxx> GetAllPerson(String xm) {
        IPage<DataGaGsDjxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaGsDjxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaGsDjxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaGsDjxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaGsDjxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaGsDjxx> queryWrapper = new QueryWrapper<>();
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
