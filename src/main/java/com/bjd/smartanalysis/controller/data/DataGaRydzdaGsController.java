package com.bjd.smartanalysis.controller.data;

import com.bjd.smartanalysis.common.ResponseData;
import com.bjd.smartanalysis.entity.data.DataGaRydzdaGs;
import com.bjd.smartanalysis.service.data.DataGaRydzdaGsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "人员电子档案--公司参股信息", tags = {"人员电子档案--公司参股信息"})
@RequestMapping("rydzdags")
@RestController
public class DataGaRydzdaGsController {
    @Autowired
    private DataGaRydzdaGsService gsService;

    @PostMapping("add")
    @ApiOperation(value = "添加数据", notes = "添加数据")
    public ResponseData AddData(@RequestBody DataGaRydzdaGs body){
        gsService.save(body);
        return ResponseData.OK(null);
    }

    @PostMapping("update")
    @ApiOperation(value = "更新数据", notes = "更新数据")
    public ResponseData UpdateData(@RequestBody DataGaRydzdaGs body){
        gsService.updateById(body);
        return ResponseData.OK(null);
    }

    @PostMapping("delete/{id}")
    @ApiOperation(value = "删除数据", notes = "删除数据")
    public ResponseData DeleteData(@PathVariable Integer id){
        gsService.removeById(id);
        return ResponseData.OK(null);
    }

    @GetMapping("list")
    @ApiOperation(value = "根据用户ID获取参股数据", notes = "根据用户ID获取参股数据")
    public ResponseData GetDataList(Integer userId){
        List<DataGaRydzdaGs> data = gsService.GetListByUserId(userId);
        return ResponseData.OK(data);
    }
}
