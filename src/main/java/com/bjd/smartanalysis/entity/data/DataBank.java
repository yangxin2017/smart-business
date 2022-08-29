package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_bank")
@ExcelIgnoreUnannotated
public class DataBank {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

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

    @ExcelProperty(value = "查询对象名称")
    @TableField("CXDXMC")
    private String CXDXMC;

    @ExcelProperty(value = "查询卡号")
    @TableField("CXKH")
    private String CXKH;

    @ExcelProperty(value = "查询反馈结果原因")
    @TableField("CXFKJGYY")
    private String CXFKJGYY;

    @ExcelProperty(value = "本方账号")
    @TableField("BFZH")
    private String BFZH;

    @ExcelProperty(value = "本方卡号")
    @TableField("BFKH")
    private String BFKH;

    @ExcelProperty(value = "交易类型")
    @TableField("JYLX")
    private String JYLX;

    @ExcelProperty(value = "借贷标志")
    @TableField("JDBZ")
    private String JDBZ;

    @ExcelProperty(value = "币种")
    @TableField("BZ")
    private String BZ;

    @ExcelProperty(value = "交易金额")
    @TableField("JYJE")
    private String JYJE;

    @ExcelProperty(value = "交易余额")
    @TableField("JYYE")
    private String JYYE;

    @ExcelProperty(value = "交易时间")
    @TableField("JYSJ")
    private String JYSJ;

    @ExcelProperty(value = "交易流水号")
    @TableField("JYLSH")
    private String JYLSH;

    @ExcelProperty(value = "交易对方名称")
    @TableField("JYDFMC")
    private String JYDFMC;

    @ExcelProperty(value = "交易对方账号")
    @TableField("JYDFZH")
    private String JYDFZH;

    @ExcelProperty(value = "交易对方卡号")
    @TableField("JYDFKH")
    private String JYDFKH;

    @ExcelProperty(value = "交易对方证件号码")
    @TableField("JYDFZJHM")
    private String JYDFZJHM;

    @ExcelProperty(value = "交易对手余额")
    @TableField("JYDSYE")
    private String JYDSYE;

    @ExcelProperty(value = "交易对方账号开户行")
    @TableField("JYDFZHKHH")
    private String JYDFZHKHH;

    @ExcelProperty(value = "交易摘要")
    @TableField("JYZY")
    private String JYZY;

    @ExcelProperty(value = "交易网点名称")
    @TableField("JYWDMC")
    private String JYWDMC;

    @ExcelProperty(value = "交易网点代码")
    @TableField("JYWDDM")
    private String JYWDDM;

    @ExcelProperty(value = "日志号")
    @TableField("RZH")
    private String RZH;

    @ExcelProperty(value = "传票号")
    @TableField("CPH")
    private String CPH;

    @ExcelProperty(value = "凭证种类")
    @TableField("PZZL")
    private String PZZL;

    @ExcelProperty(value = "凭证号")
    @TableField("PZH")
    private String PZH;

    @ExcelProperty(value = "现金标志")
    @TableField("XJBZ")
    private String XJBZ;

    @ExcelProperty(value = "终端号")
    @TableField("ZDH")
    private String ZDH;

    @ExcelProperty(value = "交易是否成功")
    @TableField("JYSFCG")
    private String JYSFCG;

    @ExcelProperty(value = "交易发生地")
    @TableField("JYFSD")
    private String JYFSD;

    @ExcelProperty(value = "商户名称")
    @TableField("SHMC")
    private String SHMC;

    @ExcelProperty(value = "商户号")
    @TableField("SHH")
    private String SHH;

    @ExcelProperty(value = "IP地址")
    @TableField("IPDZ")
    private String IPDZ;

    @ExcelProperty(value = "MAC地址")
    @TableField("MACDZ")
    private String MACDZ;

    @ExcelProperty(value = "交易柜员号")
    @TableField("JYGYH")
    private String JYGYH;

    @ExcelProperty(value = "备注")
    @TableField("REMARK")
    private String REMARK;
}
