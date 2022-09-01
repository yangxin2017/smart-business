package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaJrjgzhKhjbxx;
import com.bjd.smartanalysis.mapper.data.DataGaJrjgzhKhjbxxMapper;
import com.bjd.smartanalysis.service.data.DataGaJrjgzhKhjbxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaJrjgzhKhjbxxServiceImpl extends ServiceImpl<DataGaJrjgzhKhjbxxMapper, DataGaJrjgzhKhjbxx> implements DataGaJrjgzhKhjbxxService {
    @Autowired
    DataGaJrjgzhKhjbxxMapper mapper;

    @Override
    public List<DataGaJrjgzhKhjbxx> GetAllPerson(String xm) {
        IPage<DataGaJrjgzhKhjbxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaJrjgzhKhjbxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaJrjgzhKhjbxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaJrjgzhKhjbxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaJrjgzhKhjbxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaJrjgzhKhjbxx> queryWrapper = new QueryWrapper<>();
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
