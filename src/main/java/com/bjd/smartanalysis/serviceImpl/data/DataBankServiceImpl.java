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

    @Override
    public Boolean isExist(Integer projectId, DataBank dataBank) {
        QueryWrapper<DataBank> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", projectId);
        if (dataBank.getFKDW() == null){
            queryWrapper.isNull("FKDW");
        }else {
            queryWrapper.eq("FKDW", dataBank.getFKDW());
        }
        if (dataBank.getSPB() == null){
            queryWrapper.isNull("SPB");
        }else {
            queryWrapper.eq("SPB", dataBank.getSPB());
        }
        if (dataBank.getMC() == null){
            queryWrapper.isNull("MC");
        }else {
            queryWrapper.eq("MC", dataBank.getMC());
        }
        if (dataBank.getZJLX() == null){
            queryWrapper.isNull("ZJLX");
        }else {
            queryWrapper.eq("ZJLX", dataBank.getZJLX());
        }
        if (dataBank.getZJHM() == null){
            queryWrapper.isNull("ZJHM");
        }else {
            queryWrapper.eq("ZJHM", dataBank.getZJHM());
        }
        if (dataBank.getCXDXMC() == null){
            queryWrapper.isNull("CXDXMC");
        }else {
            queryWrapper.eq("CXDXMC", dataBank.getCXDXMC());
        }
        if (dataBank.getCXKH() == null){
            queryWrapper.isNull("CXKH");
        }else {
            queryWrapper.eq("CXKH", dataBank.getCXKH());
        }
        if (dataBank.getCXFKJGYY() == null){
            queryWrapper.isNull("CXFKJGYY");
        }else {
            queryWrapper.eq("CXFKJGYY", dataBank.getCXFKJGYY());
        }
        if (dataBank.getBFZH() == null){
            queryWrapper.isNull("BFZH");
        }else {
            queryWrapper.eq("BFZH", dataBank.getBFZH());
        }
        if (dataBank.getBFKH() == null){
            queryWrapper.isNull("BFKH");
        }else {
            queryWrapper.eq("BFKH", dataBank.getBFKH());
        }
        if (dataBank.getJYLX() == null){
            queryWrapper.isNull("JYLX");
        }else {
            queryWrapper.eq("JYLX", dataBank.getJYLX());
        }
        if (dataBank.getJDBZ() == null){
            queryWrapper.isNull("JDBZ");
        }else {
            queryWrapper.eq("JDBZ", dataBank.getJDBZ());
        }
        if (dataBank.getBZ() == null){
            queryWrapper.isNull("BZ");
        }else {
            queryWrapper.eq("BZ", dataBank.getBZ());
        }
        if (dataBank.getJYJE() == null){
            queryWrapper.isNull("JYJE");
        }else {
            queryWrapper.eq("JYJE", dataBank.getJYJE());
        }
        if (dataBank.getJYYE() == null){
            queryWrapper.isNull("JYYE");
        }else {
            queryWrapper.eq("JYYE", dataBank.getJYYE());
        }
        if (dataBank.getJYSJ() == null){
            queryWrapper.isNull("JYSJ");
        }else {
            queryWrapper.eq("JYSJ", dataBank.getJYSJ());
        }
        if (dataBank.getJYLSH() == null){
            queryWrapper.isNull("JYLSH");
        }else {
            queryWrapper.eq("JYLSH", dataBank.getJYLSH());
        }
        if (dataBank.getJYDFMC() == null){
            queryWrapper.isNull("JYDFMC");
        }else {
            queryWrapper.eq("JYDFMC", dataBank.getJYDFMC());
        }
        if (dataBank.getJYDFZH() == null){
            queryWrapper.isNull("JYDFZH");
        }else {
            queryWrapper.eq("JYDFZH", dataBank.getJYDFZH());
        }
        if (dataBank.getJYDFKH() == null){
            queryWrapper.isNull("JYDFKH");
        }else {
            queryWrapper.eq("JYDFKH", dataBank.getJYDFKH());
        }
        if (dataBank.getJYDFZJHM() == null){
            queryWrapper.isNull("JYDFZJHM");
        }else {
            queryWrapper.eq("JYDFZJHM", dataBank.getJYDFZJHM());
        }
        if (dataBank.getJYDSYE() == null){
            queryWrapper.isNull("JYDSYE");
        }else {
            queryWrapper.eq("JYDSYE", dataBank.getJYDSYE());
        }
        if (dataBank.getJYDFZHKHH() == null){
            queryWrapper.isNull("JYDFZHKHH");
        }else {
            queryWrapper.eq("JYDFZHKHH", dataBank.getJYDFZHKHH());
        }
        if (dataBank.getJYZY() == null){
            queryWrapper.isNull("JYZY");
        }else {
            queryWrapper.eq("JYZY", dataBank.getJYZY());
        }
        if (dataBank.getJYWDMC() == null){
            queryWrapper.isNull("JYWDMC");
        }else {
            queryWrapper.eq("JYWDMC", dataBank.getJYWDMC());
        }
        if (dataBank.getJYWDDM() == null){
            queryWrapper.isNull("JYWDDM");
        }else {
            queryWrapper.eq("JYWDDM", dataBank.getJYWDDM());
        }
        if (dataBank.getRZH() == null){
            queryWrapper.isNull("RZH");
        }else {
            queryWrapper.eq("RZH", dataBank.getRZH());
        }
        if (dataBank.getCPH() == null){
            queryWrapper.isNull("CPH");
        }else {
            queryWrapper.eq("CPH", dataBank.getCPH());
        }
        if (dataBank.getPZZL() == null){
            queryWrapper.isNull("PZZL");
        }else {
            queryWrapper.eq("PZZL", dataBank.getPZZL());
        }
        if (dataBank.getPZH() == null){
            queryWrapper.isNull("PZH");
        }else {
            queryWrapper.eq("PZH", dataBank.getPZH());
        }
        if (dataBank.getXJBZ() == null){
            queryWrapper.isNull("XJBZ");
        }else {
            queryWrapper.eq("XJBZ", dataBank.getXJBZ());
        }
        if (dataBank.getZDH() == null){
            queryWrapper.isNull("ZDH");
        }else {
            queryWrapper.eq("ZDH", dataBank.getZDH());
        }
        if (dataBank.getJYSFCG() == null){
            queryWrapper.isNull("JYSFCG");
        }else {
            queryWrapper.eq("JYSFCG", dataBank.getJYSFCG());
        }
        if (dataBank.getJYFSD() == null){
            queryWrapper.isNull("JYFSD");
        }else {
            queryWrapper.eq("JYFSD", dataBank.getJYFSD());
        }
        if (dataBank.getSHMC() == null){
            queryWrapper.isNull("SHMC");
        }else {
            queryWrapper.eq("SHMC", dataBank.getSHMC());
        }
        if (dataBank.getSHH() == null){
            queryWrapper.isNull("SHH");
        }else {
            queryWrapper.eq("SHH", dataBank.getSHH());
        }
        if (dataBank.getIPDZ() == null){
            queryWrapper.isNull("IPDZ");
        }else {
            queryWrapper.eq("IPDZ", dataBank.getIPDZ());
        }
        if (dataBank.getMACDZ() == null){
            queryWrapper.isNull("MACDZ");
        }else {
            queryWrapper.eq("MACDZ", dataBank.getMACDZ());
        }
        if (dataBank.getJYGYH() == null){
            queryWrapper.isNull("JYGYH");
        }else {
            queryWrapper.eq("JYGYH", dataBank.getJYGYH());
        }
        if (dataBank.getREMARK() == null){
            queryWrapper.isNull("REMARK");
        }else {
            queryWrapper.eq("REMARK", dataBank.getREMARK());
        }

        return mapper.selectCount(queryWrapper) > 0;
    }
}
