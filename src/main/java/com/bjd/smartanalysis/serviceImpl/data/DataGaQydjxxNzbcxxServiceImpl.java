package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxNzbcxx;
import com.bjd.smartanalysis.mapper.data.DataGaQydjxxNzbcxxMapper;
import com.bjd.smartanalysis.service.data.DataGaQydjxxNzbcxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaQydjxxNzbcxxServiceImpl extends ServiceImpl<DataGaQydjxxNzbcxxMapper, DataGaQydjxxNzbcxx> implements DataGaQydjxxNzbcxxService {
    @Autowired
    DataGaQydjxxNzbcxxMapper mapper;

    @Override
    public List<DataGaQydjxxNzbcxx> GetAllPerson(String xm) {
        IPage<DataGaQydjxxNzbcxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaQydjxxNzbcxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaQydjxxNzbcxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaQydjxxNzbcxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaQydjxxNzbcxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaQydjxxNzbcxx> queryWrapper = new QueryWrapper<>();
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
