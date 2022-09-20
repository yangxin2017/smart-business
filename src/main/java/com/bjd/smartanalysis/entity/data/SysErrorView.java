package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_error_view")
@ExcelIgnoreUnannotated
public class SysErrorView {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;

    @TableField("group_id")
    private Integer groupId;

    @TableField("user_id")
    private Integer userId;

    @TableField("createTime")
    private String createTime;

    @TableField("fileName")
    private String fileName;

    @TableField("eid")
    private Integer eid;

    @TableField("errorContext")
    private String errorContext;
}
