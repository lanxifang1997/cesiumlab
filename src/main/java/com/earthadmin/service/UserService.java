package com.earthadmin.service;

import com.earthadmin.domain.entity.User;

/**
 * @author lanxifang
 * @date 2020/12/21 16:00
 */
public interface UserService {

//    /**
//     *
//     * @param name
//     * @param password
//     * @return
//     */
//    ResultEntity loginUser(String name, String password);

    /**
     *
     * @param username
     * @return
     */
    User selectUserByUserName(String username);
}
