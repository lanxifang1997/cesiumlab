package com.earthadmin.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lanxifang
 * @date 2020/12/21 15:20
 */
@Api(tags = "系统:用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

//    @Resource
//    private UserService userService;
//
//    @ApiOperation("用户登录")
//    @PostMapping("/login")
//    public ResultEntity loginUser(String name,String password){
//
//         return userService.loginUser(name,password);
//
//    }

}
