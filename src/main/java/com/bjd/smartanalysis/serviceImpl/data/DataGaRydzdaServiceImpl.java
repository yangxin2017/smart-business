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
    //isExist
    public Boolean isExist(Integer projectId, DataGaRydzda dataGaRydzda) {
        QueryWrapper<DataGaRydzda> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", projectId);
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
        // SFZH
        if (dataGaRydzda.getSFZH() == null) {
            queryWrapper.isNull("SFZH");
        } else {
            queryWrapper.eq("SFZH", dataGaRydzda.getSFZH());
        }
        // MZ
        if (dataGaRydzda.getMZ() == null) {
            queryWrapper.isNull("MZ");
        } else {
            queryWrapper.eq("MZ", dataGaRydzda.getMZ());
        }
        // CSRQ
        if (dataGaRydzda.getCSRQ() == null) {
            queryWrapper.isNull("CSRQ");
        } else {
            queryWrapper.eq("CSRQ", dataGaRydzda.getCSRQ());
        }
        // HYZK
        if (dataGaRydzda.getHYZK() == null) {
            queryWrapper.isNull("HYZK");
        } else {
            queryWrapper.eq("HYZK", dataGaRydzda.getHYZK());
        }
        // SX
        if (dataGaRydzda.getSX() == null) {
            queryWrapper.isNull("SX");
        } else {
            queryWrapper.eq("SX", dataGaRydzda.getSX());
        }
        // XZ
        if (dataGaRydzda.getXZ() == null) {
            queryWrapper.isNull("XZ");
        } else {
            queryWrapper.eq("XZ", dataGaRydzda.getXZ());
        }
        // BMCH
        if (dataGaRydzda.getBMCH() == null) {
            queryWrapper.isNull("BMCH");
        } else {
            queryWrapper.eq("BMCH", dataGaRydzda.getBMCH());
        }
        // CYM
        if (dataGaRydzda.getCYM() == null) {
            queryWrapper.isNull("CYM");
        } else {
            queryWrapper.eq("CYM", dataGaRydzda.getCYM());
        }
        // SG
        if (dataGaRydzda.getSG() == null) {
            queryWrapper.isNull("SG");
        } else {
            queryWrapper.eq("SG", dataGaRydzda.getSG());
        }
        // XX
        if (dataGaRydzda.getXX() == null) {
            queryWrapper.isNull("XX");
        } else {
            queryWrapper.eq("XX", dataGaRydzda.getXX());
        }
        // ZGXL
        if (dataGaRydzda.getZGXL() == null) {
            queryWrapper.isNull("ZGXL");
        } else {
            queryWrapper.eq("ZGXL", dataGaRydzda.getZGXL());
        }
        // ZZMM
        if (dataGaRydzda.getZZMM() == null) {
            queryWrapper.isNull("ZZMM");
        } else {
            queryWrapper.eq("ZZMM", dataGaRydzda.getZZMM());
        }
        // ZY
        if (dataGaRydzda.getZY() == null) {
            queryWrapper.isNull("ZY");
        } else {
            queryWrapper.eq("ZY", dataGaRydzda.getZY());
        }
        // CYDW
        if (dataGaRydzda.getCYDW() == null) {
            queryWrapper.isNull("CYDW");
        } else {
            queryWrapper.eq("CYDW", dataGaRydzda.getCYDW());
        }
        // BYZK
        if (dataGaRydzda.getBYZK() == null) {
            queryWrapper.isNull("BYZK");
        } else {
            queryWrapper.eq("BYZK", dataGaRydzda.getBYZK());
        }
        // TMTZMS
        if (dataGaRydzda.getTMTZMS() == null) {
            queryWrapper.isNull("TMTZMS");
        } else {
            queryWrapper.eq("TMTZMS", dataGaRydzda.getTMTZMS());
        }
        // CSDQH
        if (dataGaRydzda.getCSDQH() == null) {
            queryWrapper.isNull("CSDQH");
        } else {
            queryWrapper.eq("CSDQH", dataGaRydzda.getCSDQH());
        }
        // JG
        if (dataGaRydzda.getJG() == null) {
            queryWrapper.isNull("JG");
        } else {
            queryWrapper.eq("JG", dataGaRydzda.getJG());
        }
        // HJDQH
        if (dataGaRydzda.getHJDQH() == null) {
            queryWrapper.isNull("HJDQH");
        } else {
            queryWrapper.eq("HJDQH", dataGaRydzda.getHJDQH());
        }
        // HJDZ
        if (dataGaRydzda.getHJDZ() == null) {
            queryWrapper.isNull("HJDZ");
        } else {
            queryWrapper.eq("HJDZ", dataGaRydzda.getHJDZ());
        }
        // QTDZ
        if (dataGaRydzda.getQTDZ() == null) {
            queryWrapper.isNull("QTDZ");
        } else {
            queryWrapper.eq("QTDZ", dataGaRydzda.getQTDZ());
        }
        // XWBQ
        if (dataGaRydzda.getXWBQ() == null) {
            queryWrapper.isNull("XWBQ");
        } else {
            queryWrapper.eq("XWBQ", dataGaRydzda.getXWBQ());
        }
        // sf_mbr
        if (dataGaRydzda.getSfMbr() == null) {
            queryWrapper.isNull("sf_mbr");
        } else {
            queryWrapper.eq("sf_mbr", dataGaRydzda.getSfMbr());
        }

        return mapper.selectCount(queryWrapper) > 0;
    }
}
