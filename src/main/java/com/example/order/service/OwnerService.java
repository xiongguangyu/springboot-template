package com.example.order.service;

import com.example.order.entity.GSysOwner;
import com.example.order.exception.AddUserException;

import java.util.List;

public interface OwnerService {

    /**
     * 用户管理
     * @param type type
     * @return
     */
    List<GSysOwner> getOwnerList(String type);

    void addOwner(GSysOwner gSysOwner)  throws AddUserException;

    void deleteConsumer(String ownerId);

    GSysOwner updateInfo(String ownerId);

    void updateInformation(GSysOwner gSysOwner);

}
