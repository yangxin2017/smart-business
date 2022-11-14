package com.bjd.smartanalysis.entity.graph;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("graph_node")
public class GraphNode {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    @TableField("node_type")
    private String nodeType;

    @TableField("node_level")
    private Integer nodeLevel;

    @TableField("node_color")
    private String nodeColor;

    @TableField("node_id")
    private Integer nodeId;

    @TableField("node_name")
    private String nodeName;

    @TableField("node_group")
    private String nodeGroup;
}
