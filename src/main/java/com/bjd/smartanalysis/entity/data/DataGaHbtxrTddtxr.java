package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_hbtxr_tddtxr")
@ExcelIgnoreUnannotated
public class DataGaHbtxrTddtxr {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    // 同行订单号（PNR）
    @ExcelProperty(value = "同行订单号（PNR）")
    @TableField("TXDDHPNR")
    private String TXDDHPNR;
    // 同行人中文名
    @ExcelProperty(value = "同行人中文名")
    @TableField("TXRZWM")
    private String TXRZWM;
    // 同行人姓（英文全拼）
    @ExcelProperty(value = "同行人姓（英文全拼）")
    @TableField("TXRXYWQP")
    private String TXRXYWQP;
    // 同行人名（英文全拼）
    @ExcelProperty(value = "同行人名（英文全拼）")
    @TableField("TXRMYWQP")
    private String TXRMYWQP;
    // 同行人证件类型
    @ExcelProperty(value = "同行人证件类型")
    @TableField("TXRZJLX")
    private String TXRZJLX;
    // 同行人证件号码
    @ExcelProperty(value = "同行人证件号码")
    @TableField("TXRZJHM")
    private String TXRZJHM;
    // 同行航班号
    @ExcelProperty(value = "同行航班号")
    @TableField("TXHBH")
    private String TXHBH;
    // 预计起飞日期
    @ExcelProperty(value = "预计起飞日期")
    @TableField("YJQFRQ")
    private String YJQFRQ;
    // 预计起飞时间
    @ExcelProperty(value = "预计起飞时间")
    @TableField("YJQFSJ")
    private String YJQFSJ;
    // 起飞机场
    @ExcelProperty(value = "起飞机场")
    @TableField("QFJC")
    private String QFJC;
    // 到达机场
    @ExcelProperty(value = "到达机场")
    @TableField("DDJC")
    private String DDJC;
    // 预计到达日期
    @ExcelProperty(value = "预计到达日期")
    @TableField("YJDDRQ")
    private String YJDDRQ;
    // 预计到达时间
    @ExcelProperty(value = "预计到达时间")
    @TableField("YJDDSJ")
    private String YJDDSJ;
    // 同行人座位号
    @ExcelProperty(value = "同行人座位号")
    @TableField("TXRZWH")
    private String TXRZWH;
    // 同行人行李总数
    @ExcelProperty(value = "同行人行李总数")
    @TableField("TXRXLZS")
    private String TXRXLZS;
    // 同行人行李总重（kg）
    @ExcelProperty(value = "同行人行李总重（kg）")
    @TableField("TXRXLZZKG")
    private String TXRXLZZKG;

}
