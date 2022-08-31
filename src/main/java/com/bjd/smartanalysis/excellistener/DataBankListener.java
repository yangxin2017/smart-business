package com.bjd.smartanalysis.excellistener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.bjd.smartanalysis.entity.data.DataBank;
import com.bjd.smartanalysis.service.data.DataBankService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DataBankListener extends AnalysisEventListener<DataBank> {
    private DataBankService bankService;
    private Integer projectId;
    private List<DataBank> bankList = new ArrayList<>();

    public DataBankListener() {
    }

    public DataBankListener(DataBankService bankService, Integer projectId) {
        this.bankService = bankService;
        this.projectId = projectId;
    }

    @Override
    public void invoke(DataBank dataBank, AnalysisContext analysisContext) {
        dataBank.setProjectId(projectId);
        /*if (dataBank.getBFZH() == null) {
            dataBank.setBFZH("空");
        }*/
        if (dataBank.getJDBZ().equals("进")) {
            if (Float.parseFloat(dataBank.getJYJE()) >= 0) {
                dataBank.setJYJE(String.valueOf(Float.parseFloat(dataBank.getJYJE())));
            } else {
                dataBank.setJYJE(String.valueOf(Float.parseFloat(dataBank.getJYJE()) * -1));
            }
        } else if (dataBank.getJDBZ().equals("出")) {
            if (Float.parseFloat(dataBank.getJYJE()) > 0) {
                dataBank.setJYJE(String.valueOf(Float.parseFloat(dataBank.getJYJE()) * -1));
            } else {
                dataBank.setJYJE(String.valueOf(Float.parseFloat(dataBank.getJYJE())));
            }
        } else {
            /*DataBank lastBank = null;
            // 获取bankList中最后一条BFKH为BFKH的数据
            for (int i = 0; i < bankList.size(); i++) {
                if (bankList.get(i).getBFZH().equals(dataBank.getBFZH())) {
                    lastBank = bankList.get(i);
                }
            }
            // 如果lastBank的JYYE大于dataBank的JYYE，则dataBank的JYJE转为浮点型设置为负数，否则设置为正数转为浮点型，并将数据最终转为字符串
            if (lastBank != null) {
                Float lastBankJYYE = Float.parseFloat(lastBank.getJYYE());
                Float dataBankJYYE = Float.parseFloat(dataBank.getJYYE());
                if (lastBankJYYE > dataBankJYYE) {
                    if (Float.parseFloat(dataBank.getJYJE()) > 0) {
                        dataBank.setJYJE(String.valueOf(Float.parseFloat(dataBank.getJYJE()) * -1));
                    } else {
                        dataBank.setJYJE(String.valueOf(Float.parseFloat(dataBank.getJYJE())));
                    }
                } else {
                    if (Float.parseFloat(dataBank.getJYJE()) < 0) {
                        dataBank.setJYJE(String.valueOf(Float.parseFloat(dataBank.getJYJE()) * -1));
                    } else {
                        dataBank.setJYJE(String.valueOf(Float.parseFloat(dataBank.getJYJE())));
                    }
                }
            }*/
        }

        bankList.add(dataBank);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        bankService.saveBatch(bankList);
    }
}
