package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_crjjl")
@ExcelIgnoreUnannotated
public class DataGaCrjjl {
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

    @ExcelProperty(value = "国籍/地区")
    @TableField("GJDQ")
    private String GJDQ;

    @ExcelProperty(value = "性别")
    @TableField("XB")
    private String XB;

    @ExcelProperty(value = "身份证号")
    @TableField("SFZH")
    private String SFZH;

    @ExcelProperty(value = "证件类别")
    @TableField("ZJLB")
    private String ZJLB;

    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;

    @ExcelProperty(value = "出生日期")
    @TableField("CSRQ")
    private String CSRQ;

    @ExcelProperty(value = "出入日期时间")
    @TableField("CRRQSJ")
    private String CRRQSJ;

    @ExcelProperty(value = "出入日期")
    @TableField("CRRQ")
    private String CRRQ;

    @ExcelProperty(value = "出入时间")
    @TableField("CRSJ")
    private String CRSJ;

    @ExcelProperty(value = "出入口岸")
    @TableField("CRKA")
    private String CRKA;

    @ExcelProperty(value = "签证种类")
    @TableField("QZZL")
    private String QZZL;

    @ExcelProperty(value = "签证号码")
    @TableField("QZHM")
    private String QZHM;

    @ExcelProperty(value = "前往/归来国家/地区")
    @TableField("QWGLGJDQ")
    private String QWGLGJDQ;

    @ExcelProperty(value = "出入境类别")
    @TableField("CRJLB")
    private String CRJLB;

    @ExcelProperty(value = "交通方式")
    @TableField("JTFS")
    private String JTFS;

    @ExcelProperty(value = "交通工具")
    @TableField("JTGJ")
    private String JTGJ;

    @ExcelProperty(value = "旅游团号")
    @TableField("LYTH")
    private String LYTH;

    @ExcelProperty(value = "入库时间")
    @TableField("RKSJ")
    private String RKSJ;

    @ExcelProperty(value = "更新时间")
    @TableField("GXSJ")
    private String GXSJ;

    @ExcelProperty(value = "操作类型")
    @TableField("CZLX")
    private String CZLX;

    @ExcelProperty(value = "操作时间")
    @TableField("CZSJ")
    private String CZSJ;

    @ExcelProperty(value = "户籍地_省")
    @TableField("HJDS")
    private String HJDS;

    @ExcelProperty(value = "户籍地_市")
    @TableField("HJDSHI")
    private String HJDSHI;

    @ExcelProperty(value = "户籍地_县")
    @TableField("HJDX")
    private String HJDX;

    @ExcelProperty(value = "籍贯_省")
    @TableField("JGS")
    private String JGS;

    @ExcelProperty(value = "籍贯_市")
    @TableField("JGSHI")
    private String JGSHI;

    @ExcelProperty(value = "籍贯_县")
    @TableField("JGX")
    private String JGX;
}
