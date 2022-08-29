package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_tlspxx")
@ExcelIgnoreUnannotated
public class DataGaTlspxx {
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

    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;

    @ExcelProperty(value = "车号")
    @TableField("CH")
    private String CH;

    @ExcelProperty(value = "发车日期")
    @TableField("FCRQ")
    private String FCRQ;

    @ExcelProperty(value = "发站")
    @TableField("FZ")
    private String FZ;

    @ExcelProperty(value = "到站")
    @TableField("DZ")
    private String DZ;

    @ExcelProperty(value = "车厢号")
    @TableField("CXH")
    private String CXH;

    @ExcelProperty(value = "座位号")
    @TableField("ZWH")
    private String ZWH;

    @ExcelProperty(value = "票号")
    @TableField("PH")
    private String PH;

    @ExcelProperty(value = "车票状态")
    @TableField("CPZT")
    private String CPZT;

    @ExcelProperty(value = "证件类型")
    @TableField("ZJLX")
    private String ZJLX;

    @ExcelProperty(value = "更新时间")
    @TableField("GXSJ")
    private String GXSJ;

    @ExcelProperty(value = "信息删除标识")
    @TableField("XXSCBS")
    private String XXSCBS;

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
