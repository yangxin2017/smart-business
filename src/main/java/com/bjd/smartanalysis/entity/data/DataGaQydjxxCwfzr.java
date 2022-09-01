package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_qydjxx_cwfzr")
@ExcelIgnoreUnannotated
public class DataGaQydjxxCwfzr {
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
    // 财务负责人ID
    @ExcelProperty(value = "财务负责人ID")
    @TableField("CWFZRID")
    private String CWFZRID;
    // 主体身份代码
    @ExcelProperty(value = "主体身份代码")
    @TableField("ZTSFDM")
    private String ZTSFDM;
    // 财务负责人姓名
    @ExcelProperty(value = "财务负责人姓名")
    @TableField("CWFZRXM")
    private String CWFZRXM;
    // 财务负责人证件类型
    @ExcelProperty(value = "财务负责人证件类型")
    @TableField("CWFZRZJLX")
    private String CWFZRZJLX;
    // 财务负责人证件号码
    @ExcelProperty(value = "财务负责人证件号码")
    @TableField("CWFZRZJHM")
    private String CWFZRZJHM;
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
