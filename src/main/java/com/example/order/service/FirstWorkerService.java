package com.example.order.service;

import com.example.order.entity.GSysFirstWorker;
import com.example.order.entity.GSysOwner;
import com.example.order.exception.AddUserException;

import java.util.List;

public interface FirstWorkerService {

    /**
     * 用户管理
     * @param type type
     * @return
     */
    List<GSysFirstWorker> getFirstWorker(String type);

    void deleteFirstWorker(String workerId);

    void addFirstWorker(GSysFirstWorker gSysFirstWorker)  throws AddUserException;

    GSysFirstWorker getWorker(String workerId);

    void updateFirstWorker(GSysFirstWorker gSysFirstWorker);
}
