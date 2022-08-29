package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_qsgx")
@ExcelIgnoreUnannotated
public class DataGaQsgx {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    @ExcelProperty(value = "姓名1")
    @TableField("XM1")
    private String XM1;

    @ExcelProperty(value = "证件号码1")
    @TableField("SFZH1")
    private String SFZH1;

    @ExcelProperty(value = "姓名2")
    @TableField("XM2")
    private String XM2;

    @ExcelProperty(value = "证件号码2")
    @TableField("SFZH2")
    private String SFZH2;

    @ExcelProperty(value = "关系")
    @TableField("GX")
    private String GX;
}
