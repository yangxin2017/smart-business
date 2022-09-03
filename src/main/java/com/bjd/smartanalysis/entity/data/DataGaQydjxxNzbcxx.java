package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_qydjxx_nzbcxx")
@ExcelIgnoreUnannotated
public class DataGaQydjxxNzbcxx {
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
    // 主体身份代码
    @ExcelProperty(value = "主体身份代码")
    @TableField("ZTSFDM")
    private String ZTSFDM;
    // 邮政编码
    @ExcelProperty(value = "邮政编码")
    @TableField("YZBM")
    private String YZBM;
    // 联系电话
    @ExcelProperty(value = "联系电话")
    @TableField("LXDH")
    private String LXDH;
    // 电子邮箱
    @ExcelProperty(value = "电子邮箱")
    @TableField("DZYX")
    private String DZYX;
    // 属地监管工商所
    @ExcelProperty(value = "属地监管工商所")
    @TableField("SDJGGSS")
    private String SDJGGSS;
    // 生产经营地所在行政区划
    @ExcelProperty(value = "生产经营地所在行政区划")
    @TableField("SCJYDSZXZQH")
    private String SCJYDSZXZQH;
    // 生产经营地
    @ExcelProperty(value = "生产经营地")
    @TableField("SCJYD")
    private String SCJYD;
    // 核算方式
    @ExcelProperty(value = "核算方式")
    @TableField("HSFS")
    private String HSFS;
    // 住所产权
    @ExcelProperty(value = "住所产权")
    @TableField("ZSCQ")
    private String ZSCQ;
    // 设立方式
    @ExcelProperty(value = "设立方式")
    @TableField("SLFS")
    private String SLFS;
    // 主管部门
    @ExcelProperty(value = "主管部门")
    @TableField("ZGBM")
    private String ZGBM;
    // 隶属关系
    @ExcelProperty(value = "隶属关系")
    @TableField("LSGX")
    private String LSGX;
    // 经营方式
    @ExcelProperty(value = "经营方式")
    @TableField("JYFS")
    private String JYFS;
    // 合伙人数
    @ExcelProperty(value = "合伙人数")
    @TableField("HHRS")
    private String HHRS;
    // 有限合伙人数
    @ExcelProperty(value = "有限合伙人数")
    @TableField("YXHHRS")
    private String YXHHRS;
    // 合伙方式
    @ExcelProperty(value = "合伙方式")
    @TableField("HHFS")
    private String HHFS;
    // 执行人数
    @ExcelProperty(value = "执行人数")
    @TableField("ZXRS")
    private String ZXRS;

}
