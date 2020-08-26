package com.example.order.service.impl;

import com.example.order.entity.GSysMenu;
import com.example.order.entity.GSysUser;
import com.example.order.exception.AddUserException;
import com.example.order.mapper.GSysMenuMapper;
import com.example.order.mapper.GSysUserMapper;
import com.example.order.request.AddUserRequestParam;
import com.example.order.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    protected static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Value("${syspara.defaultPassWord}")
    private String defaultPassWord;

    @Autowired
    private GSysMenuMapper gSysMenuMapper;

    @Autowired
    private GSysUserMapper gSysUserMapper;

    @Override
    public List<GSysMenu> getMenuList() {
        return gSysMenuMapper.getMenuList();
    }

    @Override
    public void addUser(AddUserRequestParam addUserRequestParam) throws AddUserException{
        GSysUser gSysUser = new GSysUser();
        gSysUser.setLoginName(addUserRequestParam.getUsername());
        gSysUser.setPassword(defaultPassWord);
        gSysUser.setStatus("1");
        gSysUser.setCreateTime(new Date());
        gSysUser.setWechatOpenid(addUserRequestParam.getWechatOpenId());
        gSysUser.setRole(addUserRequestParam.getMenus());
        try {
            gSysUserMapper.insertSelective(gSysUser);
        } catch (Exception e) {
            logger.error("新增用户失败!");
            throw new AddUserException("新增用户失败");
        }

    }
}
