package com.example.order.mapper;


import com.example.order.entity.GSysOwner;

import java.util.List;

public interface GSysOwnerMapper {


    List<GSysOwner> getOwnerList(String type);

    int addOwner(GSysOwner gSysOwner);

    void updateConsumer(String consumerId);

    GSysOwner updateInfo(String consumerId);

    void updateInformation(GSysOwner gSysConsumer);

}