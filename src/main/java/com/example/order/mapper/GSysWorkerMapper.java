package com.example.order.mapper;


import com.example.order.entity.GSysWorker;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GSysWorkerMapper {

    GSysWorker selectByPrimaryKey(Long workerId);

    GSysWorker workerLogin(String loginName);

    List<GSysWorker> getWorkers(String grade);

    void deleteWorker(String workerId);

    int addWorker(GSysWorker gSysWorker);

    GSysWorker getWorker(String workerId);

    void updateWorker(GSysWorker gSysWorker);

}
