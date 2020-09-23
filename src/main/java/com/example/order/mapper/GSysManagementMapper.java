package com.example.order.mapper;


import com.example.order.entity.GSysManagement;

import java.util.List;

public interface GSysManagementMapper {

    GSysManagement getroleList(String consumerId);

    List<GSysManagement> getInformation(String type);

    int insertSelective(GSysManagement gSysManagement);

    int deleteByPrimaryKey(String consumerId);

    void updateroleList(GSysManagement gSysManagement);
}