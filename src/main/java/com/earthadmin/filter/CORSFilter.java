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
//@WebFilter(filterName="CORSFilter",urlPatterns="/*")
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
//        resp.setHeader("Access-Control-Allow-Origin", rep.getHeader("Origin"));
//        resp.setHeader("Access-Control-Allow-Methods", "POST, GET,PUT, OPTIONS, DELETE,PUT");
//        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorizationaccept, origin, content-type, token");
//        //允许跨域请求中携带cookie
//        resp.setHeader("Access-Control-Allow-Credentials","true");
//        String path = rep.getServletPath();
//        log.info("------------------------------------path"+path);
//        if(path.endsWith(".json")||path.endsWith(".b3dm") ||path.endsWith(".glb")){
//            log.info("------------------------------------这是一个访问静态资源的请求");
//
//            // 这是url例子/model/c7cc1730388111ebbc661d14fb544ab5/top/0_0_0_0.b3dm
//            String[] str = StringUtils.split(path,"/");
//            //strurl[1]就是要获取的id
//            log.info("------------------------------------从url获取的id:"+str[1]);
//            Model modelById = modelsMapper.findModelById(str[1]);
//
//            log.info("new File(modelById.getPath()).getParent()="+new File(modelById.getPath()).getParent());
//            String oldUrl = "/"+str[0]+"/"+ modelById.getId();
//           // String newUrl = new File(modelById.getPath()).getParent() ;
//            String newUrl = "localhost:8080";
//            String resourceUrl = StringUtils.replace(path, oldUrl, newUrl).replace("\\","/");
//            log.info("------------------------------------最终url="+"file:///"+resourceUrl );
//            rep.getRequestDispatcher(resourceUrl).forward(rep,resp);
//            RestTemplate restTemplate = new RestTemplate();
//
//            System.out.println("----");
//        }else {
            chain.doFilter(request, response);
//        }

    }

    /**
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
