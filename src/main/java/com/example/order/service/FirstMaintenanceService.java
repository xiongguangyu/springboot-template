package com.example.order.service;

import com.example.order.entity.GSysFirstMaintenance;

import java.util.List;

public interface FirstMaintenanceService {

    /**
     * 用户管理
     * @param type type
     * @return
     */
    List<GSysFirstMaintenance> getfirstMaintenance(String type);

}
