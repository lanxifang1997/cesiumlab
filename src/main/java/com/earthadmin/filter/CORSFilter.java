package com.earthadmin.filter;

/**
 * @author lanxifang
 * @date 2020/12/07 18:51
 */

import com.earthadmin.mapper.ModelsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet Filter implementation class HttpFilter
 */
//@WebFilter(filterName="CORSFilter",urlPatterns="/login")
//@Order(value = 1)
@Slf4j
public class CORSFilter implements Filter {

    @Value("${CROS_ALLOWED_ORIGINS}")
    private String[] allowedOrigins;

    @Resource
    private ModelsMapper modelsMapper;

    /**
     * Default constructor.
     */
    public CORSFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * 解决跨域
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp=(HttpServletResponse)response;
        HttpServletRequest rep = (HttpServletRequest) request;
        request.getParameter("");
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
