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

    @ExcelProperty(value = "头像照片")
    @TableField("TXZP")
    private String TXZP;

    @ExcelProperty(value = "姓名")
    @TableField("XM")
    private String XM;

    @ExcelProperty(value = "性别")
    @TableField("XB")
    private String XB;

    @ExcelProperty(value = "身份证号码")
    @TableField("SFZH")
    private String SFZH;

    @ExcelProperty(value = "民族")
    @TableField("MZ")
    private String MZ;

    @ExcelProperty(value = "出生日期")
    @TableField("CSRQ")
    private String CSRQ;

    @ExcelProperty(value = "婚姻状况")
    @TableField("HYZK")
    private String HYZK;

    @ExcelProperty(value = "生肖")
    @TableField("SX")
    private String SX;

    @ExcelProperty(value = "星座")
    @TableField("XZ")
    private String XZ;

    @ExcelProperty(value = "别名绰号")
    @TableField("BMCH")
    private String BMCH;

    @ExcelProperty(value = "曾用名")
    @TableField("CYM")
    private String CYM;

    @ExcelProperty(value = "身高")
    @TableField("SG")
    private String SG;

    @ExcelProperty(value = "血型")
    @TableField("XX")
    private String XX;

    @ExcelProperty(value = "最高学历")
    @TableField("ZGXL")
    private String ZGXL;

    @ExcelProperty(value = "政治面貌")
    @TableField("ZZMM")
    private String ZZMM;

    @ExcelProperty(value = "职业")
    @TableField("ZY")
    private String ZY;

    @ExcelProperty(value = "从业单位")
    @TableField("CYDW")
    private String CYDW;

    @ExcelProperty(value = "兵役状况")
    @TableField("BYZK")
    private String BYZK;

    @ExcelProperty(value = "体貌特征描述")
    @TableField("TMTZMS")
    private String TMTZMS;

    @ExcelProperty(value = "出生地区划")
    @TableField("CSDQH")
    private String CSDQH;

    @ExcelProperty(value = "籍贯")
    @TableField("JG")
    private String JG;

    @ExcelProperty(value = "户籍地区划")
    @TableField("HJDQH")
    private String HJDQH;

    @ExcelProperty(value = "户籍地址")
    @TableField("HJDZ")
    private String HJDZ;

    @ExcelProperty(value = "其他地址")
    @TableField("QTDZ")
    private String QTDZ;

    @ExcelProperty(value = "行为标签")
    @TableField("XWBQ")
    private String XWBQ;

    @TableField("sf_mbr")
    private Boolean sfMbr;

}
