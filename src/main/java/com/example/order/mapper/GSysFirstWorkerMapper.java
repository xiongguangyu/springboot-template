package com.example.order.mapper;


import com.example.order.entity.GSysFirstWorker;
import com.example.order.entity.GSysOwner;

import java.util.List;

public interface GSysFirstWorkerMapper {


    List<GSysFirstWorker> getFirstWorker(String type);

    void deleteFirstWorker(String workerId);

    int addFirstWorker(GSysFirstWorker gSysFirstWorker);

    GSysFirstWorker getWorker(String workerId);

    void updateFirstWorker(GSysFirstWorker gSysFirstWorker);
}