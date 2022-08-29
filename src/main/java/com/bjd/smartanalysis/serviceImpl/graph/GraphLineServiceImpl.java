package com.bjd.smartanalysis.serviceImpl.graph;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.graph.GraphLine;
import com.bjd.smartanalysis.mapper.graph.GraphLineMapper;
import com.bjd.smartanalysis.service.graph.GraphLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraphLineServiceImpl extends ServiceImpl<GraphLineMapper, GraphLine> implements GraphLineService {
    @Autowired
    private GraphLineMapper mapper;

    @Override
    public List<GraphLine> GetLineList(Integer projectId) {
        QueryWrapper<GraphLine> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public void RemoveByProjectId(Integer projectId) {
        QueryWrapper<GraphLine> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        mapper.delete(queryWrapper);
    }
}
