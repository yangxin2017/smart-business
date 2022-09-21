package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaQsgx;
import com.bjd.smartanalysis.mapper.data.DataGaQsgxMapper;
import com.bjd.smartanalysis.service.data.DataGaQsgxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaQsgxServiceImpl extends ServiceImpl<DataGaQsgxMapper, DataGaQsgx> implements DataGaQsgxService {
    @Autowired
    DataGaQsgxMapper mapper;
    @Override
    public Boolean isExist(Integer projectId, DataGaQsgx dataGaQsgx) {
        QueryWrapper<DataGaQsgx> queryWrapper = new QueryWrapper<>();
        if(dataGaQsgx.getXM1()==null){
            queryWrapper.isNull("XM1");
        }else{
            queryWrapper.eq("XM1", dataGaQsgx.getXM1());
        }
        if(dataGaQsgx.getXM2()==null){
            queryWrapper.isNull("XM2");
        }else{
            queryWrapper.eq("XM2", dataGaQsgx.getXM2());
        }
        // return false;
        return mapper.selectCount(queryWrapper) > 0;
    }

    @Override
    public List<DataGaQsgx> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaQsgx> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM1", xm);
        }
        return mapper.selectList(queryWrapper);
    }
}
