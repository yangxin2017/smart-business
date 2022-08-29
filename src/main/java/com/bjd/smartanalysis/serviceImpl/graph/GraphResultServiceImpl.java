package com.bjd.smartanalysis.serviceImpl.graph;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.graph.GraphResult;
import com.bjd.smartanalysis.mapper.graph.GraphResultMapper;
import com.bjd.smartanalysis.service.graph.GraphResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraphResultServiceImpl extends ServiceImpl<GraphResultMapper, GraphResult> implements GraphResultService {
    @Autowired
    private GraphResultMapper mapper;

    @Override
    public GraphResult GetDataByProjectId(Integer projectId) {
        QueryWrapper<GraphResult> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", projectId);
        queryWrapper.last("limit 1");
        return mapper.selectOne(queryWrapper);
    }
}
