package com.bjd.smartanalysis.service.graph;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.graph.GraphLine;

import java.util.List;

public interface GraphLineService extends IService<GraphLine> {
    public List<GraphLine> GetLineList(Integer projectId);
    public List<GraphLine> GetLineList(Integer projectId, String lineType);
    public List<GraphLine> GetLineListNOTSELF(Integer projectId);

    public GraphLine GetlineMod(Integer projectId, Integer sid, Integer eid, String name);

    public void RemoveByProjectId(Integer projectId);
}
