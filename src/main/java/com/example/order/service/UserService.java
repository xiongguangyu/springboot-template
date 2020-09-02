package com.example.order.service;

import com.example.order.entity.GSysMenu;
import com.example.order.exception.AddUserException;
import com.example.order.request.AddUserRequestParam;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 获取所有菜单
     * @return list
     */
    Map<String,Object> getMenuList(Long userId);

    void addUser(AddUserRequestParam addUserRequestParam) throws AddUserException;

}
