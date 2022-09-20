package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.SysErrorView;

import java.util.List;

public interface SysErrorViewService extends IService<SysErrorView> {
    public List<SysErrorView> GetAllError(Integer projectId, Integer eid);
    // saveError
    public List<SysErrorView> saveError(Integer projectId, Integer eid, String errorContext, String fileName);
    public String getErrorContext(Integer eid);

}
