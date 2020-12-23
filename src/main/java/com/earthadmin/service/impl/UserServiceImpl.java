package com.earthadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.earthadmin.dto.ResultEntity;
import com.earthadmin.domain.entity.User;
import com.earthadmin.mapper.UserMapper;
import com.earthadmin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lanxifang
 * @date 2020/12/21 16:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
//
//    /**
//     *
//     * @param name
//     * @param password
//     * @return
//     */
//    @Override
//    public ResultEntity loginUser(String name, String password) {
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("name",name);
//        User user = userMapper.selectOne(wrapper);
//
//        if(user.getPassword().equals(password)){
//            return ResultEntity.success();
//        }
//        return ResultEntity.error();
//    }

    @Override
    public User selectUserByUserName(String username) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name",username);
        return userMapper.selectOne(wrapper);
    }
}
