package com.example.order.service;

import com.example.order.entity.GSysUser;

public interface LoginService {

    /**
     * 用户登录
     * @param username 用户名
     * @param password 用户登录密码
     * @return
     */
    GSysUser doLogin(String username, String password);
}
