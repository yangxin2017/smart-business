package com.bjd.smartanalysis.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bjd.smartanalysis.common.ResponseData;
import com.bjd.smartanalysis.entity.sys.SysGroup;
import com.bjd.smartanalysis.entity.sys.SysUser;
import com.bjd.smartanalysis.entity.sys.SysUserGroup;
import com.bjd.smartanalysis.service.sys.SysGroupService;
import com.bjd.smartanalysis.service.sys.SysUserGroupService;
import com.bjd.smartanalysis.service.sys.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
@Api(value = "用户管理", tags = {"用户管理"})
public class UserController {
    @Value("${user.api.path}")
    private String apiPath;

    @Autowired
    private SysGroupService groupService;
    @Autowired
    private SysUserService userService;
    @Autowired
    private SysUserGroupService userGroupService;

    @PostMapping("sso")
    @ApiOperation(value = "单点登录", notes = "单点登录")
    private ResponseData SsoLogin(String token, Long tenandId) {
        String ssourl = apiPath + "api/oauth/anyTenant/verify?token=" + token + "&tenandId=" + tenandId;
        String result = HttpUtil.get(ssourl);
        JSONObject loginObj = JSONObject.parseObject(result);

        SysUser comUser = null;
        if(loginObj.getInteger("code") == 0) {
            JSONObject loginUser = loginObj.getJSONObject("data");
            String tokenstr = loginUser.getString("token");
            Long userId = loginUser.getLong("userId");

            Map<String, String> header = new HashMap<>();
            header.put("tenantId", tenandId.toString());
            header.put("tenantID", tenandId.toString());
            header.put("TenantId", tenandId.toString());
            header.put("token", token);
            header.put("Token", token);

            Map<String, Object> params = new HashMap<>();
            params.put("tenantId", tenandId);
            params.put("tenantID", tenandId);
            params.put("token", token);
            params.put("Token", token);
            params.put("TenantId", tenandId);

            // String userurl = apiPath + "api/oauth/anyTenant/userInfo?token=" + tokenstr + "&tenantID=" + tenandId;
            String userurl = apiPath + "api/oauth/anyTenant/userInfo";
            String resstruser = HttpUtil.createGet(userurl).addHeaders(header).form(params).execute().body();

            JSONObject userInfoResObj = JSONObject.parseObject(resstruser);//JSONObject.parseObject(HttpUtil.get(userurl));
            if (userInfoResObj.getInteger("code") == 0) {
                JSONObject userInfoObj = userInfoResObj.getJSONObject("data").getJSONObject("userInfo");
                JSONObject defUserInfo = userInfoObj.getJSONObject("defUser");
                String nickname = defUserInfo.getString("nickName");
                String userName = defUserInfo.getString("username");

                String groupurl = apiPath + "api/liangziyun/anyone/findUserGroup";

                String resstr = HttpUtil.createGet(groupurl).addHeaders(header).form(params).execute().body();
                JSONObject obj = JSONObject.parseObject(resstr);

                if(obj.getInteger("code") == 0) {
                    JSONArray groupObj = obj.getJSONArray("data");

                    Long comGroupId = -1l;
                    SysGroup group = null;
                    if(groupObj.size() > 0) {
                        for(int i=0;i<groupObj.size();i++) {
                            Long groupId = Math.abs(RandomUtil.randomLong());
                            JSONObject gobj = groupObj.getJSONObject(i);
                            comGroupId = gobj.getLong("id");
                            group = groupService.GetGroupByComeGroupId(comGroupId);
                            ////
                            if (group == null) {
                                group = new SysGroup();
                                group.setComeGroupId(comGroupId);
                                group.setGroupId(groupId);
                                groupService.save(group);
                            } else {
                                groupId = group.getGroupId();
                            }
                            // 保存用户和组的关系
                            SysUserGroup sug = userGroupService.GetDataByUserAndGroup(userId, groupId);
                            if(sug == null) {
                                SysUserGroup sugsave = new SysUserGroup();
                                sugsave.setGroupId(groupId);
                                sugsave.setUserId(userId);
                                userGroupService.save(sugsave);
                            }
                        }

                    }
                    comUser = userService.getById(userId);
                    if (comUser == null) {
                        comUser = new SysUser();
                        comUser.setId(userId);
                        comUser.setTenandId(tenandId);
                        comUser.setGroupId(0l);
                        comUser.setUsername(userName);
                        comUser.setPassword("******");
                        comUser.setNickname(nickname);
                        comUser.setCtime(new Date());
                        userService.save(comUser);
                    }
                }
            }
            return ResponseData.OK(comUser);
        }

        if (comUser == null) {
            comUser = userService.getById(251093520520052811l);
        }
        return ResponseData.OK(comUser);
    }
}