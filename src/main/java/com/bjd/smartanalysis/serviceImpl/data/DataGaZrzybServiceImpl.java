package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaZrzyb;
import com.bjd.smartanalysis.mapper.data.DataGaZrzybMapper;
import com.bjd.smartanalysis.service.data.DataGaZrzybService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaZrzybServiceImpl extends ServiceImpl<DataGaZrzybMapper, DataGaZrzyb> implements DataGaZrzybService {
    @Autowired
    DataGaZrzybMapper mapper;

    @Override
    public List<DataGaZrzyb> GetAllPerson(String xm) {
        IPage<DataGaZrzyb> page = new Page<>(1, 10);
        QueryWrapper<DataGaZrzyb> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaZrzyb> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaZrzyb> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaZrzyb GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaZrzyb> queryWrapper = new QueryWrapper<>();
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
