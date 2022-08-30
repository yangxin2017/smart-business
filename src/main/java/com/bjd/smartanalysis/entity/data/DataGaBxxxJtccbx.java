package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_bxxx_bxryxx")
@ExcelIgnoreUnannotated
public class DataGaBxxxJtccbx {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    // 标的地址
    @ExcelProperty(value = "标的地址")
    @TableField("BDDZ")
    private String BDDZ;
    // 房屋门牌号
    @ExcelProperty(value = "房屋门牌号")
    @TableField("FWMPH")
    private String FWMPH;

}
