package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_yxjrjgjrlc_jrlczhxx")
@ExcelIgnoreUnannotated
public class DataGaYxjrjgjrlcJrlczhxx {
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
    // 查询账户
    @ExcelProperty(value = "查询账户")
    @TableField("CXZH")
    private String CXZH;
    // 是否有财产
    @ExcelProperty(value = "是否有财产")
    @TableField("SFYCC")
    private String SFYCC;
    // 查询反馈结果原因
    @ExcelProperty(value = "查询反馈结果原因")
    @TableField("CXFKJGYY")
    private String CXFKJGYY;
    // 查询卡号
    @ExcelProperty(value = "查询卡号")
    @TableField("CXKH")
    private String CXKH;
    // 理财卡号
    @ExcelProperty(value = "理财卡号")
    @TableField("LCKH")
    private String LCKH;
    // 理财账号
    @ExcelProperty(value = "理财账号")
    @TableField("LCZH")
    private String LCZH;
    // 网银账户名称
    @ExcelProperty(value = "网银账户名称")
    @TableField("WYZHMC")
    private String WYZHMC;
    // 最后登录IP
    @ExcelProperty(value = "最后登录IP")
    @TableField("ZHDLIP")
    private String ZHDLIP;
    // 最后登录时间
    @ExcelProperty(value = "最后登录时间")
    @TableField("ZHDLSJ")
    private String ZHDLSJ;
    // 账户类别
    @ExcelProperty(value = "账户类别")
    @TableField("ZHLB")
    private String ZHLB;
    // 账户状态
    @ExcelProperty(value = "账户状态")
    @TableField("ZHZT")
    private String ZHZT;
    // 开户网点
    @ExcelProperty(value = "开户网点")
    @TableField("KHWD")
    private String KHWD;
    // 开户网点代码
    @ExcelProperty(value = "开户网点代码")
    @TableField("KHWDDM")
    private String KHWDDM;
    // 开户日期
    @ExcelProperty(value = "开户日期")
    @TableField("KHRQ")
    private String KHRQ;
    // 销户日期
    @ExcelProperty(value = "销户日期")
    @TableField("XHRQ")
    private String XHRQ;
    // 销户网点
    @ExcelProperty(value = "销户网点")
    @TableField("XHWD")
    private String XHWD;
    // 币种
    @ExcelProperty(value = "币种")
    @TableField("BIZ")
    private String BIZ;
    // 钞汇标志
    @ExcelProperty(value = "钞汇标志")
    @TableField("CHBZ")
    private String CHBZ;
    // 账户余额
    @ExcelProperty(value = "账户余额")
    @TableField("ZHYE")
    private String ZHYE;
    // 可用余额
    @ExcelProperty(value = "可用余额")
    @TableField("KYYE")
    private String KYYE;
    // 最后交易时间
    @ExcelProperty(value = "最后交易时间")
    @TableField("ZHJYSJ")
    private String ZHJYSJ;
    // 备注
    @ExcelProperty(value = "备注")
    @TableField("BZ")
    private String BZ;

}
