package com.bjd.smartanalysis.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.sys.SysProjectGroupRel;

import java.util.List;

public interface SysProjectGroupRelService extends IService<SysProjectGroupRel> {
    public List<SysProjectGroupRel> GetRelProjects(List<Long> groups, String className);
}
