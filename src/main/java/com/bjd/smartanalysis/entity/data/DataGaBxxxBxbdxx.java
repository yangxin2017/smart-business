package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_bxxx_bxbdxx")
@ExcelIgnoreUnannotated
public class DataGaBxxxBxbdxx {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    @ExcelProperty(value = "自然人对象名称")
    @TableField("ZRRDXMC")
    private String ZRRDXMC;

    @ExcelProperty(value = "自然人证件类型")
    @TableField("ZRRZJLX")
    private String ZRRZJLX;

    @ExcelProperty(value = "自然人证件号码")
    @TableField("ZRRZJHM")
    private String ZRRZJHM;
    //	机构名称
    @ExcelProperty(value = "机构名称")
    @TableField("JGMC")
    private String JGMC;
    //	营业执照号码
    @ExcelProperty(value = "营业执照号码")
    @TableField("YYZZHM")
    private String YYZZHM;
    //	组织机构代码
    @ExcelProperty(value = "组织机构代码")
    @TableField("ZZJGDM")
    private String ZZJGDM;
    //	统一社会信用代码
    @ExcelProperty(value = "统一社会信用代码")
    @TableField("TYSHXYDM")
    private String TYSHXYDM;
    //	税务登记证号
    @ExcelProperty(value = "税务登记证号")
    @TableField("SWDJZH")
    private String SWDJZH;
    //	保险产品名称
    @ExcelProperty(value = "保险产品名称")
    @TableField("BXCPMC")
    private String BXCPMC;
    //	保单号
    @ExcelProperty(value = "保单号")
    @TableField("BDH")
    private String BDH;
    //	保险公司名称
    @ExcelProperty(value = "保险公司名称")
    @TableField("BXGSMC")
    private String BXGSMC;
    //	累计缴纳保费
    @ExcelProperty(value = "累计缴纳保费")
    @TableField("LJJNBF")
    private String LJJNBF;
    //	币种
    @ExcelProperty(value = "币种")
    @TableField("BIZ")
    private String BIZ;
    //	平台名称
    @ExcelProperty(value = "平台名称")
    @TableField("PTMC")
    private String PTMC;
    //	险种名称
    @ExcelProperty(value = "险种名称")
    @TableField("XZMC")
    private String XZMC;
    //	保单团个性质
    @ExcelProperty(value = "保单团个性质")
    @TableField("BDTGXZ")
    private String BDTGXZ;
    //	购买日期
    @ExcelProperty(value = "购买日期")
    @TableField("GMRQ")
    private String GMRQ;
    //	保单生效日期
    @ExcelProperty(value = "保单生效日期")
    @TableField("BDSXRQ")
    private String BDSXRQ;
    //	保单终止日期
    @ExcelProperty(value = "保单终止日期")
    @TableField("BDZZRQ")
    private String BDZZRQ;
    //	保险标的名称
    @ExcelProperty(value = "保险标的名称")
    @TableField("BXBDMC")
    private String BXBDMC;
    //	保险账户价值
    @ExcelProperty(value = "保险账户价值")
    @TableField("BXZHJZ")
    private String BXZHJZ;
    //	数据提取日期
    @ExcelProperty(value = "数据提取日期")
    @TableField("SJTQRQ")
    private String SJTQRQ;
    //	标的数量
    @ExcelProperty(value = "标的数量")
    @TableField("BDSL")
    private String BDSL;
    //	保单序号
    @ExcelProperty(value = "保单序号")
    @TableField("BDXH")
    private String BDXH;

}
