package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_zrzybqg_dyq")
@ExcelIgnoreUnannotated
public class DataGaZrzybqgDyq {
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
    // 抵押不动产类型
    @ExcelProperty(value = "抵押不动产类型")
    @TableField("DYBDCLX")
    private String DYBDCLX;
    // 坐落
    @ExcelProperty(value = "坐落")
    @TableField("ZL")
    private String ZL;
    // 抵押人
    @ExcelProperty(value = "抵押人")
    @TableField("DYR")
    private String DYR;
    // 抵押方式
    @ExcelProperty(value = "抵押方式")
    @TableField("DYFS")
    private String DYFS;
    // 被担保主债权数额
    @ExcelProperty(value = "被担保主债权数额")
    @TableField("BDBZZQSE")
    private String BDBZZQSE;
    // 债务履行起始时间
    @ExcelProperty(value = "债务履行起始时间")
    @TableField("ZWLXQSSJ")
    private String ZWLXQSSJ;
    // 债务履行结束时间
    @ExcelProperty(value = "债务履行结束时间")
    @TableField("ZWLXJSSJ")
    private String ZWLXJSSJ;
    // 不动产登记证明号
    @ExcelProperty(value = "不动产登记证明号")
    @TableField("BDCDJZMH")
    private String BDCDJZMH;
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

}
