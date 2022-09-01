package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaJrjgzhZhjbxx;
import com.bjd.smartanalysis.mapper.data.DataGaJrjgzhZhjbxxMapper;
import com.bjd.smartanalysis.service.data.DataGaJrjgzhZhjbxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaJrjgzhZhjbxxServiceImpl extends ServiceImpl<DataGaJrjgzhZhjbxxMapper, DataGaJrjgzhZhjbxx> implements DataGaJrjgzhZhjbxxService {
    @Autowired
    DataGaJrjgzhZhjbxxMapper mapper;

    @Override
    public List<DataGaJrjgzhZhjbxx> GetAllPerson(String xm) {
        IPage<DataGaJrjgzhZhjbxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaJrjgzhZhjbxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaJrjgzhZhjbxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaJrjgzhZhjbxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaJrjgzhZhjbxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaJrjgzhZhjbxx> queryWrapper = new QueryWrapper<>();
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
