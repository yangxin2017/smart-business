package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_qydjxx_zyry")
@ExcelIgnoreUnannotated
public class DataGaQydjxxZyry {
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
    // 人员ID
    @ExcelProperty(value = "人员ID")
    @TableField("RYID")
    private String RYID;
    // 主体身份代码
    @ExcelProperty(value = "主体身份代码")
    @TableField("ZTSFDM")
    private String ZTSFDM;
    // 主要人员姓名
    @ExcelProperty(value = "主要人员姓名")
    @TableField("ZYRYXM")
    private String ZYRYXM;
    // 性别
    @ExcelProperty(value = "性别")
    @TableField("XB")
    private String XB;
    // 出生日期
    @ExcelProperty(value = "出生日期")
    @TableField("CSRQ")
    private String CSRQ;
    // 主要人员证件类型
    @ExcelProperty(value = "主要人员证件类型")
    @TableField("ZYRYZJLX")
    private String ZYRYZJLX;
    // 证件号码/代表证编号
    @ExcelProperty(value = "证件号码/代表证编号")
    @TableField("ZJHMDBZBH")
    private String ZJHMDBZBH;
    // 职务
    @ExcelProperty(value = "职务")
    @TableField("ZW")
    private String ZW;
    // 职务产生方式
    @ExcelProperty(value = "职务产生方式")
    @TableField("ZWCSFS")
    private String ZWCSFS;
    // 申请前职业状况
    @ExcelProperty(value = "申请前职业状况")
    @TableField("SQQZYZK")
    private String SQQZYZK;
    // 法定代表人标志/首席代表标志/负责人标识
    @ExcelProperty(value = "法定代表人标志/首席代表标志/负责人标识")
    @TableField("FDDBRBZSXDBBZFZRBS")
    private String FDDBRBZSXDBBZFZRBS;
    // 任命单位/委派方
    @ExcelProperty(value = "任命单位/委派方")
    @TableField("RMDWWPF")
    private String RMDWWPF;
    // 联系电话
    @ExcelProperty(value = "联系电话")
    @TableField("LXDH")
    private String LXDH;
    // 国别(地区)
    @ExcelProperty(value = "国别(地区)")
    @TableField("GBDQ")
    private String GBDQ;
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
    // 住址
    @ExcelProperty(value = "住址")
    @TableField("ZZ")
    private String ZZ;
    // 入境时间
    @ExcelProperty(value = "入境时间")
    @TableField("RJSJ")
    private String RJSJ;
    // 代表证期限自/任职起始日期
    @ExcelProperty(value = "代表证期限自/任职起始日期")
    @TableField("DBZQXZRZQSRQ")
    private String DBZQXZRZQSRQ;
    // 代表证期限至/任职截止日期
    @ExcelProperty(value = "代表证期限至/任职截止日期")
    @TableField("DBZQXZRZJZRQ")
    private String DBZQXZRZJZRQ;
    // 邮政编码
    @ExcelProperty(value = "邮政编码")
    @TableField("YZBM")
    private String YZBM;

}
