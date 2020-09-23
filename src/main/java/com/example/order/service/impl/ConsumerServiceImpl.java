package com.example.order.service.impl;


import com.example.order.common.Constant;
import com.example.order.entity.GSysConsumer;
import com.example.order.entity.GSysManagement;
import com.example.order.exception.AddUserException;
import com.example.order.exception.LoginException;
import com.example.order.mapper.GSysConsumerMapper;
import com.example.order.mapper.GSysManagementMapper;
import com.example.order.service.ConsumerService;
import com.example.order.utils.ServletUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    protected static final Logger logger = LoggerFactory.getLogger(ConsumerServiceImpl.class);

    @Autowired
    private GSysConsumerMapper gSysConsumerMapper;


    @Override
    public List<GSysConsumer> getList(String type) {
        return gSysConsumerMapper.getList(type);
    }

    @Override
    public void addconsumerList(GSysConsumer gSysConsumer) throws AddUserException {
        try {
            gSysConsumerMapper.insert(gSysConsumer);
        } catch (Exception e) {
            logger.error("新增失败!");
            throw new AddUserException("新增失败");
        }
    }


    @Override
    public void deleteConsumer(String consumerId) {
        try {
            gSysConsumerMapper.updateConsumer(consumerId);
        } catch (Exception e) {
            logger.error("修改失败!");
            throw new AddUserException("修改失败");
        }
    }


    @Override
    public GSysConsumer updateInfo(@Param("consumerId")String consumerId) {
        return gSysConsumerMapper.updateInfo(consumerId);

    }

    @Override
    public void updateInformation(GSysConsumer gSysConsumer) throws AddUserException {
        try {
            gSysConsumerMapper.updateInformation(gSysConsumer);
        } catch (Exception e) {
            logger.error("修改失败!");
            throw new AddUserException("修改失败");
        }
    }
}
