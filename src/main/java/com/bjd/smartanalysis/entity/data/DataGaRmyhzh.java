package com.bjd.smartanalysis.entity.data;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("data_ga_rmyhzh")
@ExcelIgnoreUnannotated
public class DataGaRmyhzh {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("project_id")
    private Integer projectId;
    @TableField("group_id")
    private Integer groupId;
    @TableField("user_id")
    private Integer userId;

    // 反馈单位	审批表	名称	证件类型	证件号码	查询账户	是否有财产	开户银行名称	帐号	账户性质	开户时间	销户时间	账户状态	银行机构代码	账户名称	证照号码	反馈人	反馈录入时间	备注

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

    @ExcelProperty(value = "开户银行名称")
    @TableField("KHYHMC")
    private String KHYHMC;

    @ExcelProperty(value = "帐号")
    @TableField("ZH")
    private String ZH;

    @ExcelProperty(value = "账户性质")
    @TableField("ZHXZ")
    private String ZHXZ;

    @ExcelProperty(value = "开户时间")
    @TableField("KHSJ")
    private String KHSJ;

    @ExcelProperty(value = "销户时间")
    @TableField("XHSJ")
    private String XHSJ;

    @ExcelProperty(value = "账户状态")
    @TableField("ZHZT")
    private String ZHZT;

    @ExcelProperty(value = "银行机构代码")
    @TableField("YHJGDM")
    private String YHJGDM;

    @ExcelProperty(value = "账户名称")
    @TableField("ZHMC")
    private String ZHMC;

    @ExcelProperty(value = "证照号码")
    @TableField("ZZHM")
    private String ZZHM;

    @ExcelProperty(value = "反馈人")
    @TableField("FKR")
    private String FKR;

    @ExcelProperty(value = "反馈录入时间")
    @TableField("FKLRSJ")
    private String FKLRSJ;

    @ExcelProperty(value = "备注")
    @TableField("BZ")
    private String BZ;


}
