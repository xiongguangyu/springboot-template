package com.example.order.controller;

import com.example.order.common.Constant;
import com.example.order.entity.GSysFirstWorker;
import com.example.order.entity.GSysOwner;
import com.example.order.exception.LoginException;
import com.example.order.service.FirstWorkerService;
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
 * @ClassName ConsumerController
 * @Description 用户管理
 * @Author ShiYJ
 * @Date 2020/9/23
 * @Version 1.0
 */
@Controller
@RequestMapping("/api/firstWorker")
public class FirstWorkerController {

    protected static final Logger logger = LoggerFactory.getLogger(FirstWorkerController.class);

    @Autowired
    FirstWorkerService firstWorkerService;


    /**
     * 查询
     * @param type
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getFirstWorker",method = RequestMethod.POST)
    public void getFirstWorker(@RequestParam("type") String type,
                        HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            List<GSysFirstWorker> gSysFirstWorkers= firstWorkerService.getFirstWorker(type);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysFirstWorkers);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }
    }

    /**
     * 新增
     * @param gSysFirstWorker
     * @param request
     * @param response
     */
    @RequestMapping(value = "/addFirstWorker",method = RequestMethod.POST)
    public void addFirstWorker(@RequestBody GSysFirstWorker gSysFirstWorker,
                         HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            firstWorkerService.addFirstWorker(gSysFirstWorker);
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
     * @param workerId
     * @param request
     * @param response
     */
    @RequestMapping(value = "/deleteFirstWorker",method = RequestMethod.POST)
    public void deleteFirstWorker(@RequestParam("workerId") String workerId,
                            HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            firstWorkerService.deleteFirstWorker(workerId);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作成功!");
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作失败!");
            ServletUtils.writeToResponse(response,res);
        }
    }

    @RequestMapping(value = "/getWorker",method = RequestMethod.POST)
    public void getWorker(@RequestParam("workerId") String workerId,
                         HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            GSysFirstWorker gSysFirstWorker= firstWorkerService.getWorker(workerId);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysFirstWorker);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }

    }

    @RequestMapping(value = "/updateFirstWorker",method = RequestMethod.POST)
    public void updateFirstWorker(@RequestBody GSysFirstWorker gSysFirstWorker,
                            HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            firstWorkerService.updateFirstWorker(gSysFirstWorker);
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
