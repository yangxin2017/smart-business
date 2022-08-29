package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataBank;
import com.bjd.smartanalysis.mapper.data.DataBankMapper;
import com.bjd.smartanalysis.service.data.DataBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataBankServiceImpl extends ServiceImpl<DataBankMapper, DataBank> implements DataBankService {
    @Autowired
    private DataBankMapper mapper;

    @Override
    public List<DataBank> GetAllBanks(Integer projectId) {
        QueryWrapper<DataBank> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        return mapper.selectList(queryWrapper);
    }
}
