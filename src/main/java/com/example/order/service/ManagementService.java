package com.example.order.service;

import com.example.order.entity.GSysManage;
import com.example.order.entity.GSysManagement;
import com.example.order.exception.AddUserException;

import java.util.List;

public interface ManagementService {

    /**
     * 公告，新闻，轮播图
     * @param type type
     * @return
     */
    List<GSysManagement> getInformation(String type);

    void addInfo(GSysManagement gSysManagement)  throws AddUserException;

    void doDeleteconsumer(String roleId);

    GSysManagement getroleList(String roleId);

    void updateroleList(GSysManagement gSysManagement);


}
