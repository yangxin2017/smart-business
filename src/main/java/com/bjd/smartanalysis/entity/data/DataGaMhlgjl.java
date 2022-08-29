package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_mhlgjl")
@ExcelIgnoreUnannotated
public class DataGaMhlgjl {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    @ExcelProperty(value = "旅客中文姓名")
    @TableField("LKZWXM")
    private String LKZWXM;

    @ExcelProperty(value = "身份证号")
    @TableField("SFZH")
    private String SFZH;

    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;

    @ExcelProperty(value = "航班日期")
    @TableField("HBRQ")
    private String HBRQ;

    @ExcelProperty(value = "起飞港站")
    @TableField("QFGZ")
    private String QFGZ;

    @ExcelProperty(value = "到达航站")
    @TableField("DDHZ")
    private String DDHZ;

    @ExcelProperty(value = "航空公司")
    @TableField("HKGS")
    private String HKGS;

    @ExcelProperty(value = "航班号")
    @TableField("HBH")
    private String HBH;

    @ExcelProperty(value = "旅客名")
    @TableField("LKM")
    private String LKM;

    @ExcelProperty(value = "旅客中间名")
    @TableField("LKZJM")
    private String LKZJM;

    @ExcelProperty(value = "旅客姓")
    @TableField("LKX")
    private String LKX;

    @ExcelProperty(value = "性别")
    @TableField("XB")
    private String XB;

    @ExcelProperty(value = "出生日期")
    @TableField("CSRQ")
    private String CSRQ;

    @ExcelProperty(value = "证件类型")
    @TableField("ZJLX")
    private String ZJLX;

    @ExcelProperty(value = "旅客姓名")
    @TableField("LKXM")
    private String LKXM;

    @ExcelProperty(value = "出生地")
    @TableField("CSD")
    private String CSD;

    @ExcelProperty(value = "航班后缀")
    @TableField("HBHZ")
    private String HBHZ;

    @ExcelProperty(value = "旅客座位")
    @TableField("LKZW")
    private String LKZW;

    @ExcelProperty(value = "离港时间")
    @TableField("LGSJ")
    private String LGSJ;

    @ExcelProperty(value = "进港时间")
    @TableField("JGSJ")
    private String JGSJ;

    @ExcelProperty(value = "离港国家/地区")
    @TableField("LGGJDQ")
    private String LGGJDQ;

    @ExcelProperty(value = "进港国家/地区")
    @TableField("JGGJDQ")
    private String JGGJDQ;

    @ExcelProperty(value = "旅客出入境标识")
    @TableField("LKCRJBS")
    private String LKCRJBS;

    @ExcelProperty(value = "旅客国家/地区")
    @TableField("LKGJDQ")
    private String LKGJDQ;

    @ExcelProperty(value = "发证国家/地区")
    @TableField("FZGJDQ")
    private String FZGJDQ;

    @ExcelProperty(value = "发证日期")
    @TableField("FZRQ")
    private String FZRQ;

    @ExcelProperty(value = "过期日期")
    @TableField("GQRQ")
    private String GQRQ;

    @ExcelProperty(value = "值机时间")
    @TableField("ZJSJ")
    private String ZJSJ;

    @ExcelProperty(value = "值机办公室")
    @TableField("ZJBGS")
    private String ZJBGS;

    @ExcelProperty(value = "执行旅客操作的终端号")
    @TableField("ZXLKCZDZDH")
    private String ZXLKCZDZDH;

    @ExcelProperty(value = "执行值机的代理号")
    @TableField("ZXZJDDLH")
    private String ZXZJDDLH;

    @ExcelProperty(value = "ICS中记录信息")
    @TableField("ICSZJLXX")
    private String ICSZJLXX;

    @ExcelProperty(value = "共同订票标识字段")
    @TableField("GTDPBSZD")
    private String GTDPBSZD;

    @ExcelProperty(value = "信息删除标识")
    @TableField("XXSCBS")
    private String XXSCBS;

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
