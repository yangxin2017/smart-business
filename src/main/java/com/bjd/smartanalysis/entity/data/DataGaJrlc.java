package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_jrlc")
@ExcelIgnoreUnannotated
public class DataGaJrlc {
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

    @ExcelProperty(value = "查询账户")
    @TableField("CXZH")
    private String CXZH;

    @ExcelProperty(value = "是否有财产")
    @TableField("SFYCC")
    private String SFYCC;

    @ExcelProperty(value = "查询反馈结果原因")
    @TableField("CXFKJGYY")
    private String CXFKJGYY;

    @ExcelProperty(value = "查询卡号")
    @TableField("CXKH")
    private String CXKH;

    @ExcelProperty(value = "理财卡号")
    @TableField("LCKH")
    private String LCKH;

    @ExcelProperty(value = "理财账号")
    @TableField("LCZH")
    private String LCZH;

    @ExcelProperty(value = "网银账户名称")
    @TableField("WYZHMC")
    private String WYZHMC;

    @ExcelProperty(value = "最后登录IP")
    @TableField("ZHDLIP")
    private String ZHDLIP;

    @ExcelProperty(value = "最后登录时间")
    @TableField("ZHDLSJ")
    private String ZHDLSJ;

    @ExcelProperty(value = "账户类别")
    @TableField("ZHLB")
    private String ZHLB;

    @ExcelProperty(value = "账户状态")
    @TableField("ZHZT")
    private String ZHZT;

    @ExcelProperty(value = "开户网点")
    @TableField("KHWD")
    private String KHWD;

    @ExcelProperty(value = "开户网点代码")
    @TableField("KHWDDM")
    private String KHWDDM;

    @ExcelProperty(value = "开户日期")
    @TableField("KHRQ")
    private String KHRQ;

    @ExcelProperty(value = "销户日期")
    @TableField("XHRQ")
    private String XHRQ;

    @ExcelProperty(value = "销户网点")
    @TableField("XHWD")
    private String XHWD;

    @ExcelProperty(value = "币种")
    @TableField("BIZ")
    private String BIZ;

    @ExcelProperty(value = "钞汇标志")
    @TableField("CHBZ")
    private String CHBZ;

    @ExcelProperty(value = "账户余额")
    @TableField("ZHYE")
    private String ZHYE;

    @ExcelProperty(value = "可用余额")
    @TableField("KYYE")
    private String KYYE;

    @ExcelProperty(value = "最后交易时间")
    @TableField("ZHJYSJ")
    private String ZHJYSJ;

    @ExcelProperty(value = "备注")
    @TableField("BZ")
    private String BZ;



}
