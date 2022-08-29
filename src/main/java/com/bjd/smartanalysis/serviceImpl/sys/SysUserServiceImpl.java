package com.bjd.smartanalysis.serviceImpl.sys;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjd.smartanalysis.entity.sys.SysUser;
import com.bjd.smartanalysis.mapper.sys.SysUserMapper;
import com.bjd.smartanalysis.service.sys.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}
