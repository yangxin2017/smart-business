package com.bjd.smartanalysis.controller.data;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjd.smartanalysis.common.CommonUtils;
import com.bjd.smartanalysis.common.PageData;
import com.bjd.smartanalysis.common.ResponseData;
import com.bjd.smartanalysis.entity.data.DataBank;
import com.bjd.smartanalysis.entity.data.DataProject;
import com.bjd.smartanalysis.service.data.DataProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Api(value = "项目信息", tags = {"项目信息"})
@RequestMapping("project")
@RestController
public class DataProjectController {
    @Autowired
    private DataProjectService projectService;

    @PostMapping("add")
    @ApiOperation(value = "添加项目信息", notes = "添加项目信息")
    private ResponseData AddProject(HttpServletRequest request, @RequestBody DataProject project){
        Long gid = CommonUtils.GetGroupId(request);
        project.setGroupId(gid);

        project.setCtime(new Date());
        projectService.save(project);
        return ResponseData.OK(project);
    }

    @PostMapping("update")
    @ApiOperation(value = "修改项目信息", notes = "修改项目信息")
    private ResponseData UpdateProject(HttpServletRequest request, @RequestBody DataProject project){
        project.setUtime(new Date());
        projectService.updateById(project);
        return ResponseData.OK(project);
    }

    @GetMapping("list")
    @ApiOperation(value = "获取项目数据列表", notes = "获取项目数据列表")
    private ResponseData GetList(HttpServletRequest request, String name, Integer pageIndex, Integer pageSize) {
        Long gid = CommonUtils.GetGroupId(request);

        PageData<DataProject> page = projectService.GetProjects(gid, name, pageIndex, pageSize);
        return ResponseData.OK(page);
    }


}
