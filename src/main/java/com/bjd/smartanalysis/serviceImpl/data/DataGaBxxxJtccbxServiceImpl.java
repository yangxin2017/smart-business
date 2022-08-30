package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaBxxxJtccbx;
import com.bjd.smartanalysis.mapper.data.DataGaBxxxJtccbxMapper;
import com.bjd.smartanalysis.service.data.DataGaBxxxJtccbxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaBxxxJtccbxServiceImpl extends ServiceImpl<DataGaBxxxJtccbxMapper, DataGaBxxxJtccbx> implements DataGaBxxxJtccbxService {
    @Autowired
    DataGaBxxxJtccbxMapper mapper;

    @Override
    public List<DataGaBxxxJtccbx> GetAllPerson(String xm) {
        IPage<DataGaBxxxJtccbx> page = new Page<>(1, 10);
        QueryWrapper<DataGaBxxxJtccbx> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaBxxxJtccbx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaBxxxJtccbx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaBxxxJtccbx GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaBxxxJtccbx> queryWrapper = new QueryWrapper<>();
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
