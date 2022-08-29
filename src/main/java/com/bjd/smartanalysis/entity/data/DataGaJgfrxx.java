package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_jgfrxx")
@ExcelIgnoreUnannotated
public class DataGaJgfrxx {
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

    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;

    @ExcelProperty(value = "机构名称")
    @TableField("JGMC")
    private String JGMC;

    @ExcelProperty(value = "机构类型")
    @TableField("JGLX")
    private String JGLX;

    @ExcelProperty(value = "办证日期")
    @TableField("BZRQ")
    private String BZRQ;

    @ExcelProperty(value = "行政区划")
    @TableField("XZQH")
    private String XZQH;

    @ExcelProperty(value = "经营范围")
    @TableField("JYFW")
    private String JYFW;

    @ExcelProperty(value = "机构代码")
    @TableField("JGDM")
    private String JGDM;

    @ExcelProperty(value = "注册日期")
    @TableField("ZCRQ")
    private String ZCRQ;

    @ExcelProperty(value = "新经济行业")
    @TableField("XJJHY")
    private String XJJHY;

    @ExcelProperty(value = "常用证件")
    @TableField("CYZJ")
    private String CYZJ;

    @ExcelProperty(value = "作废日期")
    @TableField("ZFRQ")
    private String ZFRQ;

    @ExcelProperty(value = "邮政编码")
    @TableField("YZBB")
    private String YZBB;

    @ExcelProperty(value = "机构地址")
    @TableField("JGDZ")
    private String JGDZ;

    @ExcelProperty(value = "经济类型")
    @TableField("JJLX")
    private String JJLX;

    @ExcelProperty(value = "年检期限")
    @TableField("NJQX")
    private String NJQX;

    @ExcelProperty(value = "年检日期")
    @TableField("NJRQ")
    private String NJRQ;

    @ExcelProperty(value = "变更日期")
    @TableField("BGRQ")
    private String BGRQ;
}
