package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_qydjxx_bgbaxx")
@ExcelIgnoreUnannotated
public class DataGaQydjxxBgbaxx {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    // 反馈单位
    @ExcelProperty(value = "反馈单位")
    @TableField("FKDW")
    private String FKDW;
    // 审批表
    @ExcelProperty(value = "审批表")
    @TableField("SPB")
    private String SPB;
    // 名称
    @ExcelProperty(value = "名称")
    @TableField("MC")
    private String MC;
    // 证件类型
    @ExcelProperty(value = "证件类型")
    @TableField("ZJLX")
    private String ZJLX;
    // 证件号码
    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;
    // 企业（机构）名称
    @ExcelProperty(value = "企业（机构）名称")
    @TableField("QYJGMC")
    private String QYJGMC;
    // 变更项ID
    @ExcelProperty(value = "变更项ID")
    @TableField("BGXID")
    private String BGXID;
    // 主体身份代码
    @ExcelProperty(value = "主体身份代码")
    @TableField("ZTSFDM")
    private String ZTSFDM;
    // 变更事项
    @ExcelProperty(value = "变更事项")
    @TableField("BGSX")
    private String BGSX;
    // 变更前内容
    @ExcelProperty(value = "变更前内容")
    @TableField("BGQNR")
    private String BGQNR;
    // 变更后内容
    @ExcelProperty(value = "变更后内容")
    @TableField("BGHNR")
    private String BGHNR;
    // 变更日期
    @ExcelProperty(value = "变更日期")
    @TableField("BGRQ")
    private String BGRQ;

}
