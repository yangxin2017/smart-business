package com.bjd.smartanalysis.excellistener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.bjd.smartanalysis.common.CommonUtils;
import com.bjd.smartanalysis.entity.data.DataBank;
import com.bjd.smartanalysis.service.data.DataBankService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DataBankListener extends AnalysisEventListener<DataBank> {
    private DataBankService bankService;
    private Integer projectId;
    private List<DataBank> bankList = new ArrayList<>();
    private Integer batch_count = 100;

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
        if(dataBank.getJDBZ()!=null){
            if (dataBank.getJDBZ().equals("进") || dataBank.getJDBZ().equals("贷")) {
                if (Float.parseFloat(dataBank.getJYJE()) >= 0) {
                    dataBank.setJYJE(String.valueOf(Float.parseFloat(dataBank.getJYJE())));
                } else {
                    dataBank.setJYJE(String.valueOf(Float.parseFloat(dataBank.getJYJE()) * -1));
                }
            } else if (dataBank.getJDBZ().equals("出") || dataBank.getJDBZ().equals("借")) {
                if (Float.parseFloat(dataBank.getJYJE()) > 0) {
                    dataBank.setJYJE(String.valueOf(Float.parseFloat(dataBank.getJYJE()) * -1));
                } else {
                    dataBank.setJYJE(String.valueOf(Float.parseFloat(dataBank.getJYJE())));
                }
                String jysj = dataBank.getJYSJ();
                jysj = CommonUtils.DealTime(jysj);
                dataBank.setJYSJ(jysj);
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
        }

        // 数据库中是否包含与dataBank相同的数据
//        boolean isExist = bankService.isExist(projectId,dataBank);
//        if(!isExist){
//            bankList.add(dataBank);
//        }

        bankList.add(dataBank);
        if (bankList.size() >= this.batch_count) {
            SaveData();
            bankList.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        SaveData();
    }

    public void SaveData() {
        bankService.saveBatch(bankList);
    }
}
