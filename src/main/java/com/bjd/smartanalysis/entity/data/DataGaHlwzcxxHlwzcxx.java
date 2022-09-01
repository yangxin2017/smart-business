package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_hlwzcxx_hlwzcxx")
@ExcelIgnoreUnannotated
public class DataGaHlwzcxxHlwzcxx {
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
    // 注册人姓名
    @ExcelProperty(value = "注册人姓名")
    @TableField("ZCRXM")
    private String ZCRXM;
    // 证件类型
    @ExcelProperty(value = "证件类型")
    @TableField("ZJLX")
    private String ZJLX;
    // 证件号码
    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;
    // 手机号码
    @ExcelProperty(value = "手机号码")
    @TableField("SJHM")
    private String SJHM;
    // 旅客类型
    @ExcelProperty(value = "旅客类型")
    @TableField("LKLX")
    private String LKLX;
    // 生日
    @ExcelProperty(value = "生日")
    @TableField("SR")
    private String SR;
    // 性别
    @ExcelProperty(value = "性别")
    @TableField("XB")
    private String XB;
    // 国籍
    @ExcelProperty(value = "国籍")
    @TableField("GJ")
    private String GJ;
    // 固定电话
    @ExcelProperty(value = "固定电话")
    @TableField("GDDH")
    private String GDDH;
    // 电子邮箱
    @ExcelProperty(value = "电子邮箱")
    @TableField("DZYX")
    private String DZYX;
    // 反馈人
    @ExcelProperty(value = "反馈人")
    @TableField("FKR")
    private String FKR;
    // 反馈时间
    @ExcelProperty(value = "反馈时间")
    @TableField("FKSJ")
    private String FKSJ;

}
