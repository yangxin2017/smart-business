package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_bxxx_bxryxx")
@ExcelIgnoreUnannotated
public class DataGaBxxxBxryxx {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    // 保单序号
    @ExcelProperty(value = "保单序号")
    @TableField("BDXH")
    private String BDXH;
    // 人员类别
    @ExcelProperty(value = "人员类别")
    @TableField("RYLB")
    private String RYLB;
    // 人员序号
    @ExcelProperty(value = "人员序号")
    @TableField("RYXH")
    private String RYXH;
    // 人员证件类型
    @ExcelProperty(value = "人员证件类型")
    @TableField("RYZJLX")
    private String RYZJLX;
    // 人员证件号码
    @ExcelProperty(value = "人员证件号码")
    @TableField("RYZJHM")
    private String RYZJHM;
    // 人员联系电话
    @ExcelProperty(value = "人员联系电话")
    @TableField("RYLXDH")
    private String RYLXDH;
    // 人员联系地址
    @ExcelProperty(value = "人员联系地址")
    @TableField("RYLXDZ")
    private String RYLXDZ;
    // 缴费账号
    @ExcelProperty(value = "缴费账号")
    @TableField("JFZH")
    private String JFZH;
    // 投保人名称
    @ExcelProperty(value = "投保人名称")
    @TableField("TBRMC")
    private String TBRMC;
    // 被保险人名称
    @ExcelProperty(value = "被保险人名称")
    @TableField("BXRMC")
    private String BXRMC;
    // 受益人名称
    @ExcelProperty(value = "受益人名称")
    @TableField("SYRMC")
    private String SYRMC;



}
