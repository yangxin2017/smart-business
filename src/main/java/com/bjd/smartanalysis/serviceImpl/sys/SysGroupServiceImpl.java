package com.bjd.smartanalysis.serviceImpl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.sys.SysGroup;
import com.bjd.smartanalysis.mapper.sys.SysGroupMapper;
import com.bjd.smartanalysis.service.sys.SysGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysGroupServiceImpl extends ServiceImpl<SysGroupMapper, SysGroup> implements SysGroupService {
    @Autowired
    private SysGroupMapper mapper;

    @Override
    public SysGroup GetGroupByComeGroupId(Long comId) {
        QueryWrapper<SysGroup> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("come_group_id", comId);
        queryWrapper.last("limit 1");
        return mapper.selectOne(queryWrapper);
    }
}
