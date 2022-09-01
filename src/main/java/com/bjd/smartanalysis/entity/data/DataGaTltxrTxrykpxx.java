package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_tltxr_txrykpxx")
@ExcelIgnoreUnannotated
public class DataGaTltxrTxrykpxx {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    // 同行人序号
    @ExcelProperty(value = "同行人序号")
    @TableField("TXRXH")
    private String TXRXH;
    // 同行人姓名
    @ExcelProperty(value = "同行人姓名")
    @TableField("TXRXM")
    private String TXRXM;
    // 证件号码
    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;
    // 同行车次
    @ExcelProperty(value = "同行车次")
    @TableField("TXCC")
    private String TXCC;
    // 购票票号
    @ExcelProperty(value = "购票票号")
    @TableField("GPPH")
    private String GPPH;
    // 乘车时间
    @ExcelProperty(value = "乘车时间")
    @TableField("CCSJ")
    private String CCSJ;
    // 乘车起始站
    @ExcelProperty(value = "乘车起始站")
    @TableField("CCQSZ")
    private String CCQSZ;
    // 乘车终止站
    @ExcelProperty(value = "乘车终止站")
    @TableField("CCZZZ")
    private String CCZZZ;
    // 车厢号
    @ExcelProperty(value = "车厢号")
    @TableField("CXH")
    private String CXH;
    // 席别
    @ExcelProperty(value = "席别")
    @TableField("XB")
    private String XB;
    // 席位号
    @ExcelProperty(value = "席位号")
    @TableField("XWH")
    private String XWH;
    // 购票人
    @ExcelProperty(value = "购票人")
    @TableField("GPR")
    private String GPR;
    // 购票人证件号码
    @ExcelProperty(value = "购票人证件号码")
    @TableField("GPRZJHM")
    private String GPRZJHM;
    // 购票时间
    @ExcelProperty(value = "购票时间")
    @TableField("GPSJ")
    private String GPSJ;

}
