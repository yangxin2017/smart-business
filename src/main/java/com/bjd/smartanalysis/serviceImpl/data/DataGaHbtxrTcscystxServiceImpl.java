package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaHbtxrTcscystx;
import com.bjd.smartanalysis.mapper.data.DataGaHbtxrTcscystxMapper;
import com.bjd.smartanalysis.service.data.DataGaHbtxrTcscystxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaHbtxrTcscystxServiceImpl extends ServiceImpl<DataGaHbtxrTcscystxMapper, DataGaHbtxrTcscystx> implements DataGaHbtxrTcscystxService {
    @Autowired
    DataGaHbtxrTcscystxMapper mapper;

    @Override
    public List<DataGaHbtxrTcscystx> GetAllPerson(String xm) {
        IPage<DataGaHbtxrTcscystx> page = new Page<>(1, 10);
        QueryWrapper<DataGaHbtxrTcscystx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaHbtxrTcscystx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaHbtxrTcscystx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaHbtxrTcscystx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaHbtxrTcscystx> queryWrapper = new QueryWrapper<>();
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
