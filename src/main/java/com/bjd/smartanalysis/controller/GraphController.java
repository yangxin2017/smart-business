package com.bjd.smartanalysis.controller;

import com.bjd.smartanalysis.common.ResponseData;
import com.bjd.smartanalysis.entity.data.DataProject;
import com.bjd.smartanalysis.entity.graph.GraphResult;
import com.bjd.smartanalysis.service.data.DataProjectService;
import com.bjd.smartanalysis.service.graph.GraphResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "关系图信息", tags = {"关系图信息"})
@RequestMapping("graph")
public class GraphController {
    @Autowired
    private GraphResultService resultService;
    @Autowired
    private DataProjectService projectService;

    private String pageTypeNormal = "NORMAL";
    private String pageTypeSIMPLE = "SIMPLE";

    @PostMapping("save")
    @ApiOperation(value = "保存信息", notes = "保存信息")
    public ResponseData SaveInfo(@RequestBody GraphResult res) {
        Integer projectId = res.getProjectId();
        String pageType = res.getPageType();
        DataProject project = projectService.getById(projectId);
        if (project != null) {
            GraphResult result = resultService.GetDataByProjectId(projectId, pageType);
            if (result == null) {
                result = new GraphResult();
                result.setJsonstr(res.getJsonstr());
                result.setProjectId(projectId);
                result.setPageType(pageType);
                resultService.save(result);
            }
        }
        return ResponseData.OK(null);
    }

    @PostMapping("update")
    @ApiOperation(value = "更新信息", notes = "更新信息")
    public ResponseData UpdateInfo(@RequestBody GraphResult res) {
        Integer projectId = res.getProjectId();
        String pageType = res.getPageType();
        DataProject project = projectService.getById(projectId);
        if (project != null) {
            GraphResult result = resultService.GetDataByProjectId(projectId, pageType);
            if (result != null) {
                result.setJsonstr(res.getJsonstr());
                resultService.updateById(result);
            }
        }
        return ResponseData.OK(null);
    }

    @GetMapping("one")
    @ApiOperation(value = "获取项目信息", notes = "获取项目信息")
    public ResponseData GetProjectInfo(Integer projectId, String pageType) {
        GraphResult result = resultService.GetDataByProjectId(projectId, pageType);
        return ResponseData.OK(result);
    }
}
