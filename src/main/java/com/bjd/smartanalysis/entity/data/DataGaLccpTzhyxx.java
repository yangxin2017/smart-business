package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_lccp_tzhyxx")
@ExcelIgnoreUnannotated
public class DataGaLccpTzhyxx {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    // 产品登记编码
    @ExcelProperty(value = "产品登记编码")
    @TableField("CPDJBM")
    private String CPDJBM;
    // 投资资产名称
    @ExcelProperty(value = "投资资产名称")
    @TableField("TZZCMC")
    private String TZZCMC;
    // 投资资产类别
    @ExcelProperty(value = "投资资产类别")
    @TableField("TZZCLB")
    private String TZZCLB;
    // 投资资产状态
    @ExcelProperty(value = "投资资产状态")
    @TableField("TZZCZT")
    private String TZZCZT;
    // 投资行业
    @ExcelProperty(value = "投资行业")
    @TableField("TZHY")
    private String TZHY;
    // 投资资产净值比重（%）
    @ExcelProperty(value = "投资资产净值比重（%）")
    @TableField("TZZCJZBZ")
    private String TZZCJZBZ;

}
