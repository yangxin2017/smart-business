package com.bjd.smartanalysis.config;


import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Configuration
@WebFilter(urlPatterns = "/*")
public class WebFIlter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getRequestURI();
        HttpSession session = request.getSession();
        String groupid = request.getHeader("groupid");
        String userid = request.getHeader("userid");

        if (groupid != null && !groupid.equals("")) {
            session.setAttribute("groupid", groupid);
        }
        if (userid != null && !userid.equals("")) {
            session.setAttribute("userid", userid);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
