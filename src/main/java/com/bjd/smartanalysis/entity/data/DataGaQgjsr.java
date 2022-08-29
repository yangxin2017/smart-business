package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_qgjsr")
@ExcelIgnoreUnannotated
public class DataGaQgjsr {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    @ExcelProperty(value = "姓名")
    @TableField("XM")
    private String XM;

    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;

    @ExcelProperty(value = "性别")
    @TableField("XB")
    private String XB;

    @ExcelProperty(value = "出生日期")
    @TableField("CSRQ")
    private String CSRQ;

    @ExcelProperty(value = "发证机关")
    @TableField("FZJG")
    private String FZJG;

    @ExcelProperty(value = "初次领证日期")
    @TableField("CCLZRQ")
    private String CCLZRQ;

    @ExcelProperty(value = "准驾车型")
    @TableField("ZJCX")
    private String ZJCX;

    @ExcelProperty(value = "证件种类")
    @TableField("ZJZL")
    private String ZJZL;

    @ExcelProperty(value = "国籍/地区")
    @TableField("GJDQ")
    private String GJDQ;

    @ExcelProperty(value = "登记住所详址")
    @TableField("DJZSXZ")
    private String DJZSXZ;

    @ExcelProperty(value = "联系住所详址")
    @TableField("LXZSXZ")
    private String LXZSXZ;

    @ExcelProperty(value = "暂住证编号")
    @TableField("ZZZBH")
    private String ZZZBH;

    @ExcelProperty(value = "原准驾车型")
    @TableField("YZJCX")
    private String YZJCX;

    @ExcelProperty(value = "有效期止")
    @TableField("YXQZ")
    private String YXQZ;

    @ExcelProperty(value = "有效期起")
    @TableField("YXQQ")
    private String YXQQ;

    @ExcelProperty(value = "驾驶证期限")
    @TableField("JSZQX")
    private String JSZQX;

    @ExcelProperty(value = "驾驶证状态")
    @TableField("JSZZT")
    private String JSZZT;

    @ExcelProperty(value = "驾驶证超分日期")
    @TableField("JSZCFRQ")
    private String JSZCFRQ;

    @ExcelProperty(value = "累积记分")
    @TableField("LJJF")
    private String LJJF;

    @ExcelProperty(value = "更新时间")
    @TableField("GXSJ")
    private String GXSJ;


}
