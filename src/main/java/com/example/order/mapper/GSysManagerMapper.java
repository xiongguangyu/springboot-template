package com.example.order.mapper;


import com.example.order.entity.GSysManager;
import com.example.order.entity.GSysOwner;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GSysManagerMapper {

    List<Map<String, Object>> getManagerList(String type);

    List<Map<String, Object>> getManagerId(@Param("userId") String userId);

    int addManger(GSysManager gSysManagement);

    int deleteManger(String managerId);

    List<Map<String, Object>> getManger(String managerId);

    void updateManger(GSysManager gSysManager);
}