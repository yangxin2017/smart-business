package com.bjd.smartanalysis.controller.data;

import com.bjd.smartanalysis.common.ResponseData;
import com.bjd.smartanalysis.entity.data.DataGaJrjgzhGlzzhxx;
import com.bjd.smartanalysis.service.DataFileService;
import com.bjd.smartanalysis.service.DataTypeService;
import com.bjd.smartanalysis.service.data.DataGaJrjgzhGlzzhxxService;
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

@Api(value = "金融机构账户-关联子账户信息", tags = {"金融机构账户-关联子账户信息"})
@RequestMapping("jrjgzhGlzzhxx")
@RestController
public class DataGaJrjgzhGlzzhxxController {
    @Value("${file.upload.path}")
    private String basePath;

    @Autowired
    private DataTypeService dataTypeService;
    @Autowired
    private DataFileService fileService;
    @Autowired
    private DataGaJrjgzhGlzzhxxService service;

    private DataBaseController<DataGaJrjgzhGlzzhxx> controller;

    @PostMapping("upload")
    @ApiOperation(value = "上传数据", notes = "上传数据")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件流对象", required = true, dataType = "__File")})
    private ResponseData UploadData(@RequestParam("file") MultipartFile file, Integer bid, Integer projectId) {
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId);
        return controller.UploadData(file, bid, DataGaJrjgzhGlzzhxx.class);
    }

    @GetMapping("list")
    @ApiOperation(value = "获取数据列表", notes = "获取数据列表")
    public ResponseData GetList(HttpServletRequest request, Integer pageIndex, Integer pageSize, Integer projectId) {
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId);
        return controller.GetList(pageIndex, pageSize);
    }

    @PostMapping("update")
    @ApiOperation(value = "更新数据", notes = "更新数据")
    public ResponseData UpdateData(@RequestBody DataGaJrjgzhGlzzhxx body, Integer projectId){
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId);
        return controller.UpdateData(body);
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
        controller.ExportExcel("人员电子档案", DataGaJrjgzhGlzzhxx.class, response);
    }
}
