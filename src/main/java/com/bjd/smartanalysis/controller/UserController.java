package com.bjd.smartanalysis.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bjd.smartanalysis.common.ResponseData;
import com.bjd.smartanalysis.entity.sys.SysGroup;
import com.bjd.smartanalysis.entity.sys.SysUser;
import com.bjd.smartanalysis.service.sys.SysGroupService;
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
            header.put("token", token);

            Map<String, Object> params = new HashMap<>();
            params.put("tenantId", tenandId);
            params.put("token", token);

            String userurl = apiPath + "api/oauth/anyTenant/userInfo?token=" + tokenstr + "&tenantID=" + tenandId;
            JSONObject userInfoResObj = JSONObject.parseObject(HttpUtil.get(userurl));
            if (userInfoResObj.getInteger("code") == 0) {
                JSONObject userInfoObj = userInfoResObj.getJSONObject("data").getJSONObject("userInfo");
                String nickname = userInfoObj.getString("nickName");
                String userName = userInfoObj.getString("username");

                String groupurl = apiPath + "api/liangziyun/anyone/findAllUserGroup";

                String resstr = HttpUtil.createGet(groupurl).addHeaders(header).form(params).execute().body();
                JSONArray groupObj = JSONArray.parseArray(resstr);

                Long comGroupId = -1l;
                SysGroup group = null;
                Long groupId = Math.abs(RandomUtil.randomLong());
                if(groupObj.size() > 0) {
                    JSONObject gobj = groupObj.getJSONObject(0);
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
                }
                comUser = userService.getById(userId);
                if (comUser == null) {
                    comUser = new SysUser();
                    comUser.setId(userId);
                    comUser.setTenandId(tenandId);
                    comUser.setGroupId(groupId);
                    comUser.setUsername(userName);
                    comUser.setPassword("******");
                    comUser.setNickname(nickname);
                    comUser.setCtime(new Date());
                    userService.save(comUser);
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
