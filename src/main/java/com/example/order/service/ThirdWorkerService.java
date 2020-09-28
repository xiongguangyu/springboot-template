package com.example.order.service;

import com.example.order.entity.GSysThirdWorker;
import com.example.order.exception.AddUserException;

import java.util.List;

public interface ThirdWorkerService {

    /**
     * 用户管理
     * @param type type
     * @return
     */
    List<GSysThirdWorker> getThirdWorker(String type);

    void deleteThirdWorker(String workerId);

    void addThirdWorker(GSysThirdWorker gSysThirdWorker)  throws AddUserException;

    GSysThirdWorker getWorker(String workerId);

    void updateThirdWorker(GSysThirdWorker gSysThirdWorker);
}
