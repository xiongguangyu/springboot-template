package com.example.order.mapper;


import com.example.order.entity.GSysManager;

import java.util.List;

public interface GSysManagerMapper {

    List<GSysManager> getManagerList(String type);

    int addManger(GSysManager gSysManagement);

    int deleteManger(String managerId);

    GSysManager getManger(String managerId);

    void updateManger(GSysManager gSysManager);
}