package com.bjd.smartanalysis.common;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {
    public static Map<String, String> timekeys = new HashMap<>();

    public static Long GetGroupId(HttpServletRequest request) {
        Long groupid = null;
        HttpSession session = request.getSession();
        if (session != null) {
            Object gid = session.getAttribute("groupid");
            if (gid != null && !gid.equals("undefined")) {
                groupid = Long.parseLong(gid.toString());
            }
        }
        return groupid;
    }
    public static Long GetUserId(HttpServletRequest request) {
        Long userid = null;
        HttpSession session = request.getSession();
        if (session != null) {
            Object uid = session.getAttribute("userid");
            if (uid != null && !uid.equals("undefined")) {
                userid = Long.parseLong(uid.toString());
            }
        }
        return userid;
    }
    public static void ReloadDateTime() {
        String str = ResourceUtil.readUtf8Str("classpath:times.json");
        JSONObject o = JSONObject.parseObject(str);
        JSONArray arr = o.getJSONArray("data");

        Map<String, String> ks = new HashMap<>();
        for (int i=0;i<arr.size();i++) {
            JSONObject oi = arr.getJSONObject(i);
            ks.put(oi.getString("pattern"), oi.getString("format"));
        }
        timekeys = ks;
    }

    public static String DealTime(String time) {
        String res = "";
        String format = "";

        Set<String> patt = timekeys.keySet();
        for (String k: patt) {
            Pattern pattern = Pattern.compile(k);
            Matcher m = pattern.matcher(time);
            if (m.matches()) {
                format = timekeys.get(k);
                break;
            }
        }

        if (!format.equals("")) {
            Date d = DateUtil.parse(time, format);
            res = DateUtil.format(d, "yyyy-MM-dd HH:mm:ss");
        } else {
            res = time;
        }

        return res;
    }
}
