package com.bjd.smartanalysis.controller.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjd.smartanalysis.common.ResponseData;
import com.bjd.smartanalysis.entity.data.DataGaMhdpjl;
import com.bjd.smartanalysis.entity.data.DataGaMhlgjl;
import com.bjd.smartanalysis.entity.data.DataGaRydzda;
import com.bjd.smartanalysis.service.DataFileService;
import com.bjd.smartanalysis.service.DataTypeService;
import com.bjd.smartanalysis.service.data.DataGaMhlgjlService;
import com.bjd.smartanalysis.service.data.DataGaRydzdaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Api(value = "民航离岗记录", tags = {"民航离岗记录"})
@RequestMapping("mhlgjl")
@RestController
public class DataGaMhlgjlController {
    @Value("${file.upload.path}")
    private String basePath;

    @Autowired
    private DataTypeService dataTypeService;
    @Autowired
    private DataFileService fileService;
    @Autowired
    private DataGaMhlgjlService service;

    private DataBaseController<DataGaMhlgjl> controller;

    @PostMapping("upload")
    @ApiOperation(value = "上传数据", notes = "上传数据")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件流对象", required = true, dataType = "__File")})
    private ResponseData UploadData(@RequestParam("file") MultipartFile file, Integer bid, Integer projectId) {
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId);
        return controller.UploadData(file, bid, DataGaMhlgjl.class);
    }

    @GetMapping("export")
    @ApiOperation(value = "导出所有数据", notes = "导出所有数据")
    public void ExportExcel(HttpServletResponse response, Integer projectId) {
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId);
        controller.ExportExcel("民航离岗记录", DataGaMhlgjl.class, response);
    }

    @GetMapping("list")
    @ApiOperation(value = "获取数据列表", notes = "获取数据列表")
    public ResponseData GetList(Integer pageIndex, Integer pageSize, Integer projectId) {
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId);
        return controller.GetList(pageIndex, pageSize);
    }

    @PostMapping("update")
    @ApiOperation(value = "更新数据", notes = "更新数据")
    public ResponseData UpdateData(@RequestBody DataGaMhlgjl body, Integer projectId){
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
        QueryWrapper<DataGaMhlgjl> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", projectId);
        // 清空数据库中project_id为projectId的数据
        service.remove(queryWrapper);
        return ResponseData.OK("OK");
    }
}
