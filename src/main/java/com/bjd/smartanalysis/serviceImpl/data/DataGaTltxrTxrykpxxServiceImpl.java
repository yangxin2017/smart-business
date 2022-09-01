package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaTltxrTxrykpxx;
import com.bjd.smartanalysis.mapper.data.DataGaTltxrTxrykpxxMapper;
import com.bjd.smartanalysis.service.data.DataGaTltxrTxrykpxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaTltxrTxrykpxxServiceImpl extends ServiceImpl<DataGaTltxrTxrykpxxMapper, DataGaTltxrTxrykpxx> implements DataGaTltxrTxrykpxxService {
    @Autowired
    DataGaTltxrTxrykpxxMapper mapper;

    @Override
    public List<DataGaTltxrTxrykpxx> GetAllPerson(String xm) {
        IPage<DataGaTltxrTxrykpxx> page = new Page<>(1, 10);
        QueryWrapper<DataGaTltxrTxrykpxx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaTltxrTxrykpxx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaTltxrTxrykpxx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaTltxrTxrykpxx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaTltxrTxrykpxx> queryWrapper = new QueryWrapper<>();
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
