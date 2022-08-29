package com.bjd.smartanalysis.entity.data;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("data_project")
public class DataProject {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("group_id")
    private Long groupId;

    @TableField("user_id")
    private Long userId;

    @TableField("name")
    private String name;

    @TableField("persons")
    private String persons;

    @TableField("ctime")
    private Date ctime;

    @TableField("utime")
    private Date utime;

    @TableField("fxtime")
    private Date fxtime;

}
