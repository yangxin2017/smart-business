package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaLccpLccpxx;
import com.bjd.smartanalysis.mapper.data.DataGaLccpLccpxxMapper;
import com.bjd.smartanalysis.service.data.DataGaLccpLccpxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaLccpLccpxxServiceImpl extends ServiceImpl<DataGaLccpLccpxxMapper, DataGaLccpLccpxx> implements DataGaLccpLccpxxService {
    @Autowired
    DataGaLccpLccpxxMapper mapper;

    @Override
    public List<DataGaLccpLccpxx> GetAllPerson(String xm) {
        IPage<DataGaLccpLccpxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaLccpLccpxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaLccpLccpxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaLccpLccpxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaLccpLccpxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaLccpLccpxx> queryWrapper = new QueryWrapper<>();
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
