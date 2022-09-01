package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaYxjrjgjrlcJrlczhxx;
import com.bjd.smartanalysis.mapper.data.DataGaYxjrjgjrlcJrlczhxxMapper;
import com.bjd.smartanalysis.service.data.DataGaYxjrjgjrlcJrlczhxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaYxjrjgjrlcJrlczhxxServiceImpl extends ServiceImpl<DataGaYxjrjgjrlcJrlczhxxMapper, DataGaYxjrjgjrlcJrlczhxx> implements DataGaYxjrjgjrlcJrlczhxxService {
    @Autowired
    DataGaYxjrjgjrlcJrlczhxxMapper mapper;

    @Override
    public List<DataGaYxjrjgjrlcJrlczhxx> GetAllPerson(String xm) {
        IPage<DataGaYxjrjgjrlcJrlczhxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaYxjrjgjrlcJrlczhxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaYxjrjgjrlcJrlczhxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaYxjrjgjrlcJrlczhxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaYxjrjgjrlcJrlczhxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaYxjrjgjrlcJrlczhxx> queryWrapper = new QueryWrapper<>();
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
