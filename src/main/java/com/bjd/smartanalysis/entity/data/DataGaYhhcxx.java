package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_yhhcxx")
@ExcelIgnoreUnannotated
public class DataGaYhhcxx {
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

    @ExcelProperty(value = "核查时间")
    @TableField("HCSJ")
    private String HCSJ;

    @ExcelProperty(value = "银行名称")
    @TableField("YHMC")
    private String YHMC;

    @ExcelProperty(value = "银行地址")
    @TableField("YHDZ")
    private String YHDZ;

    @ExcelProperty(value = "核查结果")
    @TableField("HCJG")
    private String HCJG;

    @ExcelProperty(value = "核查耗时")
    @TableField("HCHS")
    private String HCHS;

    @ExcelProperty(value = "认证码")
    @TableField("RZM")
    private String RZM;

    @ExcelProperty(value = "银行代码")
    @TableField("YHDM")
    private String YHDM;

    @ExcelProperty(value = "银行性质")
    @TableField("YHXZ")
    private String YHXZ;

    @ExcelProperty(value = "银行类型")
    @TableField("YHLX")
    private String YHLX;

    @ExcelProperty(value = "银行所在省")
    @TableField("YHSZS")
    private String YHSZS;

    @ExcelProperty(value = "银行所在市")
    @TableField("YHSZSHI")
    private String YHSZSHI;

    @ExcelProperty(value = "银行所在区县")
    @TableField("YHSZQX")
    private String YHSZQX;

    @ExcelProperty(value = "银行邮编")
    @TableField("YHYB")
    private String YHYB;

    @ExcelProperty(value = "银行邮箱")
    @TableField("YHYX")
    private String YHYX;

    @ExcelProperty(value = "业务类型")
    @TableField("YWLX")
    private String YWLX;

    @ExcelProperty(value = "核查总数")
    @TableField("HCZS")
    private String HCZS;

    @ExcelProperty(value = "核查人")
    @TableField("HCR")
    private String HCR;

    @ExcelProperty(value = "入库时间")
    @TableField("RKSJ")
    private String RKSJ;

    @ExcelProperty(value = "id")
    @TableField("NID")
    private String NID;

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
