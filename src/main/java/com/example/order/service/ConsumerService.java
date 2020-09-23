package com.example.order.service;

import com.example.order.entity.GSysConsumer;
import com.example.order.entity.GSysManagement;
import com.example.order.exception.AddUserException;

import java.util.List;

public interface ConsumerService {

    /**
     * 用户管理
     * @param type type
     * @return
     */
    List<GSysConsumer> getList(String type);

    void addconsumerList(GSysConsumer gSysConsumer)  throws AddUserException;

    void deleteConsumer(String consumerId);

    GSysConsumer updateInfo(String consumerId);

    void updateInformation(GSysConsumer gSysConsumer);

}
