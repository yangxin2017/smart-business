package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_jrjgzh_glzzhxx")
@ExcelIgnoreUnannotated
public class DataGaJrjgzhGlzzhxx {
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
    // 查询账户
    @ExcelProperty(value = "查询账户")
    @TableField("CXZH")
    private String CXZH;
    // 账号
    @ExcelProperty(value = "账号")
    @TableField("ZH")
    private String ZH;
    // 子账户序号
    @ExcelProperty(value = "子账户序号")
    @TableField("ZZHXH")
    private String ZZHXH;
    // 子账户类别
    @ExcelProperty(value = "子账户类别")
    @TableField("ZZHLB")
    private String ZZHLB;
    // 子账户账号
    @ExcelProperty(value = "子账户账号")
    @TableField("ZZHZH")
    private String ZZHZH;
    // 币种
    @ExcelProperty(value = "币种")
    @TableField("BIZ")
    private String BIZ;
    // 钞汇标志
    @ExcelProperty(value = "钞汇标志")
    @TableField("CHBZ")
    private String CHBZ;
    // 账户余额
    @ExcelProperty(value = "账户余额")
    @TableField("ZHYE")
    private String ZHYE;
    // 账户状态
    @ExcelProperty(value = "账户状态")
    @TableField("ZHZT")
    private String ZHZT;
    // 可用余额
    @ExcelProperty(value = "可用余额")
    @TableField("KYYE")
    private String KYYE;

}
