package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaQydjxxZxxx;
import com.bjd.smartanalysis.mapper.data.DataGaQydjxxZxxxMapper;
import com.bjd.smartanalysis.service.data.DataGaQydjxxZxxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaQydjxxZxxxServiceImpl extends ServiceImpl<DataGaQydjxxZxxxMapper, DataGaQydjxxZxxx> implements DataGaQydjxxZxxxService {
    @Autowired
    DataGaQydjxxZxxxMapper mapper;

    @Override
    public List<DataGaQydjxxZxxx> GetAllPerson(String xm) {
        IPage<DataGaQydjxxZxxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaQydjxxZxxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaQydjxxZxxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaQydjxxZxxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaQydjxxZxxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaQydjxxZxxx> queryWrapper = new QueryWrapper<>();
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
