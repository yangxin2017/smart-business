package com.bjd.smartanalysis.serviceImpl.graph;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.graph.GraphNode;
import com.bjd.smartanalysis.mapper.graph.GraphNodeMapper;
import com.bjd.smartanalysis.service.graph.GraphNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraphNodeServiceImpl extends ServiceImpl<GraphNodeMapper, GraphNode> implements GraphNodeService {
    @Autowired
    private GraphNodeMapper mapper;

    @Override
    public List<GraphNode> GetNodeList(Integer projectId) {
        QueryWrapper<GraphNode> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public GraphNode GetNodeByNodeId(Integer projectId, Integer nodeId) {
        QueryWrapper<GraphNode> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (nodeId != null) {
            queryWrapper.eq("node_id", nodeId);
        }
        queryWrapper.last("limit 1");
        return mapper.selectOne(queryWrapper);
    }

    @Override
    public GraphNode GetNodeByNodeIdAndType(Integer projectId, Integer nodeId, String nodeType) {
        QueryWrapper<GraphNode> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (nodeId != null) {
            queryWrapper.eq("node_id", nodeId);
        }
        if (nodeType != null && !nodeType.equals("")) {
            queryWrapper.eq("node_type", nodeType);
        }
        queryWrapper.last("limit 1");
        return mapper.selectOne(queryWrapper);
    }

    @Override
    public void RemoveByProjectId(Integer projectId) {
        QueryWrapper<GraphNode> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        mapper.delete(queryWrapper);
    }
}
