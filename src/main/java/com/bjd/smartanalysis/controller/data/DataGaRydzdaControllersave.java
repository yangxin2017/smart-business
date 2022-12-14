/*
package com.bjd.smartanalysis.controller.data;

import com.bjd.smartanalysis.common.ResponseData;
import com.bjd.smartanalysis.entity.data.DataGaRydzda;
import com.bjd.smartanalysis.service.DataFileService;
import com.bjd.smartanalysis.service.DataTypeService;
import com.bjd.smartanalysis.service.data.DataGaRydzdaService;
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
public class DataGaRydzdaControllersave {
    @Value("${file.upload.path}")
    private String basePath;

    @Autowired
    private DataTypeService dataTypeService;
    @Autowired
    private DataFileService fileService;
    @Autowired
    private DataGaRydzdaService service;

    private DataBaseController<DataGaRydzda> controller;

    @PostMapping("upload")
    @ApiOperation(value = "上传数据", notes = "上传数据")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件流对象", required = true, dataType = "__File")})
    private ResponseData UploadData(@RequestParam("file") MultipartFile file, Integer bid, Integer projectId) {
        controller = new DataBaseController<>(service, dataTypeService, fileService, basePath, projectId);
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
    public ResponseData UpdateMBRData(Integer id, Boolean isMBR){
        DataGaRydzda user = service.getById(id);
        if(user != null) {
            user.setSfMbr(isMBR);
            service.updateById(user);
        }
        return ResponseData.OK(user);
    }
}
*/
