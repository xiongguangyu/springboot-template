package com.example.order.mapper;

import com.example.order.entity.GSysMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GSysMenuMapper {

    int insertSelective(GSysMenu record);

    GSysMenu selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(GSysMenu record);

    /**
     * 获取所有菜单
     * @return list
     */
    List<GSysMenu> getMenuListForUserId(@Param("userId") Long userId);

    /**
     * 获取所有菜单
     * @return list
     */
    List<GSysMenu> getMenuListForParentId(@Param("parentId") Long parentId);

}
