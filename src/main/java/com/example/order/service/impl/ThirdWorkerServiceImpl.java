package com.example.order.service.impl;


import com.example.order.entity.GSysThirdWorker;
import com.example.order.exception.AddUserException;
import com.example.order.mapper.GSysThirdWorkerMapper;
import com.example.order.service.ThirdWorkerService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThirdWorkerServiceImpl implements ThirdWorkerService {

    protected static final Logger logger = LoggerFactory.getLogger(ThirdWorkerServiceImpl.class);

    @Autowired
    private GSysThirdWorkerMapper gSysThirdWorkerMapper;


    @Override
    public List<GSysThirdWorker> getThirdWorker(String type) {
        return gSysThirdWorkerMapper.getThirdWorker(type);
    }

    @Override
    public void addThirdWorker(GSysThirdWorker gSysThirdWorker) throws AddUserException {
        try {
            gSysThirdWorkerMapper.addThirdWorker(gSysThirdWorker);
        } catch (Exception e) {
            logger.error("新增失败!");
            throw new AddUserException("新增失败");
        }
    }

    @Override
    public void deleteThirdWorker(String workerId) {
        try {
            gSysThirdWorkerMapper.deleteThirdWorker(workerId);
        } catch (Exception e) {
            logger.error("修改失败!");
            throw new AddUserException("修改失败");
        }
    }

    @Override
    public GSysThirdWorker getWorker(@Param("workerId")String workerId) {
        return gSysThirdWorkerMapper.getWorker(workerId);

    }

    @Override
    public void updateThirdWorker(GSysThirdWorker gSysThirdWorker) throws AddUserException {
        try {
            gSysThirdWorkerMapper.updateThirdWorker(gSysThirdWorker);
        } catch (Exception e) {
            logger.error("修改失败!");
            throw new AddUserException("修改失败");
        }
    }

}
