package com.bjd.smartanalysis.serviceImpl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.sys.SysUserGroup;
import com.bjd.smartanalysis.mapper.sys.SysUserGroupMapper;
import com.bjd.smartanalysis.service.sys.SysUserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserGroupServiceImpl extends ServiceImpl<SysUserGroupMapper, SysUserGroup> implements SysUserGroupService {
    @Autowired
    private SysUserGroupMapper mapper;

    @Override
    public SysUserGroup GetDataByUserAndGroup(Long userId, Long groupId) {
        QueryWrapper<SysUserGroup> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("group_id", groupId);

        return mapper.selectOne(queryWrapper);
    }

    @Override
    public List<SysUserGroup> GetGroupsByUser(Long userId) {
        QueryWrapper<SysUserGroup> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return mapper.selectList(queryWrapper);
    }
}
