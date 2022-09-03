package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_jrjgzh_khjbxx")
@ExcelIgnoreUnannotated
public class DataGaJrjgzhKhjbxx {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    // 客户序号
    @ExcelProperty(value = "客户序号")
    @TableField("KHXH")
    private String KHXH;
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
    // 查询账户
    @ExcelProperty(value = "查询账户")
    @TableField("CXZH")
    private String CXZH;
    // 查询手机号码
    @ExcelProperty(value = "查询手机号码")
    @TableField("CXSJHM")
    private String CXSJHM;
    // 是否有财产
    @ExcelProperty(value = "是否有财产")
    @TableField("SFYCC")
    private String SFYCC;
    // 客户名称
    @ExcelProperty(value = "客户名称")
    @TableField("KHMC")
    private String KHMC;
    // 查询反馈结果原因
    @ExcelProperty(value = "查询反馈结果原因")
    @TableField("CXFKJGYY")
    private String CXFKJGYY;
    // 证件类型1
    @ExcelProperty(value = "证件类型1")
    @TableField("ZJLX1")
    private String ZJLX1;
    // 证件号码1
    @ExcelProperty(value = "证件号码1")
    @TableField("ZJHM1")
    private String ZJHM1;
    // 联系电话
    @ExcelProperty(value = "联系电话")
    @TableField("LXDH")
    private String LXDH;
    // 联系手机
    @ExcelProperty(value = "联系手机")
    @TableField("LXSJ")
    private String LXSJ;
    // 代办人姓名
    @ExcelProperty(value = "代办人姓名")
    @TableField("DBRXM")
    private String DBRXM;
    // 代办人证件类型
    @ExcelProperty(value = "代办人证件类型")
    @TableField("DBRZJLX")
    private String DBRZJLX;
    // 代办人证件号码
    @ExcelProperty(value = "代办人证件号码")
    @TableField("DBRZJHM")
    private String DBRZJHM;
    // 住宅地址
    @ExcelProperty(value = "住宅地址")
    @TableField("ZZDZ")
    private String ZZDZ;
    // 住宅电话
    @ExcelProperty(value = "住宅电话")
    @TableField("ZZDH")
    private String ZZDH;
    // 工作单位
    @ExcelProperty(value = "工作单位")
    @TableField("GZDW")
    private String GZDW;
    // 单位地址
    @ExcelProperty(value = "单位地址")
    @TableField("DWDZ")
    private String DWDZ;
    // 单位电话
    @ExcelProperty(value = "单位电话")
    @TableField("DWDH")
    private String DWDH;
    // 邮箱地址
    @ExcelProperty(value = "邮箱地址")
    @TableField("YXDZ")
    private String YXDZ;
    // 账单地址
    @ExcelProperty(value = "账单地址")
    @TableField("ZDDZ")
    private String ZDDZ;
    // 法人代表
    @ExcelProperty(value = "法人代表")
    @TableField("FRDB")
    private String FRDB;
    // 法人代表证件类型
    @ExcelProperty(value = "法人代表证件类型")
    @TableField("FRDBZJLX")
    private String FRDBZJLX;
    // 法人代表证件号码
    @ExcelProperty(value = "法人代表证件号码")
    @TableField("FRDBZJHM")
    private String FRDBZJHM;
    // 客户工商执照号码
    @ExcelProperty(value = "客户工商执照号码")
    @TableField("KHGSZZHM")
    private String KHGSZZHM;
    // 国税纳税号
    @ExcelProperty(value = "国税纳税号")
    @TableField("GSNSH")
    private String GSNSH;
    // 地税纳税号
    @ExcelProperty(value = "地税纳税号")
    @TableField("DSNSH")
    private String DSNSH;

}
