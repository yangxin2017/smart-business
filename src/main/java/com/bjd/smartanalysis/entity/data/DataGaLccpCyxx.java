package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_lccp_cyxx")
@ExcelIgnoreUnannotated
public class DataGaLccpCyxx {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    // 产品登记编码
    @ExcelProperty(value = "产品登记编码")
    @TableField("CPDJBM")
    private String CPDJBM;
    // 持有日期
    @ExcelProperty(value = "持有日期")
    @TableField("CYRQ")
    private String CYRQ;
    // 币种
    @ExcelProperty(value = "币种")
    @TableField("BIZ")
    private String BIZ;
    // 持有份额
    @ExcelProperty(value = "持有份额")
    @TableField("CYFE")
    private String CYFE;
    // 持有金额
    @ExcelProperty(value = "持有金额")
    @TableField("CYJE")
    private String CYJE;
    // 折算人民币金额
    @ExcelProperty(value = "折算人民币金额")
    @TableField("ZSRMBJE")
    private String ZSRMBJE;
    // 理财收益
    @ExcelProperty(value = "理财收益")
    @TableField("LCSY")
    private String LCSY;
    // 理财收益率
    @ExcelProperty(value = "理财收益率")
    @TableField("LCSYL")
    private String LCSYL;

}
