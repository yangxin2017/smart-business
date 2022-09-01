package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaJrjgzhGlzzhxx;
import com.bjd.smartanalysis.mapper.data.DataGaJrjgzhGlzzhxxMapper;
import com.bjd.smartanalysis.service.data.DataGaJrjgzhGlzzhxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaJrjgzhGlzzhxxServiceImpl extends ServiceImpl<DataGaJrjgzhGlzzhxxMapper, DataGaJrjgzhGlzzhxx> implements DataGaJrjgzhGlzzhxxService {
    @Autowired
    DataGaJrjgzhGlzzhxxMapper mapper;

    @Override
    public List<DataGaJrjgzhGlzzhxx> GetAllPerson(String xm) {
        IPage<DataGaJrjgzhGlzzhxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaJrjgzhGlzzhxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaJrjgzhGlzzhxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaJrjgzhGlzzhxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaJrjgzhGlzzhxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaJrjgzhGlzzhxx> queryWrapper = new QueryWrapper<>();
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
