package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaBxxxBxbdxx;
import com.bjd.smartanalysis.mapper.data.DataGaBxxxBxbdxxMapper;
import com.bjd.smartanalysis.service.data.DataGaBxxxBxbdxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaBxxxBxbdxxServiceImpl extends ServiceImpl<DataGaBxxxBxbdxxMapper, DataGaBxxxBxbdxx> implements DataGaBxxxBxbdxxService {
    @Autowired
    DataGaBxxxBxbdxxMapper mapper;

    @Override
    public List<DataGaBxxxBxbdxx> GetAllPerson(String xm) {
        IPage<DataGaBxxxBxbdxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaBxxxBxbdxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaBxxxBxbdxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaBxxxBxbdxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaBxxxBxbdxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaBxxxBxbdxx> queryWrapper = new QueryWrapper<>();
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
