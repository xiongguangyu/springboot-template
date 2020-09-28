package com.example.order.mapper;


import com.example.order.entity.GSysThirdWorker;

import java.util.List;

public interface GSysThirdWorkerMapper {


    List<GSysThirdWorker> getThirdWorker(String type);

    void deleteThirdWorker(String workerId);

    int addThirdWorker(GSysThirdWorker gSysThirdWorker);

    GSysThirdWorker getWorker(String workerId);

    void updateThirdWorker(GSysThirdWorker gSysThirdWorker);
}