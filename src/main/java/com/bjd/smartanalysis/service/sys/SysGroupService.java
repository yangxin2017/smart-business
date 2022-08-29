package com.bjd.smartanalysis.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.sys.SysGroup;

public interface SysGroupService extends IService<SysGroup> {
    public SysGroup GetGroupByComeGroupId(Long comId);
}
