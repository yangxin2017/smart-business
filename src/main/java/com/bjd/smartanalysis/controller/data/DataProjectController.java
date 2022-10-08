package com.bjd.smartanalysis.controller.data;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjd.smartanalysis.common.CommonUtils;
import com.bjd.smartanalysis.common.PageData;
import com.bjd.smartanalysis.common.ResponseData;
import com.bjd.smartanalysis.entity.data.DataBank;
import com.bjd.smartanalysis.entity.data.DataGaRydzda;
import com.bjd.smartanalysis.entity.data.DataProject;
import com.bjd.smartanalysis.entity.sys.SysProjectGroupRel;
import com.bjd.smartanalysis.entity.sys.SysUserGroup;
import com.bjd.smartanalysis.service.data.DataGaRydzdaService;
import com.bjd.smartanalysis.service.data.DataProjectService;
import com.bjd.smartanalysis.service.sys.SysProjectGroupRelService;
import com.bjd.smartanalysis.service.sys.SysUserGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(value = "项目信息", tags = {"项目信息"})
@RequestMapping("project")
@RestController
public class DataProjectController {
    @Autowired
    private DataProjectService projectService;
    @Autowired
    private DataGaRydzdaService rydzdaService;
    @Autowired
    private SysUserGroupService userGroupService;
    @Autowired
    private SysProjectGroupRelService projectGroupRelService;

    @PostMapping("add")
    @ApiOperation(value = "添加项目信息", notes = "添加项目信息")
    private ResponseData AddProject(HttpServletRequest request, @RequestBody DataProject project){
//        Long gid = CommonUtils.GetGroupId(request);
        Long uid = CommonUtils.GetUserId(request);
        List<SysUserGroup> groups = userGroupService.GetGroupsByUser(uid);

        project.setGroupId(0l);

        project.setCtime(new Date());
        projectService.save(project);

        for(SysUserGroup group: groups) {
            SysProjectGroupRel rel = new SysProjectGroupRel();
            rel.setClassName(DataProject.class.getSimpleName());
            rel.setGroupId(group.getGroupId());
            rel.setProjectId(project.getId());
            projectGroupRelService.save(rel);
        }

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
//        Long gid = CommonUtils.GetGroupId(request);
        Long uid = CommonUtils.GetUserId(request);
        List<SysUserGroup> groups = userGroupService.GetGroupsByUser(uid);
        List<Long> gids = new ArrayList<>();
        for(SysUserGroup g: groups) {
            gids.add(g.getGroupId());
        }

        List<SysProjectGroupRel> rels = projectGroupRelService.GetRelProjects(gids, DataProject.class.getSimpleName());
        List<Integer> pids = new ArrayList<>();
        for(SysProjectGroupRel r: rels) {
            pids.add(r.getProjectId());
        }

        PageData<DataProject> page = projectService.GetProjects(pids, name, pageIndex, pageSize);
        List<DataProject> lists = page.getData();

        for(DataProject p: lists) {
            Integer pid = p.getId();
            List<DataGaRydzda> pers = rydzdaService.GetAllPersonList(pid, "");
            String names = "";
            for(DataGaRydzda pr: pers) {
                if(pr.getSfMbr() != null && pr.getSfMbr()) {
                    names += pr.getXM() + "、";
                }
            }
            if(names.length() > 0 && names.contains("、")) {
                names = names.substring(0, names.length() - 1);
            }
            p.setPersons(names);
        }

        return ResponseData.OK(page);
    }


}
