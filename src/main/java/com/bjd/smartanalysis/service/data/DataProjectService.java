package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.common.PageData;
import com.bjd.smartanalysis.entity.data.DataProject;

import java.util.List;

public interface DataProjectService extends IService<DataProject> {
    public PageData<DataProject> GetProjects(String name, Integer pageIndex, Integer pageSize);
    public PageData<DataProject> GetProjects(Long groupId, String name, Integer pageIndex, Integer pageSize);
    public PageData<DataProject> GetProjects(List<Integer> ids, String name, Integer pageIndex, Integer pageSize);
}
