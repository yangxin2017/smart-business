package com.bjd.smartanalysis.controller.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjd.smartanalysis.common.ResponseData;
import com.bjd.smartanalysis.common.UploadUtil;
import com.bjd.smartanalysis.entity.DataFile;
import com.bjd.smartanalysis.entity.DataType;
import com.bjd.smartanalysis.entity.data.DataGaQsgx;
import com.bjd.smartanalysis.entity.data.DataGaRydzda;
import com.bjd.smartanalysis.service.DataFileService;
import com.bjd.smartanalysis.service.DataTypeService;
import com.bjd.smartanalysis.service.data.DataGaQsgxService;
import com.bjd.smartanalysis.service.data.DataGaRydzdaService;
import com.bjd.smartanalysis.service.data.SysErrorViewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(value = "人员电子档案", tags = {"人员电子档案"})
@RequestMapping("rydzda")
@RestController
public class DataGaRydzdaController {
    @Value("${file.upload.path}")
    private String basePath;

    @Autowired
    private DataTypeService dataTypeService;
    @Autowired
    private DataFileService fileService;
    @Autowired
    private DataGaRydzdaService service;
    @Autowired
    private SysErrorViewService errorViewService;
    @Autowired
    private DataGaQsgxService qsgxService;

    private DataBaseController<DataGaRydzda> controller;

    @PostMapping("upload")
    @ApiOperation(value = "上传数据", notes = "上传数据")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件流对象", required = true, dataType = "__File")})
    private ResponseData UploadData(@RequestParam("file") MultipartFile file, Integer bid, Integer projectId) {
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId,errorViewService);
        return controller.UploadData(file, bid, DataGaRydzda.class);
    }

    @GetMapping("filters")
    @ApiOperation(value = "根据姓名获取数据列表", notes = "根据姓名获取数据列表")
    public ResponseData GetListByXM(String xm){
        List<DataGaRydzda> datas = service.GetAllPerson(xm);
        return ResponseData.OK(datas);
    }

    @GetMapping("list")
    @ApiOperation(value = "获取数据列表", notes = "获取数据列表")
    // 接收传递的参数
    public ResponseData GetList(HttpServletRequest request, Integer pageIndex, Integer pageSize, Integer projectId,String xm,String sfzhm) {
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId);
        return controller.GetList(pageIndex, pageSize,xm,sfzhm);
    }

    @PostMapping("update")
    @ApiOperation(value = "更新数据", notes = "更新数据")
    public ResponseData UpdateData(@RequestBody DataGaRydzda body, Integer projectId){
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId);
        return controller.UpdateData(body);
    }

    @PostMapping("add")
    @ApiOperation(value = "添加数据", notes = "添加数据")
    public ResponseData AddData(@RequestBody DataGaRydzda body, Integer projectId){
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId);
        DataGaRydzda ex = service.GetPersonByName(projectId, body.getXM(), body.getSFZH());
        if (ex == null) {
            body.setProjectId(projectId);
            return controller.AddData(body);
        }
        return ResponseData.OK(null);
    }

    @PostMapping("delete/{id}")
    @ApiOperation(value = "删除数据", notes = "删除数据")
    public ResponseData DeleteData(@PathVariable Integer id, Integer projectId){
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId);
        return controller.DeleteData(id);
    }

    @GetMapping("export")
    @ApiOperation(value = "导出所有数据", notes = "导出所有数据")
    public void ExportExcel(HttpServletResponse response, Integer projectId) {
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId);
        controller.ExportExcel("人员电子档案", DataGaRydzda.class, response);
    }

    @GetMapping("onebyname")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    public ResponseData GetUserByName(String xm, Integer projectId) {
        DataGaRydzda user = service.GetPersonByName(projectId, xm);
        return ResponseData.OK(user);
    }

    @PostMapping("updatembr")
    @ApiOperation(value = "更新目标人", notes = "更新目标人")
    public ResponseData UpdateMBRData(Integer id, Boolean isMBR, Boolean isFxdx){
        DataGaRydzda user = service.getById(id);
        if(user != null) {
            user.setSfMbr(isMBR);
            user.setSfFxdx(isFxdx);
            //////////////////////
            if(isFxdx) {
                Integer projectId = user.getProjectId();
                DataGaQsgx gx = qsgxService.GetQsgxByNames(projectId, user.getXM());
                if (gx == null) {
                    service.updateById(user);
                } else {
                    return ResponseData.FAIL(user.getXM() + " 已经是目标人或者密切人！");
                }
            } else {
                service.updateById(user);
            }
        }
        return ResponseData.OK(user);
    }

    @GetMapping("remove")
    @ApiOperation(value = "删除所有数据", notes = "删除所有数据")
    private ResponseData RemoveAllData(Integer projectId) {
        QueryWrapper<DataGaRydzda> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", projectId);
        // 清空数据库中project_id为projectId的数据
        service.remove(queryWrapper);
        return ResponseData.OK("OK");
    }
}
