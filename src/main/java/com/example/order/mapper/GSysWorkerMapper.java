package com.example.order.mapper;


import com.example.order.entity.GSysWorker;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GSysWorkerMapper {

    GSysWorker selectByPrimaryKey(Long workerId);

    GSysWorker workerLogin(String loginName);

}
