package com.example.order.service;

import com.example.order.entity.GSysMenu;

import java.util.List;

public interface MenuService {

    /**
     * 用户登录
     * @param menuId 菜单id
     * @return
     */
    boolean doUpdate(String menuId);

    List<GSysMenu> getMenuByMenuId(String menuId);
}
