package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_mhdpjl")
@ExcelIgnoreUnannotated
public class DataGaMhdpjl {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    @ExcelProperty(value = "旅客中文名")
    @TableField("LKZWM")
    private String LKZWM;

    @ExcelProperty(value = "身份证号")
    @TableField("SFZH")
    private String SFZH;

    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;

    @ExcelProperty(value = "出发日期时间")
    @TableField("CFRQSJ")
    private String CFRQSJ;

    @ExcelProperty(value = "出发日期")
    @TableField("CFRQ")
    private String CFRQ;

    @ExcelProperty(value = "出发时间")
    @TableField("CFSJ")
    private String CFSJ;

    @ExcelProperty(value = "起飞机场")
    @TableField("QFJC")
    private String QFJC;

    @ExcelProperty(value = "到达机场")
    @TableField("DDJC")
    private String DDJC;

    @ExcelProperty(value = "旅客英文姓")
    @TableField("LKYWX")
    private String LKYWX;

    @ExcelProperty(value = "旅客英文名")
    @TableField("LKYWM")
    private String LKYWM;

    @ExcelProperty(value = "证件类型")
    @TableField("ZJLX")
    private String ZJLX;

    @ExcelProperty(value = "到达日期")
    @TableField("DDRQ")
    private String DDRQ;

    @ExcelProperty(value = "到达时间")
    @TableField("DDSJ")
    private String DDSJ;

    @ExcelProperty(value = "承运航空公司")
    @TableField("CYHKGS")
    private String CYHKGS;

    @ExcelProperty(value = "航班号")
    @TableField("HBH")
    private String HBH;

    @ExcelProperty(value = "航班号后缀")
    @TableField("HBHHZ")
    private String HBHHZ;

    @ExcelProperty(value = "VIP标识")
    @TableField("VIPBS")
    private String VIPBS;

    @ExcelProperty(value = "代理人编号")
    @TableField("DLRBH")
    private String DLRBH;

    @ExcelProperty(value = "团体标识")
    @TableField("TTBS")
    private String TTBS;

    @ExcelProperty(value = "订座GDS")
    @TableField("DZGDS")
    private String DZGDS;

    @ExcelProperty(value = "共同订票标识")
    @TableField("GTDPBS")
    private String GTDPBS;

    @ExcelProperty(value = "索引Key值")
    @TableField("SYKEYZ")
    private String SYKEYZ;

    @ExcelProperty(value = "客票状态")
    @TableField("KPZT")
    private String KPZT;

    @ExcelProperty(value = "操作类型")
    @TableField("CZLX")
    private String CZLX;

    @ExcelProperty(value = "操作时间")
    @TableField("CZSJ")
    private String CZSJ;

    @ExcelProperty(value = "删除判断标识")
    @TableField("SCPDBS")
    private String SCPDBS;

    @ExcelProperty(value = "更新时间")
    @TableField("GXSJ")
    private String GXSJ;

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
