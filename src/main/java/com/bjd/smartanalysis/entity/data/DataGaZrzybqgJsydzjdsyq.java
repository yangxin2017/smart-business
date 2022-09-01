package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_zrzybqg_jsydzjdsyq")
@ExcelIgnoreUnannotated
public class DataGaZrzybqgJsydzjdsyq {
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
    // 不动产单元号
    @ExcelProperty(value = "不动产单元号")
    @TableField("BDCDYH")
    private String BDCDYH;
    // 坐落
    @ExcelProperty(value = "坐落")
    @TableField("ZL")
    private String ZL;
    // 用途
    @ExcelProperty(value = "用途")
    @TableField("YT")
    private String YT;
    // 使用权面积(平方米)
    @ExcelProperty(value = "使用权面积(平方米)")
    @TableField("SYQMJPFM")
    private String SYQMJPFM;
    // 权利性质
    @ExcelProperty(value = "权利性质")
    @TableField("QLXZ")
    private String QLXZ;
    // 使用权起始时间
    @ExcelProperty(value = "使用权起始时间")
    @TableField("SYQQSSJ")
    private String SYQQSSJ;
    // 使用权结束时间
    @ExcelProperty(value = "使用权结束时间")
    @TableField("SYQJSSJ")
    private String SYQJSSJ;
    // 不动产权证号
    @ExcelProperty(value = "不动产权证号")
    @TableField("BDCQZH")
    private String BDCQZH;
    // 登记机构
    @ExcelProperty(value = "登记机构")
    @TableField("DJJG")
    private String DJJG;
    // 权属状态
    @ExcelProperty(value = "权属状态")
    @TableField("QSZT")
    private String QSZT;
    // 登记时间
    @ExcelProperty(value = "登记时间")
    @TableField("DJSJ")
    private String DJSJ;
    // 共有情况
    @ExcelProperty(value = "共有情况")
    @TableField("GYQK")
    private String GYQK;
    // 交易金额（万元）
    @ExcelProperty(value = "交易金额（万元）")
    @TableField("JYJEWY")
    private String JYJEWY;
    // 共有人证件号码
    @ExcelProperty(value = "共有人证件号码")
    @TableField("GYRZJHM")
    private String GYRZJHM;
    // 共有人名称
    @ExcelProperty(value = "共有人名称")
    @TableField("GYRMC")
    private String GYRMC;
    // 共有人证件类型
    @ExcelProperty(value = "共有人证件类型")
    @TableField("GYRZJLX")
    private String GYRZJLX;

}
