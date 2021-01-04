package com.earthadmin.config;

import com.earthadmin.security.Handler.CustomAccessDeniedHandler;
import com.earthadmin.security.Handler.CustomLogoutSuccessHandler;
import com.earthadmin.security.Handler.LoginFailureHandler;
import com.earthadmin.security.Handler.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * @author lanxifang
 * @date 2020/12/21 18:30
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private LoginSuccessHandler loginSuccessHandler;

    @Resource
    private LoginFailureHandler loginFailureHandler;

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Resource
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;

    /**
     * 上传文件保存的本地目录
     */
    @Value("${accessFile.blockRule}")
    private String[] blockRule;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(blockRule);
        //web.ignoring().antMatchers("/statics/**");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
                http
                /*匿名请求：不需要进行登录拦截的url*/
                .authorizeRequests()
                //.antMatchers("/admin").hasRole("ADMIN")//当用户的角色是为admin时可以访问这个目录
                //.antMatchers("/getUser").hasAuthority("select") //当用户具有select权限时才可以访问这个方法
                .anyRequest().authenticated()//其他的路径都是登录后才可访问
                .and()
                /*登录配置*/
                .formLogin()
                //.loginPage("/statics/Apps/Demos/Viewer/login.html")
                .loginPage("http://localhost:12001/Apps/Demos/Viewer/index.html") //登录页，当未登录时会重定向到该页面
                .successHandler(loginSuccessHandler)   //登录成功处理 `
                .failureHandler(loginFailureHandler)  //登录失败处理
                .loginProcessingUrl("/login")//前端登录请求地址
                .usernameParameter("username")//默认的用户名参数
                .passwordParameter("password")//默认的密码参数
                .permitAll()
                .and()
                /*登出配置*/
                .logout()
                .permitAll()
                .logoutSuccessHandler(customLogoutSuccessHandler) //退出处理
                .and()
                .exceptionHandling()
                .accessDeniedHandler(customAccessDeniedHandler)  //无权限时的处理
                .and()
                .cors() //跨域
                .and()
                //关闭csrf防护，类似于防火墙，不关闭上面的设置不会真正生效。
                .csrf().disable();


    }
    /**
     * 描述: 密码加密算法 BCrypt 推荐使用
     **/
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
