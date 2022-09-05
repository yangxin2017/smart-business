package com.bjd.smartanalysis.controller.data;

import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjd.smartanalysis.common.ResponseData;
import com.bjd.smartanalysis.common.UploadUtil;
import com.bjd.smartanalysis.entity.DataFile;
import com.bjd.smartanalysis.entity.DataType;
import com.bjd.smartanalysis.entity.data.DataBank;
import com.bjd.smartanalysis.excellistener.DataBankListener;
import com.bjd.smartanalysis.service.DataFileService;
import com.bjd.smartanalysis.service.DataTypeService;
import com.bjd.smartanalysis.service.data.DataBankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(value = "银行数据", tags = {"银行数据"})
@RequestMapping("bank")
@RestController
public class DataBankController {
    @Value("${file.upload.path}")
    private String basePath;

    @Autowired
    private DataBankService bankService;
    @Autowired
    private DataTypeService dataTypeService;
    @Autowired
    private DataFileService fileService;

    @PostMapping("upload")
    @ApiOperation(value = "上传数据", notes = "上传数据")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件流对象", required = true, dataType = "__File")})
    private ResponseData UploadData(@RequestParam("file") MultipartFile file, Integer bid, Integer projectId){
        if (file.isEmpty() || bid == null) {
            return ResponseData.FAIL("没有选择文件");
        }
        DataType dtype = dataTypeService.getById(bid);
        if (dtype == null) {
            return ResponseData.FAIL("数据类型不存在");
        }
        if(!SaveFileToDatabase(file, projectId)){
            return ResponseData.FAIL("数据导入失败");
        }

        DataFile df = UploadUtil.Upload(file, basePath, bid);
        if (df != null) {
            fileService.save(df);
        } else {
            return ResponseData.FAIL("文件上传失败");
        }

        return ResponseData.OK(null);
    }

    @PostMapping("upload_jh")
    @ApiOperation(value = "上传数据建行", notes = "上传数据建行")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件流对象", required = true, dataType = "__File")})
    private ResponseData UploadDataJH(@RequestParam("file") MultipartFile file, Integer bid, String name) {
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
            try {
                File f = new File(basePath + df.getFilepath());
                ExcelReader reader = ExcelUtil.getReader(f);
                List<List<Object>> lists = reader.read();

                List<DataBank> banks = new ArrayList<>();
                for (int i=1;i<lists.size();i++) {
                    List<Object> row = lists.get(i);
                    DataBank bk = new DataBank();
                    bk.setCXDXMC(name);
                    bk.setBFKH(row.get(0).toString().trim());
                    bk.setBFZH(row.get(1).toString().trim());
                    bk.setJYSJ(row.get(2).toString().trim());
                    bk.setJYJE(row.get(4).toString().trim());
                    bk.setJYYE(row.get(5).toString().trim());
                    bk.setJYDFZH(row.get(6).toString().trim());
                    bk.setJYDFMC(row.get(7).toString().trim());
                    bk.setCPH(row.get(8).toString().trim());
                    bk.setRZH(row.get(9).toString().trim());
                    bk.setJYWDDM(row.get(11).toString().trim());
                    bk.setJYDFZHKHH(row.get(12).toString().trim());
                    bk.setJYZY(row.get(13).toString().trim());
                    bk.setBZ(row.get(14).toString().trim());
                    banks.add(bk);
                }
                bankService.saveBatch(banks);
                return ResponseData.OK(null);
            }catch (Exception ex) {
                ex.printStackTrace();
                return ResponseData.FAIL("数据导入失败");
            }

        } else {
            return ResponseData.FAIL("文件上传失败");
        }
    }

    @GetMapping("listByIds")
    @ApiOperation(value = "根据Ids字符串获取数据列表", notes = "根据Ids字符串获取数据列表")
    private ResponseData GetList(String ids) {
        String[] idarrStr = ids.split(",");
        List<String> idArr = new ArrayList<>();
        for(String i: idarrStr) {
            idArr.add(i);
        }
        List<DataBank> datas = bankService.listByIds(idArr);
        return ResponseData.OK(datas);
    }

    @GetMapping("list")
    @ApiOperation(value = "获取数据列表", notes = "获取数据列表")
    private ResponseData GetList(Integer pageIndex, Integer pageSize, Integer projectId, String mc,String zjhm,String cxkh,String jyje,String jydfmc,String jydfkh,String jydfzjhm) {
        IPage<DataBank> page = new Page<>(pageIndex, pageSize);
        QueryWrapper<DataBank> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("project_id", projectId);
        if(mc != null && !mc.isEmpty()) {
            queryWrapper.like("MC", mc);
        }
        if(zjhm != null && !zjhm.isEmpty()) {
            queryWrapper.like("ZJHM", zjhm);
        }
        if(cxkh != null && !cxkh.isEmpty()) {
            queryWrapper.like("CXKH", cxkh);
        }
        if(jyje != null && !jyje.isEmpty()) {
            String[] jyjeArr = jyje.split("-");
            if(jyjeArr.length == 1) {
                queryWrapper.ge("JYJE", Float.parseFloat(jyjeArr[0]));
            }else if(jyjeArr.length == 2) {
                queryWrapper.between("JYJE", Float.parseFloat(jyjeArr[0]), Float.parseFloat(jyjeArr[1]));
            }
        }
        if(jydfmc != null && !jydfmc.isEmpty()) {
            queryWrapper.like("JYDFMC", jydfmc);
        }
        if(jydfkh != null && !jydfkh.isEmpty()) {
            queryWrapper.like("JYDFKH", jydfkh);
        }
        if(jydfzjhm != null && !jydfzjhm.isEmpty()) {
            queryWrapper.like("JYDFZJHM", jydfzjhm);
        }

        page = bankService.page(page, queryWrapper);
        return ResponseData.OK(page);
    }

    @PostMapping("update")
    @ApiOperation(value = "更新数据", notes = "更新数据")
    private ResponseData UpdateData(@RequestBody DataBank bank) {
        bankService.updateById(bank);
        return ResponseData.OK(bank);
    }

    @PostMapping("delete/{id}")
    @ApiOperation(value = "删除数据", notes = "删除数据")
    private ResponseData DeleteData(@PathVariable Integer id){
        bankService.removeById(id);
        return ResponseData.OK(null);
    }

    @GetMapping("export")
    @ApiOperation(value = "导出所有数据", notes = "导出所有数据")
    public void ExportExcel(HttpServletResponse response) {
        List<DataBank> data = bankService.list();
        try {
            String filename = "银行信息导出_" + DateUtil.format(new Date(), "YYYY_MM_DD_HH_mm_ss") + ".xlsx";
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            EasyExcel.write(response.getOutputStream(), DataBank.class).sheet().doWrite(data);
        }catch (Exception e){
            System.out.println("导出失败！");
            e.printStackTrace();
        }
    }

    private boolean SaveFileToDatabase(MultipartFile file, Integer projectId) {
        try {
            EasyExcel.read(file.getInputStream(), DataBank.class, new DataBankListener(bankService, projectId)).sheet().doRead();
        }catch (Exception ex){
            System.out.println("导入失败！");
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
