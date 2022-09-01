package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxLlyxx;
import com.bjd.smartanalysis.mapper.data.DataGaQydjxxLlyxxMapper;
import com.bjd.smartanalysis.service.data.DataGaQydjxxLlyxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaQydjxxLlyxxServiceImpl extends ServiceImpl<DataGaQydjxxLlyxxMapper, DataGaQydjxxLlyxx> implements DataGaQydjxxLlyxxService {
    @Autowired
    DataGaQydjxxLlyxxMapper mapper;

    @Override
    public List<DataGaQydjxxLlyxx> GetAllPerson(String xm) {
        IPage<DataGaQydjxxLlyxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaQydjxxLlyxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaQydjxxLlyxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaQydjxxLlyxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaQydjxxLlyxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaQydjxxLlyxx> queryWrapper = new QueryWrapper<>();
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
