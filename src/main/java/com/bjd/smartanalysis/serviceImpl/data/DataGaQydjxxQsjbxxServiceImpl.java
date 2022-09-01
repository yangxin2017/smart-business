package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxQsjbxx;
import com.bjd.smartanalysis.mapper.data.DataGaQydjxxQsjbxxMapper;
import com.bjd.smartanalysis.service.data.DataGaQydjxxQsjbxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaQydjxxQsjbxxServiceImpl extends ServiceImpl<DataGaQydjxxQsjbxxMapper, DataGaQydjxxQsjbxx> implements DataGaQydjxxQsjbxxService {
    @Autowired
    DataGaQydjxxQsjbxxMapper mapper;

    @Override
    public List<DataGaQydjxxQsjbxx> GetAllPerson(String xm) {
        IPage<DataGaQydjxxQsjbxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaQydjxxQsjbxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaQydjxxQsjbxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaQydjxxQsjbxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaQydjxxQsjbxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaQydjxxQsjbxx> queryWrapper = new QueryWrapper<>();
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
