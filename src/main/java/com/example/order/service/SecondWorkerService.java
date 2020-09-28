package com.example.order.service;

import com.example.order.entity.GSysFirstWorker;
import com.example.order.entity.GSysSecondWorker;
import com.example.order.exception.AddUserException;

import java.util.List;

public interface SecondWorkerService {

    /**
     * 用户管理
     * @param type type
     * @return
     */
    List<GSysSecondWorker> getSecondWorker(String type);

    void deleteSecondWorker(String workerId);

    void addSecondWorker(GSysSecondWorker gSysSecondWorker)  throws AddUserException;

    GSysSecondWorker getWorker(String workerId);

    void updateSecondWorker(GSysSecondWorker gSysSecondWorker);
}
