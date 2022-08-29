package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.common.PageData;
import com.bjd.smartanalysis.entity.data.DataProject;
import com.bjd.smartanalysis.mapper.data.DataProjectMapper;
import com.bjd.smartanalysis.service.data.DataProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataProjectServiceImpl extends ServiceImpl<DataProjectMapper, DataProject> implements DataProjectService {
    @Autowired
    private DataProjectMapper mapper;

    @Override
    public PageData<DataProject> GetProjects(String name, Integer pageIndex, Integer pageSize) {
        IPage<DataProject> projectPage = new Page<>(pageIndex, pageSize);
        QueryWrapper<DataProject> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name);
        projectPage = mapper.selectPage(projectPage, queryWrapper);

        PageData<DataProject> page = new PageData<>();
        page.setTotal(projectPage.getTotal());
        page.setData(projectPage.getRecords());
        return page;
    }

    @Override
    public PageData<DataProject> GetProjects(Long groupId, String name, Integer pageIndex, Integer pageSize) {
        IPage<DataProject> projectPage = new Page<>(pageIndex, pageSize);
        QueryWrapper<DataProject> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name);
        queryWrapper.eq("group_id", groupId);
        projectPage = mapper.selectPage(projectPage, queryWrapper);

        PageData<DataProject> page = new PageData<>();
        page.setTotal(projectPage.getTotal());
        page.setData(projectPage.getRecords());
        return page;
    }
}
