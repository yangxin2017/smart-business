package com.bjd.smartanalysis.common;

import cn.hutool.core.io.FileUtil;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.DataFile;
import com.bjd.smartanalysis.excellistener.DataGaListener;
import com.bjd.smartanalysis.service.data.SysErrorViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class UploadUtil {
    public static DataFile Upload(MultipartFile file, String basePath, Integer bid,Integer eid,SysErrorViewService errorViewService) {
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
            return df;
        }catch (Exception e) {
            // 在sysErrorViewService中记录错误
            errorViewService.saveError(0, eid, e.getMessage(),name);
            return null;
        }
    }

    private static String getCurDatePath() {
        Calendar calendar = Calendar.getInstance();
        Integer year = calendar.get(Calendar.YEAR);
        Integer month = calendar.get(Calendar.MONTH) + 1;
        Integer day = calendar.get(Calendar.DATE);
        String monthstr = month < 10 ? "0" + month : month.toString();
        String daystr = day < 10 ? "0" + day : day.toString();

        return year + "/" + monthstr + "/" + daystr;
    }

    public static boolean SaveFileToDatabase(MultipartFile file, Class cls, IService service, Integer projectId,Integer eid,SysErrorViewService errorViewService) {
        try {
            EasyExcel.read(file.getInputStream(), cls, new DataGaListener(service, projectId,eid,errorViewService)).sheet().doRead();
        }catch (Exception ex){
            System.out.println("导入失败！");
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean SaveFileToDatabase(MultipartFile file, Class cls, IService service, Integer projectId) {
        try {
            EasyExcel.read(file.getInputStream(), cls, new DataGaListener(service, projectId)).sheet().doRead();
        }catch (Exception ex){
            System.out.println("导入失败！");
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
