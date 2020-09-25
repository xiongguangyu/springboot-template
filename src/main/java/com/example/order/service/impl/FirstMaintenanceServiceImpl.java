package com.example.order.service.impl;


import com.example.order.entity.GSysFirstMaintenance;
import com.example.order.mapper.GSysFirstMaintenanceMapper;
import com.example.order.service.FirstMaintenanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirstMaintenanceServiceImpl implements FirstMaintenanceService {

    protected static final Logger logger = LoggerFactory.getLogger(FirstMaintenanceServiceImpl.class);

    @Autowired
    private GSysFirstMaintenanceMapper gSysFirstMaintenanceMapper;


    @Override
    public List<GSysFirstMaintenance> getfirstMaintenance(String type) {
        return gSysFirstMaintenanceMapper.getfirstMaintenance(type);
    }





}
