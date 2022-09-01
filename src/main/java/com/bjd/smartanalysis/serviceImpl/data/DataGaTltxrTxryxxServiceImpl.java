package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaTltxrTxryxx;
import com.bjd.smartanalysis.mapper.data.DataGaTltxrTxryxxMapper;
import com.bjd.smartanalysis.service.data.DataGaTltxrTxryxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaTltxrTxryxxServiceImpl extends ServiceImpl<DataGaTltxrTxryxxMapper, DataGaTltxrTxryxx> implements DataGaTltxrTxryxxService {
    @Autowired
    DataGaTltxrTxryxxMapper mapper;

    @Override
    public List<DataGaTltxrTxryxx> GetAllPerson(String xm) {
        IPage<DataGaTltxrTxryxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaTltxrTxryxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaTltxrTxryxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaTltxrTxryxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaTltxrTxryxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaTltxrTxryxx> queryWrapper = new QueryWrapper<>();
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
