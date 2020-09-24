package com.example.order.controller;

import com.example.order.common.Constant;
import com.example.order.entity.GSysFirstMaintenance;
import com.example.order.exception.LoginException;
import com.example.order.service.FirstMaintenanceService;
import com.example.order.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ConsumerController
 * @Description 用户管理
 * @Author ShiYJ
 * @Date 2020/9/23
 * @Version 1.0
 */
@Controller
@RequestMapping("/api/firstMaintenance")
public class FirstMaintenanceController {

    protected static final Logger logger = LoggerFactory.getLogger(FirstMaintenanceController.class);

    @Autowired
    FirstMaintenanceService firstMaintenanceService;



    @RequestMapping(value = "/getfirstMaintenance",method = RequestMethod.POST)
    public void getfirstMaintenance(@RequestParam("type") String type,
                        HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            List<GSysFirstMaintenance> gSysFirstMaintenance= firstMaintenanceService.getfirstMaintenance(type);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysFirstMaintenance);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }
    }


}
