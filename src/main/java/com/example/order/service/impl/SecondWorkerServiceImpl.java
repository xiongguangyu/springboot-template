package com.example.order.service.impl;


import com.example.order.entity.GSysFirstWorker;
import com.example.order.entity.GSysSecondWorker;
import com.example.order.exception.AddUserException;
import com.example.order.mapper.GSysFirstWorkerMapper;
import com.example.order.mapper.GSysSecondWorkerMapper;
import com.example.order.service.FirstWorkerService;
import com.example.order.service.SecondWorkerService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecondWorkerServiceImpl implements SecondWorkerService {

    protected static final Logger logger = LoggerFactory.getLogger(SecondWorkerServiceImpl.class);

    @Autowired
    private GSysSecondWorkerMapper gSysSecondWorkerMapper;


    @Override
    public List<GSysSecondWorker> getSecondWorker(String type) {
        return gSysSecondWorkerMapper.getSecondWorker(type);
    }

    @Override
    public void addSecondWorker(GSysSecondWorker gSysSecondWorker) throws AddUserException {
        try {
            gSysSecondWorkerMapper.addSecondWorker(gSysSecondWorker);
        } catch (Exception e) {
            logger.error("新增失败!");
            throw new AddUserException("新增失败");
        }
    }

    @Override
    public void deleteSecondWorker(String workerId) {
        try {
            gSysSecondWorkerMapper.deleteSecondWorker(workerId);
        } catch (Exception e) {
            logger.error("修改失败!");
            throw new AddUserException("修改失败");
        }
    }

    @Override
    public GSysSecondWorker getWorker(@Param("workerId")String workerId) {
        return gSysSecondWorkerMapper.getWorker(workerId);

    }

    @Override
    public void updateSecondWorker(GSysSecondWorker gSysSecondWorker) throws AddUserException {
        try {
            gSysSecondWorkerMapper.updateSecondWorker(gSysSecondWorker);
        } catch (Exception e) {
            logger.error("修改失败!");
            throw new AddUserException("修改失败");
        }
    }

}
