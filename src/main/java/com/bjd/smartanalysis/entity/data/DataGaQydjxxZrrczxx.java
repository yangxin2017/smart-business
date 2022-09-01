package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_qydjxx_zrrczxx")
@ExcelIgnoreUnannotated
public class DataGaQydjxxZrrczxx {
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
    // 投资人身份标识
    @ExcelProperty(value = "投资人身份标识")
    @TableField("TZRSFBS")
    private String TZRSFBS;
    // 主体身份代码
    @ExcelProperty(value = "主体身份代码")
    @TableField("ZTSFDM")
    private String ZTSFDM;
    // 自然人姓名
    @ExcelProperty(value = "自然人姓名")
    @TableField("ZRRSXM")
    private String ZRRSXM;
    // 自然人证件类型
    @ExcelProperty(value = "自然人证件类型")
    @TableField("ZRRZJLX")
    private String ZRRZJLX;
    // 自然人证件号码
    @ExcelProperty(value = "自然人证件号码")
    @TableField("ZRRZJHM")
    private String ZRRZJHM;
    // 认缴出资额（万元）
    @ExcelProperty(value = "认缴出资额（万元）")
    @TableField("RJCZEWY")
    private String RJCZEWY;
    // 认缴出资额折万美元（万美元）
    @ExcelProperty(value = "认缴出资额折万美元（万美元）")
    @TableField("RJCZEZWMYWMY")
    private String RJCZEZWMYWMY;
    // 认缴出资方式
    @ExcelProperty(value = "认缴出资方式")
    @TableField("RJCZFS")
    private String RJCZFS;
    // 认缴出资比例
    @ExcelProperty(value = "认缴出资比例")
    @TableField("RJCZBL")
    private String RJCZBL;
    // 认缴出资期限
    @ExcelProperty(value = "认缴出资期限")
    @TableField("RJCZQX")
    private String RJCZQX;
    // 实缴出资额（万元）
    @ExcelProperty(value = "实缴出资额（万元）")
    @TableField("SJCZEWY")
    private String SJCZEWY;
    // 实缴出资额折万美元（万美元）
    @ExcelProperty(value = "实缴出资额折万美元（万美元）")
    @TableField("SJCZEZWMYWMY")
    private String SJCZEZWMYWMY;
    // 住址
    @ExcelProperty(value = "住址")
    @TableField("ZZ")
    private String ZZ;
    // 币种
    @ExcelProperty(value = "币种")
    @TableField("BIZ")
    private String BIZ;
    // 国别(地区)
    @ExcelProperty(value = "国别(地区)")
    @TableField("GBDQ")
    private String GBDQ;
    // 执行合伙事务标志
    @ExcelProperty(value = "执行合伙事务标志")
    @TableField("ZXHHSWBZ")
    private String ZXHHSWBZ;
    // 承担责任方式/责任形式
    @ExcelProperty(value = "承担责任方式/责任形式")
    @TableField("CDZRFSZRXS")
    private String CDZRFSZRXS;
    // 出资方式（个独）
    @ExcelProperty(value = "出资方式（个独）")
    @TableField("CZFSGD")
    private String CZFSGD;
    // 性别
    @ExcelProperty(value = "性别")
    @TableField("XB")
    private String XB;
    // 民族
    @ExcelProperty(value = "民族")
    @TableField("MZ")
    private String MZ;
    // 出生日期
    @ExcelProperty(value = "出生日期")
    @TableField("CSRQ")
    private String CSRQ;
    // 文化程度
    @ExcelProperty(value = "文化程度")
    @TableField("WHCD")
    private String WHCD;
    // 政治面貌
    @ExcelProperty(value = "政治面貌")
    @TableField("ZZMM")
    private String ZZMM;
    // 职业状况
    @ExcelProperty(value = "职业状况")
    @TableField("ZYZK")
    private String ZYZK;
    // 邮政编码
    @ExcelProperty(value = "邮政编码")
    @TableField("YZBM")
    private String YZBM;
    // 电话
    @ExcelProperty(value = "电话")
    @TableField("DH")
    private String DH;

}
