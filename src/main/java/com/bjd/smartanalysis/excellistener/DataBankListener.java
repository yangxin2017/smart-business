package com.bjd.smartanalysis.excellistener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.bjd.smartanalysis.entity.data.DataBank;
import com.bjd.smartanalysis.service.data.DataBankService;

import java.util.ArrayList;
import java.util.List;

public class DataBankListener extends AnalysisEventListener<DataBank> {
    private DataBankService bankService;
    private Integer projectId;
    private List<DataBank> bankList = new ArrayList<>();

    public DataBankListener() {}

    public DataBankListener(DataBankService bankService, Integer projectId) {
        this.bankService = bankService;
        this.projectId = projectId;
    }

    @Override
    public void invoke(DataBank dataBank, AnalysisContext analysisContext) {
        dataBank.setProjectId(projectId);
        bankList.add(dataBank);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        bankService.saveBatch(bankList);
    }
}
