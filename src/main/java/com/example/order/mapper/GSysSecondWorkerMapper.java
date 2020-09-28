package com.example.order.mapper;


import com.example.order.entity.GSysSecondWorker;

import java.util.List;

public interface GSysSecondWorkerMapper {


    List<GSysSecondWorker> getSecondWorker(String type);

    void deleteSecondWorker(String workerId);

    int addSecondWorker(GSysSecondWorker gSysSecondWorker);

    GSysSecondWorker getWorker(String workerId);

    void updateSecondWorker(GSysSecondWorker gSysSecondWorker);
}