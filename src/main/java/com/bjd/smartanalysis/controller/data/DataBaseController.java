package com.bjd.smartanalysis.controller.data;

import cn.hutool.core.date.DateUtil;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.common.ResponseData;
import com.bjd.smartanalysis.common.UploadUtil;
import com.bjd.smartanalysis.entity.DataFile;
import com.bjd.smartanalysis.entity.DataType;
import com.bjd.smartanalysis.entity.data.DataGaRydzda;
import com.bjd.smartanalysis.service.DataFileService;
import com.bjd.smartanalysis.service.DataTypeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

public class DataBaseController<T> {

    private IService service;
    private DataTypeService dataTypeService;
    private DataFileService fileService;
    private String basePath;
    private Integer projectId;

    public DataBaseController(IService service, DataTypeService dataTypeService, DataFileService fileService, String basePath, Integer projectId) {
        this.service = service;
        this.dataTypeService = dataTypeService;
        this.fileService = fileService;
        this.basePath = basePath;
        this.projectId = projectId;
    }

    public ResponseData UploadData(MultipartFile file, Integer bid, Class cls) {
        if (file.isEmpty() || bid == null) {
            return ResponseData.FAIL("没有选择文件");
        }
        DataType dtype = dataTypeService.getById(bid);
        if (dtype == null) {
            return ResponseData.FAIL("数据类型不存在");
        }
        if(!UploadUtil.SaveFileToDatabase(file, cls, service, this.projectId)){
            return ResponseData.FAIL("数据导入失败");
        }

        DataFile df = UploadUtil.Upload(file, basePath, bid);
        if (df != null) {
            fileService.save(df);
        } else {
            return ResponseData.FAIL("文件上传失败");
        }

        return ResponseData.OK(df.getFilepath());
    }

    public ResponseData UploadFile(MultipartFile file, Integer bid) {
        if (file.isEmpty() || bid == null) {
            return ResponseData.FAIL("没有选择文件");
        }
        DataType dtype = dataTypeService.getById(bid);
        if (dtype == null) {
            return ResponseData.FAIL("数据类型不存在");
        }
        DataFile df = UploadUtil.Upload(file, basePath, bid);
        if (df != null) {
            fileService.save(df);
        } else {
            return ResponseData.FAIL("文件上传失败");
        }
        return ResponseData.OK(df.getFilepath());
    }

    public ResponseData GetList(Integer pageIndex, Integer pageSize) {
        IPage<T> page = new Page<>(pageIndex, pageSize);
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", this.projectId);
        page = service.page(page, queryWrapper);
        return ResponseData.OK(page);
    }

    public ResponseData AddData(@RequestBody T body) {
        service.save(body);
        return ResponseData.OK(body);
    }

    public ResponseData UpdateData(@RequestBody T body){
        service.updateById(body);
        return ResponseData.OK(body);
    }

    public ResponseData DeleteData(@PathVariable Integer id){
        service.removeById(id);
        return ResponseData.OK(null);
    }

    public void ExportExcel(String name, Class t, HttpServletResponse response) {
        List<T> data = service.list();
        try {
            String filename = name + "导出_" + DateUtil.format(new Date(), "YYYY_MM_DD_HH_mm_ss") + ".xlsx";
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            EasyExcel.write(response.getOutputStream(), t).sheet().doWrite(data);
        }catch (Exception e){
            System.out.println("导出失败！");
            e.printStackTrace();
        }
    }
}
