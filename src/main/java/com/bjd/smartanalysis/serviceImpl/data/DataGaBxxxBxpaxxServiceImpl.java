package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaBxxxBxpaxx;
import com.bjd.smartanalysis.mapper.data.DataGaBxxxBxpaxxMapper;
import com.bjd.smartanalysis.service.data.DataGaBxxxBxpaxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaBxxxBxpaxxServiceImpl extends ServiceImpl<DataGaBxxxBxpaxxMapper, DataGaBxxxBxpaxx> implements DataGaBxxxBxpaxxService {
    @Autowired
    DataGaBxxxBxpaxxMapper mapper;

    @Override
    public List<DataGaBxxxBxpaxx> GetAllPerson(String xm) {
        IPage<DataGaBxxxBxpaxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaBxxxBxpaxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaBxxxBxpaxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaBxxxBxpaxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaBxxxBxpaxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaBxxxBxpaxx> queryWrapper = new QueryWrapper<>();
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
