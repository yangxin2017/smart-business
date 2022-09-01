package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_qydjxx_llyxx")
@ExcelIgnoreUnannotated
public class DataGaQydjxxLlyxx {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    // 反馈单位
    @ExcelProperty(value = "反馈单位")
    @TableField("FKDW")
    private String FKDW;
    // 审批表
    @ExcelProperty(value = "审批表")
    @TableField("SPB")
    private String SPB;
    // 名称
    @ExcelProperty(value = "名称")
    @TableField("MC")
    private String MC;
    // 证件类型
    @ExcelProperty(value = "证件类型")
    @TableField("ZJLX")
    private String ZJLX;
    // 证件号码
    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;
    // 企业（机构）名称
    @ExcelProperty(value = "企业（机构）名称")
    @TableField("QYJGMC")
    private String QYJGMC;
    // 联络员ID
    @ExcelProperty(value = "联络员ID")
    @TableField("LLYID")
    private String LLYID;
    // 主体身份代码
    @ExcelProperty(value = "主体身份代码")
    @TableField("ZTSFDM")
    private String ZTSFDM;
    // 联络员姓名
    @ExcelProperty(value = "联络员姓名")
    @TableField("LLYXM")
    private String LLYXM;
    // 联络员证件类型
    @ExcelProperty(value = "联络员证件类型")
    @TableField("LLYZJLX")
    private String LLYZJLX;
    // 联络员证件号码
    @ExcelProperty(value = "联络员证件号码")
    @TableField("LLYZJHM")
    private String LLYZJHM;
    // 固定电话
    @ExcelProperty(value = "固定电话")
    @TableField("GDDH")
    private String GDDH;
    // 移动电话
    @ExcelProperty(value = "移动电话")
    @TableField("YDDH")
    private String YDDH;
    // 电子邮箱
    @ExcelProperty(value = "电子邮箱")
    @TableField("DZYX")
    private String DZYX;

}
