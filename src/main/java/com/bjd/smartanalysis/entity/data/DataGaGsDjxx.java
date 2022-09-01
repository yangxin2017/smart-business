package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_gs_djxx")
@ExcelIgnoreUnannotated
public class DataGaGsDjxx {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    // 姓名
    @ExcelProperty(value = "姓名")
    @TableField("XM")
    private String XM;
    // 证件类型
    @ExcelProperty(value = "证件类型")
    @TableField("ZJLX")
    private String ZJLX;
    // 证件号码
    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;
    // 纳税人识别号
    @ExcelProperty(value = "纳税人识别号")
    @TableField("NSRSBH")
    private String NSRSBH;
    // 居住地址
    @ExcelProperty(value = "居住地址")
    @TableField("JZDZ")
    private String JZDZ;
    // 电子邮箱
    @ExcelProperty(value = "电子邮箱")
    @TableField("DZYX")
    private String DZYX;
    // 电话号码
    @ExcelProperty(value = "电话号码")
    @TableField("DHHM")
    private String DHHM;
    // 单位名称
    @ExcelProperty(value = "单位名称")
    @TableField("DWMC")
    private String DWMC;
    // 职务名称
    @ExcelProperty(value = "职务名称")
    @TableField("ZWMC")
    private String ZWMC;

}
