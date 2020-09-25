package com.example.order.service;

import com.example.order.entity.GSysUser;

public interface LoginService {

    /**
     * 后台用户登录
     * @param username 用户名
     * @param password 用户登录密码
     * @return
     */
    GSysUser doLogin(String username, String password);

    /**
     * 小程序客户经理登录
     * @param username 用户名
     * @param password 用户登录密码
     * @return
     */
    GSysUser managerLogin(String username, String password);
}
