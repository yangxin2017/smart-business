package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaHlwzcxxCylxrxx;
import com.bjd.smartanalysis.mapper.data.DataGaHlwzcxxCylxrxxMapper;
import com.bjd.smartanalysis.service.data.DataGaHlwzcxxCylxrxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaHlwzcxxCylxrxxServiceImpl extends ServiceImpl<DataGaHlwzcxxCylxrxxMapper, DataGaHlwzcxxCylxrxx> implements DataGaHlwzcxxCylxrxxService {
    @Autowired
    DataGaHlwzcxxCylxrxxMapper mapper;

    @Override
    public List<DataGaHlwzcxxCylxrxx> GetAllPerson(String xm) {
        IPage<DataGaHlwzcxxCylxrxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaHlwzcxxCylxrxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaHlwzcxxCylxrxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaHlwzcxxCylxrxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaHlwzcxxCylxrxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaHlwzcxxCylxrxx> queryWrapper = new QueryWrapper<>();
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
