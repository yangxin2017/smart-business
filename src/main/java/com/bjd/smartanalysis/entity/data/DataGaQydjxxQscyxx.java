package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_qydjxx_qscyxx")
@ExcelIgnoreUnannotated
public class DataGaQydjxxQscyxx {
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
    // 清算成员编号
    @ExcelProperty(value = "清算成员编号")
    @TableField("QSCYBH")
    private String QSCYBH;
    // 清算信息编号
    @ExcelProperty(value = "清算信息编号")
    @TableField("QSXXBH")
    private String QSXXBH;
    // 主体身份代码
    @ExcelProperty(value = "主体身份代码")
    @TableField("ZTSFDM")
    private String ZTSFDM;
    // 清算组成员
    @ExcelProperty(value = "清算组成员")
    @TableField("QSZCY")
    private String QSZCY;
    // 清算组成员证件类型
    @ExcelProperty(value = "清算组成员证件类型")
    @TableField("QSZCYZJLX")
    private String QSZCYZJLX;
    // 清算组成员证件号码
    @ExcelProperty(value = "清算组成员证件号码")
    @TableField("QSZCYZJHM")
    private String QSZCYZJHM;
    // 地址
    @ExcelProperty(value = "地址")
    @TableField("DZ")
    private String DZ;
    // 联系电话
    @ExcelProperty(value = "联系电话")
    @TableField("LXDH")
    private String LXDH;
    // 清算负责人标志
    @ExcelProperty(value = "清算负责人标志")
    @TableField("QSFZRBZ")
    private String QSFZRBZ;

}
