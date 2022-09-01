package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_lccp_lccpxx")
@ExcelIgnoreUnannotated
public class DataGaLccpLccpxx {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

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
    // 性别
    @ExcelProperty(value = "性别")
    @TableField("XB")
    private String XB;
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
    // 投资者类别
    @ExcelProperty(value = "投资者类别")
    @TableField("TZZLB")
    private String TZZLB;
    // 联系地址
    @ExcelProperty(value = "联系地址")
    @TableField("LXDZ")
    private String LXDZ;
    // 紧急联系人
    @ExcelProperty(value = "紧急联系人")
    @TableField("JJLXR")
    private String JJLXR;
    // 紧急联系人证件类型
    @ExcelProperty(value = "紧急联系人证件类型")
    @TableField("JJLXRZJLX")
    private String JJLXRZJLX;
    // 紧急联系人证件号码
    @ExcelProperty(value = "紧急联系人证件号码")
    @TableField("JJLXRZJHM")
    private String JJLXRZJHM;
    // 紧急联系人联系方式
    @ExcelProperty(value = "紧急联系人联系方式")
    @TableField("JJLXRLXFS")
    private String JJLXRLXFS;
    // 产品名称
    @ExcelProperty(value = "产品名称")
    @TableField("CPMC")
    private String CPMC;
    // 产品登记编码
    @ExcelProperty(value = "产品登记编码")
    @TableField("CPDJBH")
    private String CPDJBH;
    // 产品运作模式
    @ExcelProperty(value = "产品运作模式")
    @TableField("CPYZMS")
    private String CPYZMS;
    // 产品募集方式
    @ExcelProperty(value = "产品募集方式")
    @TableField("CPMJFS")
    private String CPMJFS;
    // 产品收益类型
    @ExcelProperty(value = "产品收益类型")
    @TableField("CPSYLX")
    private String CPSYLX;
    // 收益率分档情况说明
    @ExcelProperty(value = "收益率分档情况说明")
    @TableField("SYLFDQKSM")
    private String SYLFDQKSM;
    // 目标客户类型
    @ExcelProperty(value = "目标客户类型")
    @TableField("MBKHLX")
    private String MBKHLX;
    // 发行机构
    @ExcelProperty(value = "发行机构")
    @TableField("FXJG")
    private String FXJG;
    // 预计客户最低年收益率（%）
    @ExcelProperty(value = "预计客户最低年收益率（%）")
    @TableField("YJKHZDNSYL")
    private String YJKHZDNSYL;
    // 预计客户最高年收益率（%）
    @ExcelProperty(value = "预计客户最高年收益率（%）")
    @TableField("YJKHZGNSYL")
    private String YJKHZGNSYL;
    // 业绩比较基准
    @ExcelProperty(value = "业绩比较基准")
    @TableField("YJBJZ")
    private String YJBJZ;
    // 是否结构化（分级）产品
    @ExcelProperty(value = "是否结构化（分级）产品")
    @TableField("SFJGHFJCP")
    private String SFJGHFJCP;
    // 初始净值
    @ExcelProperty(value = "初始净值")
    @TableField("CSJZ")
    private String CSJZ;
    // 产品净值
    @ExcelProperty(value = "产品净值")
    @TableField("CPJZ")
    private String CPJZ;
    // 累计净值
    @ExcelProperty(value = "累计净值")
    @TableField("LJJZ")
    private String LJJZ;
    // 募集起始日期
    @ExcelProperty(value = "募集起始日期")
    @TableField("MJQSRQ")
    private String MJQSRQ;
    // 产品起始日期
    @ExcelProperty(value = "产品起始日期")
    @TableField("CPQSRQ")
    private String CPQSRQ;
    // 投资行业信息
    @ExcelProperty(value = "投资行业信息")
    @TableField("TZHYXX")
    private String TZHYXX;
    // 持有信息
    @ExcelProperty(value = "持有信息")
    @TableField("CYXX")
    private String CYXX;


}
