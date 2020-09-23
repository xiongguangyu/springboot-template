package com.example.order.mapper;


import com.example.order.entity.GSysConsumer;
import com.example.order.entity.GSysManagement;

import java.util.List;

public interface GSysConsumerMapper {


    List<GSysConsumer> getList(String type);

    int insert(GSysConsumer gSysConsumer);

    void updateConsumer(String consumerId);

    GSysConsumer updateInfo(String consumerId);

    void updateInformation(GSysConsumer gSysConsumer);

}