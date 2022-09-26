package com.bjd.smartanalysis.controller.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjd.smartanalysis.common.ResponseData;
//import com.bjd.smartanalysis.entity.data.DataGaCrjjl;
import com.bjd.smartanalysis.entity.data.DataGaQsgx;
import com.bjd.smartanalysis.entity.data.DataGaRydzda;
import com.bjd.smartanalysis.entity.data.DataGaYhhcxx;
import com.bjd.smartanalysis.service.DataFileService;
import com.bjd.smartanalysis.service.DataTypeService;
import com.bjd.smartanalysis.service.data.DataBankService;
import com.bjd.smartanalysis.service.data.DataGaQsgxService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Api(value = "亲属关系", tags = {"亲属关系"})
@RequestMapping("qsgx")
@RestController
public class DataGaQsgxController {
    @Autowired
    private DataGaQsgxService service;

    @Value("${file.upload.path}")
    private String basePath;

    @Autowired
    private DataTypeService dataTypeService;
    @Autowired
    private DataFileService fileService;

    private DataBaseController<DataGaQsgx> controller;

    @GetMapping("list")
    @ApiOperation(value = "获取数据列表", notes = "获取数据列表")
    public ResponseData GetList(Integer pageIndex, Integer pageSize, Integer projectId) {
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId);
        return controller.GetList(pageIndex, pageSize);
    }

    @GetMapping("export")
    @ApiOperation(value = "导出所有数据", notes = "导出所有数据")
    public void ExportExcel(HttpServletResponse response, Integer projectId) {
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId);
        controller.ExportExcel("亲属关系", DataGaQsgx.class, response);
    }

    @PostMapping("upload")
    @ApiOperation(value = "上传数据", notes = "上传数据")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件流对象", required = true, dataType = "__File")})
    private ResponseData UploadData(@RequestParam("file") MultipartFile file, Integer bid, Integer projectId) {
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId);
        return controller.UploadData(file, bid, DataGaQsgx.class);
    }

    @PostMapping("add")
    @ApiOperation(value = "添加数据", notes = "添加数据")
    public ResponseData AddData(@RequestBody DataGaQsgx body, Integer projectId){
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId);
        return controller.AddData(body);
    }

    @PostMapping("update")
    @ApiOperation(value = "更新数据", notes = "更新数据")
    public ResponseData UpdateData(@RequestBody DataGaQsgx body, Integer projectId){
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId);
        return controller.UpdateData(body);
    }

    @PostMapping("delete/{id}")
    @ApiOperation(value = "删除数据", notes = "删除数据")
    public ResponseData DeleteData(@PathVariable Integer id, Integer projectId){
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId);
        return controller.DeleteData(id);
    }

    @GetMapping("remove")
    @ApiOperation(value = "删除所有数据", notes = "删除所有数据")
    private ResponseData RemoveAllData(Integer projectId) {
        QueryWrapper<DataGaQsgx> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", projectId);
        // 清空数据库中project_id为projectId的数据
        service.remove(queryWrapper);
        return ResponseData.OK("OK");
    }
}
