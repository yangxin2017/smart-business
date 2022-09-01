package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxBgbaxx;
import com.bjd.smartanalysis.mapper.data.DataGaQydjxxBgbaxxMapper;
import com.bjd.smartanalysis.service.data.DataGaQydjxxBgbaxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaQydjxxBgbaxxServiceImpl extends ServiceImpl<DataGaQydjxxBgbaxxMapper, DataGaQydjxxBgbaxx> implements DataGaQydjxxBgbaxxService {
    @Autowired
    DataGaQydjxxBgbaxxMapper mapper;

    @Override
    public List<DataGaQydjxxBgbaxx> GetAllPerson(String xm) {
        IPage<DataGaQydjxxBgbaxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaQydjxxBgbaxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaQydjxxBgbaxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaQydjxxBgbaxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaQydjxxBgbaxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaQydjxxBgbaxx> queryWrapper = new QueryWrapper<>();
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
