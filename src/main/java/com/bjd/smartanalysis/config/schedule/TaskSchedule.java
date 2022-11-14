package com.bjd.smartanalysis.config.schedule;

import com.bjd.smartanalysis.common.CommonUtils;
import com.bjd.smartanalysis.common.PageData;
import com.bjd.smartanalysis.entity.data.DataBank;
import com.bjd.smartanalysis.entity.data.DataProject;
import com.bjd.smartanalysis.service.data.DataBankService;
import com.bjd.smartanalysis.service.data.DataProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
@EnableScheduling
public class TaskSchedule {
    @Autowired
    private DataBankService bankService;
    @Autowired
    private DataProjectService projectService;

    @PostConstruct
    public void StartUp() {
        System.out.println("Start....");
        CommonUtils.ReloadDateTime();
        System.out.println("ok");
    }

    private void DealDataBank(Integer projectId) {
        List<DataBank> banks = bankService.GetAllBanks(projectId);
        for (DataBank b: banks) {
            String jysj = b.getJYSJ();
            jysj = CommonUtils.DealTime(jysj);
            b.setJYSJ(jysj);
        }
        bankService.updateBatchById(banks, 1000);
    }
}
