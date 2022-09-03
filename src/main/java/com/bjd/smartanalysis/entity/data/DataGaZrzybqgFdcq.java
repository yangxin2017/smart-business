package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_zrzyqg_fdcq")
@ExcelIgnoreUnannotated
public class DataGaZrzybqgFdcq {
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
    // 房地坐落
    @ExcelProperty(value = "房地坐落")
    @TableField("FDZL")
    private String FDZL;
    // 建筑面积(平方米)
    @ExcelProperty(value = "建筑面积(平方米)")
    @TableField("JZMJPFM")
    private String JZMJPFM;
    // 规划用途
    @ExcelProperty(value = "规划用途")
    @TableField("GHYT")
    private String GHYT;
    // 房屋性质
    @ExcelProperty(value = "房屋性质")
    @TableField("FWXZ")
    private String FWXZ;
    // 竣工时间
    @ExcelProperty(value = "竣工时间")
    @TableField("JGSJ")
    private String JGSJ;
    // 土地使用起始时间
    @ExcelProperty(value = "土地使用起始时间")
    @TableField("TDSYQSSJ")
    private String TDSYQSSJ;
    // 土地使用结束时间
    @ExcelProperty(value = "土地使用结束时间")
    @TableField("TDSYJSSJ")
    private String TDSYJSSJ;
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
