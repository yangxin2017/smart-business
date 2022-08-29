package com.bjd.smartanalysis.controller;

import cn.hutool.core.io.FileUtil;
import com.bjd.smartanalysis.common.ResponseData;
import com.bjd.smartanalysis.entity.DataFile;
import com.bjd.smartanalysis.entity.DataType;
import com.bjd.smartanalysis.entity.data.DataGaRydzda;
import com.bjd.smartanalysis.service.DataFileService;
import com.bjd.smartanalysis.service.DataTypeService;
import com.bjd.smartanalysis.service.data.DataGaRydzdaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "文件管理", tags = {"文件管理"})
@RequestMapping("file")
public class FileManagerController {

    @Value("${file.upload.path}")
    private String basePath;

    @Autowired
    private DataFileService fileService;
    @Autowired
    private DataTypeService dataTypeService;
    @Autowired
    private DataGaRydzdaService rydzdaService;

    @PostMapping("upload")
    @ApiOperation(value = "上传文件", notes = "上传文件")
    public ResponseData FileUpload(@RequestParam("file")MultipartFile file, Integer bid, Integer userId) {
        if (file.isEmpty()) {
            return ResponseData.FAIL("没有选择文件");
        }

        if (bid != null) {
            DataType dtype = dataTypeService.getById(bid);
            if (dtype == null) {
                return ResponseData.FAIL("数据类型不存在");
            }
        }

        String name = file.getOriginalFilename();
        Long size = file.getSize();
        String stuf = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        String relativePath = getCurDatePath();
        String newFilename = relativePath + "/" + UUID.randomUUID() + stuf;
        String filepath = basePath + "/" + newFilename;

        try{
            FileUtil.mkParentDirs(filepath);
            file.transferTo(new File(filepath));
            ////////
            DataFile df = new DataFile();
            df.setCtime(new Date());
            df.setFilename(name);
            df.setSuffix(stuf);
            df.setFilesize(size.toString());
            df.setFilepath(newFilename);
            df.setBelongId(bid);
            fileService.save(df);

            if (userId != null) {
                DataGaRydzda user = rydzdaService.getById(userId);
                if(user != null) {
                    user.setTXZP(df.getFilepath());
                    rydzdaService.updateById(user);
                }
            }

        }catch (Exception e) {
            return ResponseData.FAIL("文件上传失败");
        }
        return ResponseData.OK(newFilename);
    }

    @GetMapping("download")
    @ApiOperation(value = "下载文件", notes = "下载文件")
    public String DownloadFIle(HttpServletResponse response, Integer id) {
        if (id != null) {
            DataFile file = fileService.getById(id);
            if (file != null) {
                String path = file.getFilepath();
                String fileLoc = basePath + "/" + path;
                String fileName = file.getFilename();
                try {
                    return this.downloadFile(response, fileLoc, fileName);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return "下载文件不存在";
    }

    @GetMapping("listByBid")
    @ApiOperation(value = "获取数据类型下面的文件", notes = "获取数据类型下面的文件")
    public ResponseData GetListByBelongId(Integer bid) {
        if (bid == null) {
            return ResponseData.FAIL("数据类型不存在");
        }
        DataType dtype = dataTypeService.getById(bid);
        if (dtype == null) {
            return ResponseData.FAIL("数据类型不存在");
        }

        List<DataFile> files = fileService.GetFileByBid(bid);
        return ResponseData.OK(files);
    }

    private String downloadFile(HttpServletResponse response, String fileloc, String fileName) throws UnsupportedEncodingException {
        File file = new File(fileloc);
        if(!file.exists()){
            return "下载文件不存在";
        }
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        String name = new String(fileName.getBytes("GBK"), "ISO-8859-1");
        response.setHeader("Content-Disposition", "attachment;filename=" + name );

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));) {
            byte[] buff = new byte[1024];
            OutputStream os  = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            return "下载失败";
        }
        return "下载成功";
    }

    private String getCurDatePath() {
        Calendar calendar = Calendar.getInstance();
        Integer year = calendar.get(Calendar.YEAR);
        Integer month = calendar.get(Calendar.MONTH) + 1;
        Integer day = calendar.get(Calendar.DATE);
        String monthstr = month < 10 ? "0" + month : month.toString();
        String daystr = day < 10 ? "0" + day : day.toString();

        return year + "/" + monthstr + "/" + daystr;
    }
}
