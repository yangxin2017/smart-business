package com.bjd.smartanalysis.serviceImpl.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.data.DataGaRydzda;
import com.bjd.smartanalysis.mapper.data.DataGaRydzdaMapper;
import com.bjd.smartanalysis.service.data.DataGaRydzdaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGaRydzdaServiceImpl extends ServiceImpl<DataGaRydzdaMapper, DataGaRydzda> implements DataGaRydzdaService {
    @Autowired
    DataGaRydzdaMapper mapper;

    @Override
    public List<DataGaRydzda> GetAllPerson(String xm) {
        IPage<DataGaRydzda> page = new Page<>(1, 10);
        QueryWrapper<DataGaRydzda> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("project_id", projectId);
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        page = mapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }

    @Override
    public List<DataGaRydzda> GetAllPersonList(Integer projectId, String xm) {
        QueryWrapper<DataGaRydzda> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.like("XM", xm);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public DataGaRydzda GetPersonByName(Integer projectId, String xm) {
        QueryWrapper<DataGaRydzda> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.eq("XM", xm);
        }
        queryWrapper.last("limit 1");
        return mapper.selectOne(queryWrapper);
    }

    @Override
    public DataGaRydzda GetPersonByName(Integer projectId, String xm, String sfzh) {
        QueryWrapper<DataGaRydzda> queryWrapper = new QueryWrapper<>();
        if (projectId != null) {
            queryWrapper.eq("project_id", projectId);
        }
        if (xm != null && !xm.equals("")) {
            queryWrapper.eq("XM", xm);
        }
        if (sfzh != null && !sfzh.equals("")) {
            queryWrapper.eq("SFZH", sfzh);
        }
        queryWrapper.last("limit 1");
        return mapper.selectOne(queryWrapper);
    }

    @Override
    //isExist
    public Boolean isExist(Integer projectId, DataGaRydzda dataGaRydzda) {
        QueryWrapper<DataGaRydzda> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", projectId);
        /*if (dataGaRydzda.getXM() == null) {
            queryWrapper.isNull("XM");
        } else {
            queryWrapper.eq("XM", dataGaRydzda.getXM());
        }
        // TXZP
        if (dataGaRydzda.getTXZP() == null) {
            queryWrapper.isNull("TXZP");
        } else {
            queryWrapper.eq("TXZP", dataGaRydzda.getTXZP());
        }
        // SFZH
        if (dataGaRydzda.getSFZH() == null) {
            queryWrapper.isNull("SFZH");
        } else {
            queryWrapper.eq("SFZH", dataGaRydzda.getSFZH());
        }
        // XM
        if (dataGaRydzda.getXM() == null) {
            queryWrapper.isNull("XM");
        } else {
            queryWrapper.eq("XM", dataGaRydzda.getXM());
        }
        // XB
        if (dataGaRydzda.getXB() == null) {
            queryWrapper.isNull("XB");
        } else {
            queryWrapper.eq("XB", dataGaRydzda.getXB());
        }
        // MZ
        if (dataGaRydzda.getMZ() == null) {
            queryWrapper.isNull("MZ");
        } else {
            queryWrapper.eq("MZ", dataGaRydzda.getMZ());
        }
        // HJD
        if (dataGaRydzda.getHJD() == null) {
            queryWrapper.isNull("HJD");
        } else {
            queryWrapper.eq("HJD", dataGaRydzda.getHJD());
        }
        // HJDQH
        if (dataGaRydzda.getHJDQH() == null) {
            queryWrapper.isNull("HJDQH");
        } else {
            queryWrapper.eq("HJDQH", dataGaRydzda.getHJDQH());
        }
        // HJDPCS
        if (dataGaRydzda.getHJDPCS() == null) {
            queryWrapper.isNull("HJDPCS");
        } else {
            queryWrapper.eq("HJDPCS", dataGaRydzda.getHJDPCS());
        }
        // CSRQ
        if (dataGaRydzda.getCSRQ() == null) {
            queryWrapper.isNull("CSRQ");
        } else {
            queryWrapper.eq("CSRQ", dataGaRydzda.getCSRQ());
        }
        // CYM
        if (dataGaRydzda.getCYM() == null) {
            queryWrapper.isNull("CYM");
        } else {
            queryWrapper.eq("CYM", dataGaRydzda.getCYM());
        }
        // CSD
        if (dataGaRydzda.getCSD() == null) {
            queryWrapper.isNull("CSD");
        } else {
            queryWrapper.eq("CSD", dataGaRydzda.getCSD());
        }
        // JG
        if (dataGaRydzda.getJG() == null) {
            queryWrapper.isNull("JG");
        } else {
            queryWrapper.eq("JG", dataGaRydzda.getJG());
        }
        // SG
        if (dataGaRydzda.getSG() == null) {
            queryWrapper.isNull("SG");
        } else {
            queryWrapper.eq("SG", dataGaRydzda.getSG());
        }
        // ZY
        if (dataGaRydzda.getZY() == null) {
            queryWrapper.isNull("ZY");
        } else {
            queryWrapper.eq("ZY", dataGaRydzda.getZY());
        }
        // CSDGJ
        if (dataGaRydzda.getCSDGJ() == null) {
            queryWrapper.isNull("CSDGJ");
        } else {
            queryWrapper.eq("CSDGJ", dataGaRydzda.getCSDGJ());
        }
        // CSDQH
        if (dataGaRydzda.getCSDQH() == null) {
            queryWrapper.isNull("CSDQH");
        } else {
            queryWrapper.eq("CSDQH", dataGaRydzda.getCSDQH());
        }
        // JGGJ
        if (dataGaRydzda.getJGGJ() == null) {
            queryWrapper.isNull("JGGJ");
        } else {
            queryWrapper.eq("JGGJ", dataGaRydzda.getJGGJ());
        }
        // FWCS
        if (dataGaRydzda.getFWCS() == null) {
            queryWrapper.isNull("FWCS");
        } else {
            queryWrapper.eq("FWCS", dataGaRydzda.getFWCS());
        }
        // BYZK
        if (dataGaRydzda.getBYZK() == null) {
            queryWrapper.isNull("BYZK");
        } else {
            queryWrapper.eq("BYZK", dataGaRydzda.getBYZK());
        }
        // WHCD
        if (dataGaRydzda.getWHCD() == null) {
            queryWrapper.isNull("WHCD");
        } else {
            queryWrapper.eq("WHCD", dataGaRydzda.getWHCD());
        }
        // HYZK
        if (dataGaRydzda.getHYZK() == null) {
            queryWrapper.isNull("HYZK");
        } else {
            queryWrapper.eq("HYZK", dataGaRydzda.getHYZK());
        }
        // SWRQ
        if (dataGaRydzda.getSWRQ() == null) {
            queryWrapper.isNull("SWRQ");
        } else {
            queryWrapper.eq("SWRQ", dataGaRydzda.getSWRQ());
        }
        // sf_mbr
        if (dataGaRydzda.getSfMbr() == null) {
            queryWrapper.isNull("sf_mbr");
        } else {
            queryWrapper.eq("sf_mbr", dataGaRydzda.getSfMbr());
        }*/


        if(dataGaRydzda.getSFZH() == null){
            /*queryWrapper.isNull("SFZH");*/
            // 返回否
            return false;
        }else{
            queryWrapper.eq("SFZH", dataGaRydzda.getSFZH());
        }


        return mapper.selectCount(queryWrapper) > 0;
    }


}
