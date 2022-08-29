package com.bjd.smartanalysis.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_user")
public class SysUser {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("tenand_id")
    private Long tenandId;

    @TableField("group_id")
    private Long groupId;

    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("nickname")
    private String nickname;

    @TableField("role_id")
    private Integer roleId;

    @TableField("salt")
    private String salt;

    @TableField("ctime")
    private Date ctime;
}
