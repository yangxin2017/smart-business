package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_rydzda")
@ExcelIgnoreUnannotated
public class DataGaRydzda {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    @ExcelProperty(value = "UUID")
    @TableField("TXZP")
    private String TXZP;

    // 公民身份证号
    @ExcelProperty(value = "公民身份证号")
    @TableField("SFZH")
    private String SFZH;
    // 姓名
    @ExcelProperty(value = "姓名")
    @TableField("XM")
    private String XM;
    // 性别
    @ExcelProperty(value = "性别")
    @TableField("XB")
    private String XB;
    // 民族
    @ExcelProperty(value = "民族")
    @TableField("MZ")
    private String MZ;
    // 户籍地
    @ExcelProperty(value = "户籍地")
    @TableField("HJD")
    private String HJD;
    // 户籍地区划
    @ExcelProperty(value = "户籍地区划")
    @TableField("HJDQH")
    private String HJDQH;
    // 户籍地派出所
    @ExcelProperty(value = "户籍地派出所")
    @TableField("HJDPCS")
    private String HJDPCS;
    // 出生日期
    @ExcelProperty(value = "出生日期")
    @TableField("CSRQ")
    private String CSRQ;
    // 曾用名
    @ExcelProperty(value = "曾用名")
    @TableField("CYM")
    private String CYM;
    // 出生地
    @ExcelProperty(value = "出生地")
    @TableField("CSD")
    private String CSD;
    // 籍贯
    @ExcelProperty(value = "籍贯")
    @TableField("JG")
    private String JG;
    // 身高
    @ExcelProperty(value = "身高")
    @TableField("SG")
    private String SG;
    // 职业
    @ExcelProperty(value = "职业")
    @TableField("ZY")
    private String ZY;
    // 出生地国家
    @ExcelProperty(value = "出生地国家")
    @TableField("CSDGJ")
    private String CSDGJ;
    // 出生地区划
    @ExcelProperty(value = "出生地区划")
    @TableField("CSDQH")
    private String CSDQH;
    // 籍贯国家
    @ExcelProperty(value = "籍贯国家")
    @TableField("JGGJ")
    private String JGGJ;
    // 服务处所
    @ExcelProperty(value = "服务处所")
    @TableField("FWCS")
    private String FWCS;
    // 兵役状况
    @ExcelProperty(value = "兵役状况")
    @TableField("BYZK")
    private String BYZK;
    // 文化程度
    @ExcelProperty(value = "文化程度")
    @TableField("WHCD")
    private String WHCD;
    // 婚姻状况
    @ExcelProperty(value = "婚姻状况")
    @TableField("HYZK")
    private String HYZK;
    // 死亡日期
    @ExcelProperty(value = "死亡日期")
    @TableField("SWRQ")
    private String SWRQ;


    @TableField("sf_mbr")
    private Boolean sfMbr;

    @TableField("sf_fxdx")
    private Boolean sfFxdx;

}
