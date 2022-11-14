package com.bjd.smartanalysis.service.graph;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.graph.GraphNode;

import java.util.List;

public interface GraphNodeService extends IService<GraphNode> {
    public List<GraphNode> GetNodeList(Integer projectId);
    public List<GraphNode> GetNodeList(Integer projectId, Integer nodeId, String nodeType);
    public List<GraphNode> GetNodeListNOTSELF(Integer projectId);
    public List<GraphNode> GetNodeList(Integer projectId, String nodeType);

    public GraphNode GetNodeByNodeId(Integer projectId, Integer nodeId);
    public GraphNode GetNodeByNodeIdAndType(Integer projectId, Integer nodeId, String nodeType);
    public GraphNode GetNodeByNodeIdAndType(Integer projectId, Integer nodeId, String nodeType, String nodeName);
    public GraphNode GetNodeByNodeNameAndType(Integer projectId, String nodeName, String nodeType);
    public GraphNode GetNodeByNodeNameAndTypeNotSELF(Integer projectId, String nodeName, String nodeType);

    public void RemoveByProjectId(Integer projectId);
}
