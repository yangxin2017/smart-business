package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_zqxx_cybdxx")
@ExcelIgnoreUnannotated
public class DataGaZqxxCybdxx {
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
    // 市场类型
    @ExcelProperty(value = "市场类型")
    @TableField("SCLX")
    private String SCLX;
    // 证券账户
    @ExcelProperty(value = "证券账户")
    @TableField("ZQZH")
    private String ZQZH;
    // 证券账户状态
    @ExcelProperty(value = "证券账户状态")
    @TableField("ZQZHZT")
    private String ZQZHZT;
    // 证券代码
    @ExcelProperty(value = "证券代码")
    @TableField("ZQDM")
    private String ZQDM;
    // 证券简称
    @ExcelProperty(value = "证券简称")
    @TableField("ZQJC")
    private String ZQJC;
    // 证券类别
    @ExcelProperty(value = "证券类别")
    @TableField("ZQLB")
    private String ZQLB;
    // 过户日期
    @ExcelProperty(value = "过户日期")
    @TableField("GHRQ")
    private String GHRQ;
    // 过户数量
    @ExcelProperty(value = "过户数量")
    @TableField("GHSL")
    private String GHSL;
    // 流通类型
    @ExcelProperty(value = "流通类型")
    @TableField("LTLX")
    private String LTLX;
    // 权益编号
    @ExcelProperty(value = "权益编号")
    @TableField("QYBH")
    private String QYBH;
    // 权益类别
    @ExcelProperty(value = "权益类别")
    @TableField("QYLB")
    private String QYLB;
    // 挂牌年份
    @ExcelProperty(value = "挂牌年份")
    @TableField("GPNF")
    private String GPNF;
    // 过户类型
    @ExcelProperty(value = "过户类型")
    @TableField("GHLX")
    private String GHLX;
    // 交易单元
    @ExcelProperty(value = "交易单元")
    @TableField("JYDY")
    private String JYDY;
    // 股份性质
    @ExcelProperty(value = "股份性质")
    @TableField("GFXZ")
    private String GFXZ;
    // 托管单元
    @ExcelProperty(value = "托管单元")
    @TableField("TGDY")
    private String TGDY;
    // 托管单元名称
    @ExcelProperty(value = "托管单元名称")
    @TableField("TGDYMC")
    private String TGDYMC;
    // 结算人简称
    @ExcelProperty(value = "结算人简称")
    @TableField("JSRJC")
    private String JSRJC;
    // 交易日期
    @ExcelProperty(value = "交易日期")
    @TableField("JYRQ")
    private String JYRQ;
    // 买入/卖出
    @ExcelProperty(value = "买入/卖出")
    @TableField("MRMC")
    private String MRMC;

}
