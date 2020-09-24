package com.example.order.controller;

import com.example.order.common.Constant;
import com.example.order.entity.GSysManager;
import com.example.order.exception.LoginException;
import com.example.order.service.ManagerService;
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
@RequestMapping("/api/manager")
public class ManagerController {

    protected static final Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    ManagerService managerService;


    /**
     * 查询客户经理
     * @param type
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getManagerList",method = RequestMethod.POST)
    public void getManagerList(@RequestParam("type") String type,
                               HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            List<GSysManager> gSysManagement= managerService.getManagerList(type);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysManagement);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }

    }

    /**
     * 新增客户经理
     * @param gSysManager
     * @param request
     * @param response
     */
    @RequestMapping(value = "/addManger",method = RequestMethod.POST)
    public void addManger(@RequestBody GSysManager gSysManager,
                            HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            managerService.addManger(gSysManager);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作成功!");
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作失败!");
            ServletUtils.writeToResponse(response,res);
        }

    }

    /**
     * 删除
     * @param managerId
     * @param request
     * @param response
     */
    @RequestMapping(value = "/deleteManger",method = RequestMethod.POST)
    public void deleteManger(@RequestParam("managerId") String managerId,
                                 HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            managerService.deleteManger(managerId);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作成功!");
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作失败!");
            ServletUtils.writeToResponse(response,res);
        }
    }

    /**
     * 修改
     * @param managerId
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getManger",method = RequestMethod.POST)
    public void getManger(@RequestParam("managerId") String managerId,
                        HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            GSysManager gSysManager= managerService.getManger(managerId);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysManager);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }

    }

    @RequestMapping(value = "/updateManger",method = RequestMethod.POST)
    public void updateManger(@RequestBody GSysManager gSysManager,
                           HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            managerService.updateManger(gSysManager);
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