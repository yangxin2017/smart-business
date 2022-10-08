package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_lkzsxx")
@ExcelIgnoreUnannotated
public class DataGaLkzsxx {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    @ExcelProperty(value = "姓名", index = 0)
    @TableField("XM")
    private String XM;

    @ExcelProperty(value = "身份证号")
    @TableField("SFZH")
    private String SFZH;

    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;

    @ExcelProperty(value = "入住时间")
    @TableField("RZSJ")
    private String RZSJ;

    @ExcelProperty(value = "离店时间")
    @TableField("LDSJ")
    private String LDSJ;

    @ExcelProperty(value = "旅店名称")
    @TableField("LDMC")
    private String LDMC;

    @ExcelProperty(value = "房间号码")
    @TableField("FJHM")
    private String FJHM;

    @ExcelProperty(value = "旅店区划")
    @TableField("LDQH")
    private String LDQH;

    @ExcelProperty(value = "旅店地址")
    @TableField("LDDZ")
    private String LDDZ;

    @ExcelProperty(value = "证件类型")
    @TableField("ZJLX")
    private String ZJLX;

    @ExcelProperty(value = "国籍/地区")
    @TableField("GJDQ")
    private String GJDQ;

    @ExcelProperty(value = "性别")
    @TableField("XB")
    private String XB;

    @ExcelProperty(value = "民族")
    @TableField("MZ")
    private String MZ;

    @ExcelProperty(value = "出生日期")
    @TableField("CSRQ")
    private String CSRQ;

    @ExcelProperty(value = "户籍地区划")
    @TableField("HJDQH")
    private String HJDQH;

    @ExcelProperty(value = "户籍地详址")
    @TableField("HJDXZ")
    private String HJDXZ;

    @ExcelProperty(value = "旅店代码")
    @TableField("LDDM")
    private String LDDM;

    @ExcelProperty(value = "旅店负责人")
    @TableField("LDFZR")
    private String LDFZR;

    @ExcelProperty(value = "旅店房间数")
    @TableField("LDFJS")
    private String LDFJS;

    @ExcelProperty(value = "旅店床位数")
    @TableField("LDCWS")
    private String LDCWS;

    @ExcelProperty(value = "所属派出所名称")
    @TableField("SSPCSMC")
    private String SSPCSMC;

    @ExcelProperty(value = "机构数据位置")
    @TableField("JGSJWZ")
    private String JGSJWZ;

    @ExcelProperty(value = "省级名称")
    @TableField("SJMC")
    private String SJMC;

    @ExcelProperty(value = "入库时间")
    @TableField("RKSJ")
    private String RKSJ;

    @ExcelProperty(value = "更新时间")
    @TableField("GXSJ")
    private String GXSJ;

    @ExcelProperty(value = "信息删除标识")
    @TableField("XXSCBS")
    private String XXSCBS;

    @ExcelProperty(value = "户籍地_省")
    @TableField("HJS")
    private String HJS;

    @ExcelProperty(value = "户籍地_市")
    @TableField("HJSHI")
    private String HJSHI;

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
