package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataBank;

import java.util.List;

public interface DataBankService extends IService<DataBank> {
    public List<DataBank> GetAllBanks(Integer projectId);

    //isExist
    public Boolean isExist(Integer projectId,DataBank dataBank);
}
