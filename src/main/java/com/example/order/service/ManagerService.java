package com.example.order.service;

import com.example.order.entity.GSysManager;
import com.example.order.exception.AddUserException;

import java.util.List;

public interface ManagerService {

    /**
     * 公告，新闻，轮播图
     * @param type type
     * @return
     */
    List<GSysManager> getManagerList(String type);

    void addManger(GSysManager gSysManager)  throws AddUserException;

    void deleteManger(String managerId);

    GSysManager getManger(String managerId);

    void updateManger(GSysManager gSysManager);


}
