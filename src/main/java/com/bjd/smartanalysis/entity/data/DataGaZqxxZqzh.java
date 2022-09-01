package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_auto_zqxx_zqzh")
@ExcelIgnoreUnannotated
public class DataGaZqxxZqzh {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    // 持有人名称
    @ExcelProperty(value = "持有人名称")
    @TableField("CYRMC")
    private String CYRMC;
    // 证件类型
    @ExcelProperty(value = "证件类型")
    @TableField("ZJLX")
    private String ZJLX;
    // 证件号码
    @ExcelProperty(value = "证件号码")
    @TableField("ZJHM")
    private String ZJHM;
    // 市场类型
    @ExcelProperty(value = "市场类型")
    @TableField("SCLX")
    private String SCLX;
    // 证券账户
    @ExcelProperty(value = "证券账户")
    @TableField("ZQZH")
    private String ZQZH;
    // 证券账户状态
    @ExcelProperty(value = "证券账户状态")
    @TableField("ZQZHZT")
    private String ZQZHZT;
    // 开户日期
    @ExcelProperty(value = "开户日期")
    @TableField("KHRQ")
    private String KHRQ;
    // 联系地址
    @ExcelProperty(value = "联系地址")
    @TableField("LXDZ")
    private String LXDZ;
    // 联系电话
    @ExcelProperty(value = "联系电话")
    @TableField("LXDH")
    private String LXDH;
    // 开户代理机构名称
    @ExcelProperty(value = "开户代理机构名称")
    @TableField("KHDLJGMC")
    private String KHDLJGMC;

}
