package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaBxxxBxryxx;
import com.bjd.smartanalysis.mapper.data.DataGaBxxxBxryxxMapper;
import com.bjd.smartanalysis.service.data.DataGaBxxxBxryxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaBxxxBxryxxServiceImpl extends ServiceImpl<DataGaBxxxBxryxxMapper, DataGaBxxxBxryxx> implements DataGaBxxxBxryxxService {
    @Autowired
    DataGaBxxxBxryxxMapper mapper;

    @Override
    public List<DataGaBxxxBxryxx> GetAllPerson(String xm) {
        IPage<DataGaBxxxBxryxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaBxxxBxryxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaBxxxBxryxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaBxxxBxryxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaBxxxBxryxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaBxxxBxryxx> queryWrapper = new QueryWrapper<>();
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
