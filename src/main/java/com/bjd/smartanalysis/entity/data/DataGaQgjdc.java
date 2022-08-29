package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_qgjdc")
@ExcelIgnoreUnannotated
public class DataGaQgjdc {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    @ExcelProperty(value = "号牌种类")
    @TableField("HPZL")
    private String HPZL;

    @ExcelProperty(value = "号牌号码")
    @TableField("HPHM")
    private String HPHM;

    @ExcelProperty(value = "中文品牌")
    @TableField("ZWPP")
    private String ZWPP;

    @ExcelProperty(value = "车辆识别代号")
    @TableField("CLSBDH")
    private String CLSBDH;

    @ExcelProperty(value = "车辆类型")
    @TableField("CLLX")
    private String CLLX;

    @ExcelProperty(value = "车身颜色")
    @TableField("CSYS")
    private String CSYS;

    @ExcelProperty(value = "发证机关")
    @TableField("FZJG")
    private String FZJG;

    @ExcelProperty(value = "初次登记日期")
    @TableField("CCDJRQ")
    private String CCDJRQ;

    @ExcelProperty(value = "机动车状态")
    @TableField("JDCZT")
    private String JDCZT;

    @ExcelProperty(value = "机动车所有人")
    @TableField("JDCSYR")
    private String JDCSYR;

    @ExcelProperty(value = "证件类别")
    @TableField("ZJLB")
    private String ZJLB;

    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;

    @ExcelProperty(value = "住所地址")
    @TableField("ZSDZ")
    private String ZSDZ;

    @ExcelProperty(value = "暂住证编号")
    @TableField("ZZZBH")
    private String ZZZBH;

    @ExcelProperty(value = "暂住地址")
    @TableField("ZZDZ")
    private String ZZDZ;

    @ExcelProperty(value = "是否抵押/质押")
    @TableField("SFDYZY")
    private String SFDYZY;

    @ExcelProperty(value = "机动车档案编号")
    @TableField("JDCDABH")
    private String JDCDABH;

    @ExcelProperty(value = "机动车发动机号")
    @TableField("JDCFDJH")
    private String JDCFDJH;

    @ExcelProperty(value = "机动车发动机型号")
    @TableField("JDCFDJXH")
    private String JDCFDJXH;

    @ExcelProperty(value = "机动车能源种类")
    @TableField("JDCNYZL")
    private String JDCNYZL;

    @ExcelProperty(value = "机动车发动机排量")
    @TableField("JDCFDJPL")
    private String JDCFDJPL;

    @ExcelProperty(value = "机动车发动机功率")
    @TableField("JDCFDJGL")
    private String JDCFDJGL;

    @ExcelProperty(value = "机动车总质量")
    @TableField("JDCZZL")
    private String JDCZZL;

    @ExcelProperty(value = "机动车核定载质量")
    @TableField("JDCHDZZL")
    private String JDCHDZZL;

    @ExcelProperty(value = "机动车核定载客人数")
    @TableField("JDCHDZKRS")
    private String JDCHDZKRS;

    @ExcelProperty(value = "机动车准牵引总质量")
    @TableField("JDCZQYZZL")
    private String JDCZQYZZL;

    @ExcelProperty(value = "出厂日期")
    @TableField("CCRQ")
    private String CCRQ;

    @ExcelProperty(value = "机动车驾驶证号")
    @TableField("JDCJSZH")
    private String JDCJSZH;

    @ExcelProperty(value = "更新时间")
    @TableField("GXSJ")
    private String GXSJ;
}
