package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_zrzyb")
@ExcelIgnoreUnannotated
public class DataGaZrzyb {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    @ExcelProperty(value = "反馈单位")
    @TableField("FKDW")
    private String FKDW;

    @ExcelProperty(value = "审批表")
    @TableField("SPB")
    private String SPB;

    @ExcelProperty(value = "名称")
    @TableField("MC")
    private String MC;

    @ExcelProperty(value = "证件类型")
    @TableField("ZJLX")
    private String ZJLX;

    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;

    @ExcelProperty(value = "是否有财产")
    @TableField("SFYCC")
    private String SFYCC;

    @ExcelProperty(value = "查询请求单号")
    @TableField("CXQQDH")
    private String CXQQDH;

    @ExcelProperty(value = "查询申请地区")
    @TableField("CXSQDQ")
    private String CXSQDQ;

    @ExcelProperty(value = "查询申请地区号")
    @TableField("CXSQDQH")
    private String CXSQDQH;

    @ExcelProperty(value = "权利人名称")
    @TableField("QLRMC")
    private String QLRMC;

    @ExcelProperty(value = "权利人证件号码")
    @TableField("QLRZJHM")
    private String QLRZJHM;

    @ExcelProperty(value = "查询结果数")
    @TableField("CXJGS")
    private String CXJGS;

    @ExcelProperty(value = "权利类型")
    @TableField("QLLX")
    private String QLLX;

    @ExcelProperty(value = "不动产坐落")
    @TableField("BDCZL")
    private String BDCZL;

    @ExcelProperty(value = "不动产面积")
    @TableField("BDCMJ")
    private String BDCMJ;

    @ExcelProperty(value = "规划用途")
    @TableField("GHYT")
    private String GHYT;

    @ExcelProperty(value = "共有权人名称")
    @TableField("GYQRMC")
    private String GYQRMC;

    @ExcelProperty(value = "共用方式")
    @TableField("GYFS")
    private String GYFS;

    @ExcelProperty(value = "不动产单元号")
    @TableField("BDCDYH")
    private String BDCDYH;

    @ExcelProperty(value = "登记时间")
    @TableField("DJSJ")
    private String DJSJ;

    @ExcelProperty(value = "权属状态")
    @TableField("QSZT")
    private String QSZT;

    @ExcelProperty(value = "是否抵押")
    @TableField("SFDY")
    private String SFDY;

    @ExcelProperty(value = "是否查封")
    @TableField("SFCF")
    private String SFCF;

    @ExcelProperty(value = "备注")
    @TableField("BZ")
    private String BZ;

    @ExcelProperty(value = "查询单位")
    @TableField("CXDW")
    private String CXDW;


}
