package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaHlwzcxxHlwzcxx;
import com.bjd.smartanalysis.mapper.data.DataGaHlwzcxxHlwzcxxMapper;
import com.bjd.smartanalysis.service.data.DataGaHlwzcxxHlwzcxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaHlwzcxxHlwzcxxServiceImpl extends ServiceImpl<DataGaHlwzcxxHlwzcxxMapper, DataGaHlwzcxxHlwzcxx> implements DataGaHlwzcxxHlwzcxxService {
    @Autowired
    DataGaHlwzcxxHlwzcxxMapper mapper;

    @Override
    public List<DataGaHlwzcxxHlwzcxx> GetAllPerson(String xm) {
        IPage<DataGaHlwzcxxHlwzcxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaHlwzcxxHlwzcxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaHlwzcxxHlwzcxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaHlwzcxxHlwzcxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaHlwzcxxHlwzcxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaHlwzcxxHlwzcxx> queryWrapper = new QueryWrapper<>();
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
