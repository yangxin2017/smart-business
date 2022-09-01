package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxZrrczxx;
import com.bjd.smartanalysis.mapper.data.DataGaQydjxxZrrczxxMapper;
import com.bjd.smartanalysis.service.data.DataGaQydjxxZrrczxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaQydjxxZrrczxxServiceImpl extends ServiceImpl<DataGaQydjxxZrrczxxMapper, DataGaQydjxxZrrczxx> implements DataGaQydjxxZrrczxxService {
    @Autowired
    DataGaQydjxxZrrczxxMapper mapper;

    @Override
    public List<DataGaQydjxxZrrczxx> GetAllPerson(String xm) {
        IPage<DataGaQydjxxZrrczxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaQydjxxZrrczxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaQydjxxZrrczxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaQydjxxZrrczxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaQydjxxZrrczxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaQydjxxZrrczxx> queryWrapper = new QueryWrapper<>();
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
