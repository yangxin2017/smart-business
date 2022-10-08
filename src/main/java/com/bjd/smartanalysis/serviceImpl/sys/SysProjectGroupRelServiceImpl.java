package com.bjd.smartanalysis.serviceImpl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.sys.SysProjectGroupRel;
import com.bjd.smartanalysis.mapper.sys.SysProjectGroupRelMapper;
import com.bjd.smartanalysis.service.sys.SysProjectGroupRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysProjectGroupRelServiceImpl extends ServiceImpl<SysProjectGroupRelMapper, SysProjectGroupRel> implements SysProjectGroupRelService {
    @Autowired
    private SysProjectGroupRelMapper mapper;

    @Override
    public List<SysProjectGroupRel> GetRelProjects(List<Long> groups, String className) {
        QueryWrapper<SysProjectGroupRel> queryWrapper = new QueryWrapper<>();
        if (groups.size() > 0) {
            queryWrapper.in("group_id", groups);
        }
        queryWrapper.eq("class_name", className);
        return mapper.selectList(queryWrapper);
    }
}
