package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaZqxxCyxx;
import com.bjd.smartanalysis.mapper.data.DataGaZqxxCyxxMapper;
import com.bjd.smartanalysis.service.data.DataGaZqxxCyxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaZqxxCyxxServiceImpl extends ServiceImpl<DataGaZqxxCyxxMapper, DataGaZqxxCyxx> implements DataGaZqxxCyxxService {
    @Autowired
    DataGaZqxxCyxxMapper mapper;

    @Override
    public List<DataGaZqxxCyxx> GetAllPerson(String xm) {
        IPage<DataGaZqxxCyxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaZqxxCyxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaZqxxCyxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaZqxxCyxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaZqxxCyxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaZqxxCyxx> queryWrapper = new QueryWrapper<>();
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
