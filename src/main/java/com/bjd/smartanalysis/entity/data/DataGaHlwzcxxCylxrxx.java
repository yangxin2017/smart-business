package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_hlwzcxx_cylxrxx")
@ExcelIgnoreUnannotated
public class DataGaHlwzcxxCylxrxx {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    // 注册序号
    @ExcelProperty(value = "注册序号")
    @TableField("ZCXH")
    private String ZCXH;
    // 乘客姓名
    @ExcelProperty(value = "乘客姓名")
    @TableField("CKXM")
    private String CKXM;
    // 证件类型
    @ExcelProperty(value = "证件类型")
    @TableField("ZJLX")
    private String ZJLX;
    // 证件号码
    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;
    // 性别
    @ExcelProperty(value = "性别")
    @TableField("XB")
    private String XB;
    // 旅客类型
    @ExcelProperty(value = "旅客类型")
    @TableField("LKLX")
    private String LKLX;
    // 手机号码
    @ExcelProperty(value = "手机号码")
    @TableField("SJHM")
    private String SJHM;
    // 固定电话
    @ExcelProperty(value = "固定电话")
    @TableField("GDDH")
    private String GDDH;
    // 电子邮箱
    @ExcelProperty(value = "电子邮箱")
    @TableField("DZYX")
    private String DZYX;
    // 邮编
    @ExcelProperty(value = "邮编")
    @TableField("YB")
    private String YB;
    // 地址
    @ExcelProperty(value = "地址")
    @TableField("DZ")
    private String DZ;

}
