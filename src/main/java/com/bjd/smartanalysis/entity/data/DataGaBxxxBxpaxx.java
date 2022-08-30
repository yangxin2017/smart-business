package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_bxxx_bxpaxx")
@ExcelIgnoreUnannotated
public class DataGaBxxxBxpaxx {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;


    // 保单序号
    @ExcelProperty(value = "保单序号")
    @TableField("BDXH")
    private String BDXH;
    // 赔案序号
    @ExcelProperty(value = "赔案序号")
    @TableField("PAXH")
    private String PAXH;
    // 赔案报案人姓名
    @ExcelProperty(value = "赔案报案人姓名")
    @TableField("PABARXM")
    private String PABARXM;
    // 赔案报案人联系电话
    @ExcelProperty(value = "赔案报案人联系电话")
    @TableField("PABARLXDH")
    private String PABARLXDH;
    // 赔案号
    @ExcelProperty(value = "赔案号")
    @TableField("PAH")
    private String PAH;
    // 出险时间
    @ExcelProperty(value = "出险时间")
    @TableField("CXSJ")
    private String CXSJ;
    // 报案时间
    @ExcelProperty(value = "报案时间")
    @TableField("BASJ")
    private String BASJ;
    // 出险原因
    @ExcelProperty(value = "出险原因")
    @TableField("CXYY")
    private String CXYY;
    // 赔款支付账号
    @ExcelProperty(value = "赔款支付账号")
    @TableField("PZZH")
    private String PZZH;
    // 赔付金额
    @ExcelProperty(value = "赔付金额")
    @TableField("PFK")
    private String PFK;
    // 赔付日期
    @ExcelProperty(value = "赔付日期")
    @TableField("PFRQ")
    private String PFRQ;


}
