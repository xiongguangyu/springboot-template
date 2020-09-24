package com.example.order.mapper;
import com.example.order.entity.GSysUser;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface GSysUserMapper {

    int insertSelective(GSysUser record);

    GSysUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(GSysUser record);

    GSysUser loginUser(String loginName);

    void updateCompanyUserStatus(GSysUser gSysUser);

}
