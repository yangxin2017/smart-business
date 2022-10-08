package com.bjd.smartanalysis.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.sys.SysUserGroup;

import java.util.List;

public interface SysUserGroupService extends IService<SysUserGroup> {
    public SysUserGroup GetDataByUserAndGroup(Long userId, Long groupId);

    public List<SysUserGroup> GetGroupsByUser(Long userId);
}
