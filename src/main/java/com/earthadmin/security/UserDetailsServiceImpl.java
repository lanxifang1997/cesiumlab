package com.earthadmin.security;

import com.earthadmin.domain.entity.User;
import com.earthadmin.domain.model.LoginUser;
import com.earthadmin.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户验证处理
 * @author lanxifang
 * @date 2020/12/22 10:11
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserService userService;
//
//    @Resource
//    private RoleService roleService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.selectUserByUserName(username);
        if (user==null)
        {
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
        return new org.springframework.security.core.userdetails.User(user.getName(),new BCryptPasswordEncoder().encode(user.getPassword()),grantedAuthorities);
    }

    public LoginUser createLoginUser(User user)
    {

        Set<String> perms = new HashSet<String>();
        perms.add("ADMIN");
        // 管理员拥有所有权限
//        if (user.isAdmin())
//        {
//            perms.add("*:*:*");
//        }
//        else
//        {
//            perms.addAll(roleService.selectPermsByUserId(user.getId()));
//        }
        return new LoginUser(perms, user);
    }
}




