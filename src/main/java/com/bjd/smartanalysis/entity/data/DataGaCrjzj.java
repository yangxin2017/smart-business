package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_crjzj")
@ExcelIgnoreUnannotated
public class DataGaCrjzj {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    @ExcelProperty(value = "姓名")
    @TableField("XM")
    private String XM;

    @ExcelProperty(value = "身份证号")
    @TableField("SFZH")
    private String SFZH;

    @ExcelProperty(value = "证件种类")
    @TableField("ZJZL")
    private String ZJZL;

    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;

    @ExcelProperty(value = "签发日期")
    @TableField("QFRQ")
    private String QFRQ;

    @ExcelProperty(value = "截止日期")
    @TableField("JZRQ")
    private String JZRQ;

    @ExcelProperty(value = "前往地国家/地区")
    @TableField("QWDGJDQ")
    private String QWDGJDQ;

    @ExcelProperty(value = "签发机关")
    @TableField("QFJG")
    private String QFJG;

    @ExcelProperty(value = "性别")
    @TableField("XB")
    private String XB;

    @ExcelProperty(value = "民族")
    @TableField("MZ")
    private String MZ;

    @ExcelProperty(value = "出生日期")
    @TableField("CSRQ")
    private String CSRQ;

    @ExcelProperty(value = "出生地国家/地区")
    @TableField("CSDGJDQ")
    private String CSDGJDQ;

    @ExcelProperty(value = "户口所在地")
    @TableField("HKSZD")
    private String HKSZD;

    @ExcelProperty(value = "所属派出所")
    @TableField("HJPCS")
    private String HJPCS;

    @ExcelProperty(value = "出境事由")
    @TableField("CJSY")
    private String CJSY;

    @ExcelProperty(value = "入库时间")
    @TableField("RKSJ")
    private String RKSJ;

    @ExcelProperty(value = "更新时间")
    @TableField("GXSJ")
    private String GXSJ;
}
