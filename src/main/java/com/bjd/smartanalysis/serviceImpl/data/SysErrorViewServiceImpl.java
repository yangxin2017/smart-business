package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.SysErrorView;
import com.bjd.smartanalysis.mapper.data.SysErrorViewMapper;
import com.bjd.smartanalysis.service.data.SysErrorViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class SysErrorViewServiceImpl extends ServiceImpl<SysErrorViewMapper, SysErrorView> implements SysErrorViewService {
    @Autowired
    private SysErrorViewMapper mapper;

    @Override
    public List<SysErrorView> GetAllError(Integer projectId, Integer eid) {
        QueryWrapper<SysErrorView> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (eid != null) {
            queryWrapper.eq("eid", eid);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public List<SysErrorView> saveError(Integer projectId, Integer eid, String errorContext, String fileName) {
        SysErrorView sysErrorView = new SysErrorView();
        sysErrorView.setProjectId(projectId);
        sysErrorView.setEid(eid);
        sysErrorView.setErrorContext(errorContext);
        sysErrorView.setFileName(fileName);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sysErrorView.setCreateTime(df.format(System.currentTimeMillis()));
        mapper.insert(sysErrorView);
        return GetAllError(projectId, eid);
    }

    @Override
    public String getErrorContext(Integer eid) {
        QueryWrapper<SysErrorView> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("eid", eid);
        return mapper.selectOne(queryWrapper).getErrorContext();
    }
}
