package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_qydjxx_zxxx")
@ExcelIgnoreUnannotated
public class DataGaQydjxxZxxx {
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
    // 注销日期
    @ExcelProperty(value = "注销日期")
    @TableField("ZXRQ")
    private String ZXRQ;
    // 注销原因
    @ExcelProperty(value = "注销原因")
    @TableField("ZXYY")
    private String ZXYY;
    // 对外投资清理完毕标志
    @ExcelProperty(value = "对外投资清理完毕标志")
    @TableField("DWTZQLWBBZ")
    private String DWTZQLWBBZ;
    // 分公司注销登记情况
    @ExcelProperty(value = "分公司注销登记情况")
    @TableField("FGSZXDJQK")
    private String FGSZXDJQK;
    // 债权债务清理完结情况
    @ExcelProperty(value = "债权债务清理完结情况")
    @TableField("ZQZWQLWJQK")
    private String ZQZWQLWJQK;
    // 清算组成员备案确认文书编号
    @ExcelProperty(value = "清算组成员备案确认文书编号")
    @TableField("QSZCYBAQRWSBH")
    private String QSZCYBAQRWSBH;
    // 公告报纸名称
    @ExcelProperty(value = "公告报纸名称")
    @TableField("GGBZMC")
    private String GGBZMC;
    // 公告日期
    @ExcelProperty(value = "公告日期")
    @TableField("GGRQ")
    private String GGRQ;
    // 批准机关
    @ExcelProperty(value = "批准机关")
    @TableField("PZJG")
    private String PZJG;
    // 批准文号
    @ExcelProperty(value = "批准文号")
    @TableField("PZWH")
    private String PZWH;
    // 批准日期
    @ExcelProperty(value = "批准日期")
    @TableField("PZRQ")
    private String PZRQ;
    // 清稅情况
    @ExcelProperty(value = "清稅情况")
    @TableField("QSQK")
    private String QSQK;
    // 批准证书缴销情况
    @ExcelProperty(value = "批准证书缴销情况")
    @TableField("PZZSJXQK")
    private String PZZSJXQK;
    // 海关手续清缴情况
    @ExcelProperty(value = "海关手续清缴情况")
    @TableField("HGSXQJQK")
    private String HGSXQJQK;
    // 清理债权债务单位
    @ExcelProperty(value = "清理债权债务单位")
    @TableField("QLZQZWDW")
    private String QLZQZWDW;

}
