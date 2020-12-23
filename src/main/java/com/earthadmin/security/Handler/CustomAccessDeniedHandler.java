package com.earthadmin.security.Handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lanxifang
 * @date 2020/12/22 17:57
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {

        //HttpServletResponse.SC_FORBIDDEN代表 403
        //response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        httpServletResponse.setHeader("Content-Type","application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        out.write("{\"status\":\"error\",\"msg\":\"权限不足！\"}");
        out.flush();
        out.close();


    }
}
