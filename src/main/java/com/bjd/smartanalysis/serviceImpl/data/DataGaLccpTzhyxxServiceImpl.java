package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaLccpTzhyxx;
import com.bjd.smartanalysis.mapper.data.DataGaLccpTzhyxxMapper;
import com.bjd.smartanalysis.service.data.DataGaLccpTzhyxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaLccpTzhyxxServiceImpl extends ServiceImpl<DataGaLccpTzhyxxMapper, DataGaLccpTzhyxx> implements DataGaLccpTzhyxxService {
    @Autowired
    DataGaLccpTzhyxxMapper mapper;

    @Override
    public List<DataGaLccpTzhyxx> GetAllPerson(String xm) {
        IPage<DataGaLccpTzhyxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaLccpTzhyxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaLccpTzhyxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaLccpTzhyxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaLccpTzhyxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaLccpTzhyxx> queryWrapper = new QueryWrapper<>();
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
