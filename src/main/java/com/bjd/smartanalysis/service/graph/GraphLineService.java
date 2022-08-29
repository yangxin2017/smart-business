package com.bjd.smartanalysis.service.graph;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.graph.GraphLine;

import java.util.List;

public interface GraphLineService extends IService<GraphLine> {
    public List<GraphLine> GetLineList(Integer projectId);

    public void RemoveByProjectId(Integer projectId);
}
