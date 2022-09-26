package com.bjd.smartanalysis.service.graph;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.graph.GraphResult;

public interface GraphResultService extends IService<GraphResult> {
    public GraphResult GetDataByProjectId(Integer projectId);

    public void RemoveByProjectId(Integer projectId);
}
