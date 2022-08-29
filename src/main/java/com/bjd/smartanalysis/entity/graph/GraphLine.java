package com.bjd.smartanalysis.entity.graph;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("graph_line")
public class GraphLine {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    @TableField("sid")
    private Integer sid;

    @TableField("eid")
    private Integer eid;

    @TableField("name")
    private String name;

    @TableField("relation_ids")
    private String relationIds;
}
