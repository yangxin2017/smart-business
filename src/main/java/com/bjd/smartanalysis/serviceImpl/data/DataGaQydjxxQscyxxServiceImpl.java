package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxQscyxx;
import com.bjd.smartanalysis.mapper.data.DataGaQydjxxQscyxxMapper;
import com.bjd.smartanalysis.service.data.DataGaQydjxxQscyxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaQydjxxQscyxxServiceImpl extends ServiceImpl<DataGaQydjxxQscyxxMapper, DataGaQydjxxQscyxx> implements DataGaQydjxxQscyxxService {
    @Autowired
    DataGaQydjxxQscyxxMapper mapper;

    @Override
    public List<DataGaQydjxxQscyxx> GetAllPerson(String xm) {
        IPage<DataGaQydjxxQscyxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaQydjxxQscyxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaQydjxxQscyxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaQydjxxQscyxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaQydjxxQscyxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaQydjxxQscyxx> queryWrapper = new QueryWrapper<>();
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
