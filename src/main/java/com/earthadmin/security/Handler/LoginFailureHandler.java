package com.earthadmin.security.Handler;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.earthadmin.domain.entity.User;
import com.earthadmin.mapper.UserMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Resource
    private UserMapper userMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        String username = request.getParameter("username");
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name",username);
        User user = userMapper.selectOne(wrapper);
        if(user==null){
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write("{\"status\":\"error\",\"msg\":\"用户名错误,请重新检查\"}");
            out.flush();
            out.close();
        }else {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("{\"status\":\"error\",\"msg\":\"密码错误,请重新检查\"}");
        out.flush();
        out.close();
        }
    }
}
