package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxQyjbxx;
import com.bjd.smartanalysis.mapper.data.DataGaQydjxxQyjbxxMapper;
import com.bjd.smartanalysis.service.data.DataGaQydjxxQyjbxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaQydjxxQyjbxxServiceImpl extends ServiceImpl<DataGaQydjxxQyjbxxMapper, DataGaQydjxxQyjbxx> implements DataGaQydjxxQyjbxxService {
    @Autowired
    DataGaQydjxxQyjbxxMapper mapper;

    @Override
    public List<DataGaQydjxxQyjbxx> GetAllPerson(String xm) {
        IPage<DataGaQydjxxQyjbxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaQydjxxQyjbxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaQydjxxQyjbxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaQydjxxQyjbxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public List<DataGaQydjxxQyjbxx> GetAllQys(Integer projectId) {
        QueryWrapper<DataGaQydjxxQyjbxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaQydjxxQyjbxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaQydjxxQyjbxx> queryWrapper = new QueryWrapper<>();
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
