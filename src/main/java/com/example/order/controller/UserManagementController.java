package com.example.order.controller;

import com.example.order.common.Constant;
import com.example.order.entity.GSysCompany;
import com.example.order.entity.GSysManage;
import com.example.order.entity.GSysManagement;
import com.example.order.exception.LoginException;
import com.example.order.service.ManagementService;
import com.example.order.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserManagementController
 * @Description 客户经理管理
 * @Author ShiYJ
 * @Date 2020/9/22
 * @Version 1.0
 */
@Controller
@RequestMapping("/api/management")
public class UserManagementController {

    protected static final Logger logger = LoggerFactory.getLogger(UserManagementController.class);

    @Autowired
    ManagementService managementService;

    @RequestMapping(value = "/getroleList",method = RequestMethod.POST)
    public void getroleList(@RequestParam("consumerId") String consumerId,
                        HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            GSysManagement gSysManagement= managementService.getroleList(consumerId);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysManagement);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }

    }

    @RequestMapping(value = "/getInformation",method = RequestMethod.POST)
    public void getInformation(@RequestParam("type") String type,
                        HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            List<GSysManagement> gSysManagement= managementService.getInformation(type);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysManagement);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }

    }
    @RequestMapping(value = "/addroleList",method = RequestMethod.POST)
    public void addroleList(@RequestBody GSysManagement gSysManagement,
                        HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            managementService.addInfo(gSysManagement);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作成功!");
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作失败!");
            ServletUtils.writeToResponse(response,res);
        }

    }

    @RequestMapping(value = "/doDeleteconsumer",method = RequestMethod.POST)
    public void doDeleteconsumer(@RequestParam("consumerId") String consumerId,
                         HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            managementService.doDeleteconsumer(consumerId);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作成功!");
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作失败!");
            ServletUtils.writeToResponse(response,res);
        }
    }

    @RequestMapping(value = "/updateroleList",method = RequestMethod.POST)
    public void updateroleList(@RequestBody GSysManagement gSysManagement,
                           HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            managementService.updateroleList(gSysManagement);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作成功!");
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作失败!");
            ServletUtils.writeToResponse(response,res);
        }

    }
}
