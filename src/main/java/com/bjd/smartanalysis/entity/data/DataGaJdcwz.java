package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_jdcwz")
@ExcelIgnoreUnannotated
public class DataGaJdcwz {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    @ExcelProperty(value = "当事人")
    @TableField("DSR")
    private String DSR;

    @ExcelProperty(value = "驾驶证号")
    @TableField("JSZH")
    private String JSZH;

    @ExcelProperty(value = "号牌号码")
    @TableField("HPHM")
    private String HPHM;

    @ExcelProperty(value = "违法时间")
    @TableField("WFSJ")
    private String WFSJ;

    @ExcelProperty(value = "违法地址")
    @TableField("WFDZ")
    private String WFDZ;

    @ExcelProperty(value = "违法行为")
    @TableField("WFXW")
    private String WFXW;

    @ExcelProperty(value = "处理时间")
    @TableField("CLSJ")
    private String CLSJ;

    @ExcelProperty(value = "处理机关")
    @TableField("CLJG")
    private String CLJG;

    @ExcelProperty(value = "号牌种类")
    @TableField("HPZL")
    private String HPZL;

    @ExcelProperty(value = "更新时间")
    @TableField("GXSJ")
    private String GXSJ;
}
