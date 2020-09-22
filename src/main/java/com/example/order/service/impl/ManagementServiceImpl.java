package com.example.order.service.impl;

import com.example.order.entity.GSysManage;
import com.example.order.entity.GSysManagement;
import com.example.order.exception.AddUserException;
import com.example.order.mapper.GSysManageMapper;
import com.example.order.mapper.GSysManagementMapper;
import com.example.order.service.ManageService;
import com.example.order.service.ManagementService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementServiceImpl implements ManagementService {

    protected static final Logger logger = LoggerFactory.getLogger(ManagementServiceImpl.class);

    @Autowired
    private GSysManagementMapper GSysManagementMapper;


    @Override
    public List<GSysManagement> getInformation(String type) {
        return GSysManagementMapper.getInformation(type);

    }
    @Override
    public void addInfo(GSysManagement gSysManagement) throws AddUserException {
        try {
            GSysManagementMapper.insertSelective(gSysManagement);
        } catch (Exception e) {
            logger.error("新增失败!");
            throw new AddUserException("新增失败");
        }
    }


}
