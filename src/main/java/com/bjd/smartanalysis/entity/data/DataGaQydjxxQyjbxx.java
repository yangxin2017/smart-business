package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_qydjxx_qyjbxx")
@ExcelIgnoreUnannotated
public class DataGaQydjxxQyjbxx {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    // 反馈单位	审批表	名称	证件类型	证件号码	主体身份代码	统一社会信用代码	企业（机构）名称	法定代表人	注册号	市场主体类型	行业门类	行业代码	成立日期	登记机关	业务范围类型	经营范围	经营(驻在)期限自	经营(驻在)期限至	登记状态	住所所在行政区划	住所	注册资本(金)（万元）	注册资本(金)币种	注册资本(金)折万美元	实收资本	实收资本折万美元	国别(地区)
    @ExcelProperty(value = "反馈单位")
    @TableField("FKDW")
    private String FKDW;

    @ExcelProperty(value = "审批表")
    @TableField("SPB")
    private String SPB;

    @ExcelProperty(value = "名称")
    @TableField("MC")
    private String MC;

    @ExcelProperty(value = "证件类型")
    @TableField("ZJLX")
    private String ZJLX;

    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;

    @ExcelProperty(value = "主体身份代码")
    @TableField("ZTSFDM")
    private String ZTSFDM;

    @ExcelProperty(value = "统一社会信用代码")
    @TableField("TYSHXYDM")
    private String TYSHXYDM;

    @ExcelProperty(value = "企业（机构）名称")
    @TableField("QYJGMC")
    private String QYJGMC;

    @ExcelProperty(value = "法定代表人")
    @TableField("FDDBR")
    private String FDDBR;

    @ExcelProperty(value = "注册号")
    @TableField("ZCH")
    private String ZCH;

    @ExcelProperty(value = "市场主体类型")
    @TableField("SCZTLX")
    private String SCZTLX;

    @ExcelProperty(value = "行业门类")
    @TableField("HYML")
    private String HYML;

    @ExcelProperty(value = "行业代码")
    @TableField("HYDM")
    private String HYDM;

    @ExcelProperty(value = "成立日期")
    @TableField("CLRQ")
    private String CLRQ;

    @ExcelProperty(value = "登记机关")
    @TableField("DJJG")
    private String DJJG;

    @ExcelProperty(value = "业务范围类型")
    @TableField("YWFWLX")
    private String YWFWLX;

    @ExcelProperty(value = "经营范围")
    @TableField("JYFW")
    private String JYFW;

    @ExcelProperty(value = "经营(驻在)期限自")
    @TableField("JYQXS")
    private String JYQXS;

    @ExcelProperty(value = "经营(驻在)期限至")
    @TableField("JYQXE")
    private String JYQXE;

    @ExcelProperty(value = "登记状态")
    @TableField("DJZT")
    private String DJZT;

    @ExcelProperty(value = "住所所在行政区划")
    @TableField("ZSSZXZQH")
    private String ZSSZXZQH;

    @ExcelProperty(value = "住所")
    @TableField("ZS")
    private String ZS;

    @ExcelProperty(value = "注册资本(金)（万元）")
    @TableField("ZCZBJWY")
    private String ZCZBJWY;

    @ExcelProperty(value = "注册资本(金)币种")
    @TableField("ZCZBJBZ")
    private String ZCZBJBZ;

    @ExcelProperty(value = "注册资本(金)折万美元")
    @TableField("ZCZBJZWMY")
    private String ZCZBJZWMY;

    @ExcelProperty(value = "实收资本")
    @TableField("SSZB")
    private String SSZB;

    @ExcelProperty(value = "实收资本折万美元")
    @TableField("SSZBZWMY")
    private String SSZBZWMY;

    @ExcelProperty(value = "国别地区")
    @TableField("GBDQ")
    private String GBDQ;

    // 从业人员/农专成员总数	是否城镇	统计企业类型	核准日期

    @ExcelProperty(value = "从业人员/农专成员总数")
    @TableField("CYRYNZCYZS")
    private String CYRYNZCYZS;

    @ExcelProperty(value = "是否城镇")
    @TableField("SFCZ")
    private String SFCZ;

    @ExcelProperty(value = "统计企业类型")
    @TableField("TJQYLX")
    private String TJQYLX;

    @ExcelProperty(value = "核准日期")
    @TableField("HZRQ")
    private String HZRQ;

}
