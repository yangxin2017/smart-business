package com.bjd.smartanalysis.service.graph;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.graph.GraphNode;

import java.util.List;

public interface GraphNodeService extends IService<GraphNode> {
    public List<GraphNode> GetNodeList(Integer projectId);

    public GraphNode GetNodeByNodeId(Integer projectId, Integer nodeId);
    public GraphNode GetNodeByNodeIdAndType(Integer projectId, Integer nodeId, String nodeType);

    public void RemoveByProjectId(Integer projectId);
}
