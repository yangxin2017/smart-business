package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaZrzybqgJsydzjdsyq;
import com.bjd.smartanalysis.mapper.data.DataGaZrzybqgJsydzjdsyqMapper;
import com.bjd.smartanalysis.service.data.DataGaZrzybqgJsydzjdsyqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaZrzybqgJsydzjdsyqServiceImpl extends ServiceImpl<DataGaZrzybqgJsydzjdsyqMapper, DataGaZrzybqgJsydzjdsyq> implements DataGaZrzybqgJsydzjdsyqService {
    @Autowired
    DataGaZrzybqgJsydzjdsyqMapper mapper;

    @Override
    public List<DataGaZrzybqgJsydzjdsyq> GetAllPerson(String xm) {
        IPage<DataGaZrzybqgJsydzjdsyq> page = new Page<>(1, 10);
        QueryWrapper<DataGaZrzybqgJsydzjdsyq> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaZrzybqgJsydzjdsyq> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaZrzybqgJsydzjdsyq> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaZrzybqgJsydzjdsyq GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaZrzybqgJsydzjdsyq> queryWrapper = new QueryWrapper<>();
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
