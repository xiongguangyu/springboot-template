package com.example.order.service.impl;


import com.example.order.entity.GSysFirstWorker;
import com.example.order.entity.GSysOwner;
import com.example.order.exception.AddUserException;
import com.example.order.mapper.GSysFirstWorkerMapper;
import com.example.order.service.FirstWorkerService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirstWorkerServiceImpl implements FirstWorkerService {

    protected static final Logger logger = LoggerFactory.getLogger(FirstWorkerServiceImpl.class);

    @Autowired
    private GSysFirstWorkerMapper gSysFirstWorkerMapper;


    @Override
    public List<GSysFirstWorker> getFirstWorker(String type) {
        return gSysFirstWorkerMapper.getFirstWorker(type);
    }

    @Override
    public void addFirstWorker(GSysFirstWorker gSysFirstWorker) throws AddUserException {
        try {
            gSysFirstWorkerMapper.addFirstWorker(gSysFirstWorker);
        } catch (Exception e) {
            logger.error("新增失败!");
            throw new AddUserException("新增失败");
        }
    }

    @Override
    public void deleteFirstWorker(String workerId) {
        try {
            gSysFirstWorkerMapper.deleteFirstWorker(workerId);
        } catch (Exception e) {
            logger.error("修改失败!");
            throw new AddUserException("修改失败");
        }
    }

    @Override
    public GSysFirstWorker getWorker(@Param("workerId")String workerId) {
        return gSysFirstWorkerMapper.getWorker(workerId);

    }

    @Override
    public void updateFirstWorker(GSysFirstWorker gSysFirstWorker) throws AddUserException {
        try {
            gSysFirstWorkerMapper.updateFirstWorker(gSysFirstWorker);
        } catch (Exception e) {
            logger.error("修改失败!");
            throw new AddUserException("修改失败");
        }
    }

}
