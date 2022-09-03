package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_gs_swjnxx")
@ExcelIgnoreUnannotated
public class DataGaGsSwjnxx {
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
    // 证件号码
    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;
    // 税款所属期始
    @ExcelProperty(value = "税款所属期始")
    @TableField("SKSSQS")
    private String SKSSQS;
    // 税款所属期止
    @ExcelProperty(value = "税款所属期止")
    @TableField("SKSSQZ")
    private String SKSSQZ;
    // 征收品目代码
    @ExcelProperty(value = "征收品目代码")
    @TableField("ZSPMDM")
    private String ZSPMDM;
    // 征收品目名称
    @ExcelProperty(value = "征收品目名称")
    @TableField("ZSPMMC")
    private String ZSPMMC;
    // 税种名称
    @ExcelProperty(value = "税种名称")
    @TableField("SZMC")
    private String SZMC;
    // 应纳税额
    @ExcelProperty(value = "应纳税额")
    @TableField("YNSE")
    private String YNSE;
}
