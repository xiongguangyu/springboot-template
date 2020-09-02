package com.example.order.service.impl;

import com.example.order.entity.GSysUser;
import com.example.order.exception.LoginException;
import com.example.order.mapper.GSysUserMapper;
import com.example.order.service.LoginService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    protected static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private GSysUserMapper gSysUserMapper;

    @Override
    public GSysUser doLogin(String username, String password) throws LoginException {
        GSysUser gSysUser = gSysUserMapper.loginUser(username);
        if (gSysUser != null){
            String passwordInDataBase = gSysUser.getPassword();
            //校验密码是否正确
            if (!StringUtils.equals(password,passwordInDataBase)){
                throw new LoginException("用户名或密码错误！");
            }
            //判断该用户状态
            if (StringUtils.equals(gSysUser.getStatus(),"0")){
                throw new LoginException("该用户已被禁用，请联系管理员！");
            }
            return gSysUser;
        }else {

            throw new LoginException("此用户不存在，请确认！！");

        }
    }
}
