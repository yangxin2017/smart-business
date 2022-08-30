package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaLccpCyxx;
import com.bjd.smartanalysis.mapper.data.DataGaLccpCyxxMapper;
import com.bjd.smartanalysis.service.data.DataGaLccpCyxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaLccpCyxxServiceImpl extends ServiceImpl<DataGaLccpCyxxMapper, DataGaLccpCyxx> implements DataGaLccpCyxxService {
    @Autowired
    DataGaLccpCyxxMapper mapper;

    @Override
    public List<DataGaLccpCyxx> GetAllPerson(String xm) {
        IPage<DataGaLccpCyxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaLccpCyxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaLccpCyxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaLccpCyxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaLccpCyxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaLccpCyxx> queryWrapper = new QueryWrapper<>();
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
