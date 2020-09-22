package com.example.order.mapper;

import com.example.order.entity.GSysManage;
import com.example.order.entity.GSysManagement;

import java.util.List;

public interface GSysManagementMapper {

    List<GSysManagement> getInformation(String type);

    int insertSelective(GSysManagement gSysManagement);

}