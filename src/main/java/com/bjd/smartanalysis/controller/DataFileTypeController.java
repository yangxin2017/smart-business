package com.bjd.smartanalysis.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bjd.smartanalysis.common.ResponseData;
import com.bjd.smartanalysis.entity.DataType;
import com.bjd.smartanalysis.service.DataTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "数据类型", tags = {"基本数据---数据类型"})
@RequestMapping("datatype")
public class DataFileTypeController {
    @Autowired
    private DataTypeService dataTypeService;

    @GetMapping("file")
    @ApiOperation(value = "获取数据类型列表", notes = "获取数据类型列表")
    public ResponseData GetFileList() {
        List<DataType> lists = dataTypeService.list();

        return ResponseData.OK(lists);
    }

    @GetMapping("relation")
    @ApiOperation(value = "获取亲属关系列表", notes = "获取亲属关系列表")
    public ResponseData GetRelationList() {
        String[] relas = {"父子", "母子", "夫妻", "兄弟", "姐妹"};
        return ResponseData.OK(relas);
    }
}
