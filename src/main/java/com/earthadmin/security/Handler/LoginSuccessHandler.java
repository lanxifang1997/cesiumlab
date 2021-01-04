package com.earthadmin.security.Handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lanxifang
 * @date 2020/12/22 14:42
 */
@Component
@Slf4j
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        Enumeration<String> headerNames1 = request.getHeaderNames();

//        Collection<String> headerNames = response.getHeaderNames();
//
//        if(headerNames.contains("Set-Cookie")){
//            String header = response.getHeader("Set-Cookie");
//            log.info("cookie:"+header);
//            String substring = header.substring(0, header.indexOf(";"));
//            log.info("cookie:"+substring);
//            response.setHeader("mycookie",substring);
//
//        }
//        log.info("----------------------:"+headerNames.toString());
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("{\"status\":\"success\",\"msg\":\"登录成功\"}");
        out.flush();
        out.close();

    }
}
