package com.bjd.smartanalysis.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommonUtils {
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
}
