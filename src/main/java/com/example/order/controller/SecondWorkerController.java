package com.example.order.controller;

import com.example.order.common.Constant;
import com.example.order.entity.GSysFirstWorker;
import com.example.order.entity.GSysSecondWorker;
import com.example.order.exception.LoginException;
import com.example.order.service.FirstWorkerService;
import com.example.order.service.SecondWorkerService;
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
@RequestMapping("/api/secondWorker")
public class SecondWorkerController {

    protected static final Logger logger = LoggerFactory.getLogger(SecondWorkerController.class);

    @Autowired
    SecondWorkerService secondWorkerService;


    /**
     * 查询
     * @param type
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getSecondWorker",method = RequestMethod.POST)
    public void getSecondWorker(@RequestParam("type") String type,
                        HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            List<GSysSecondWorker> gSysSecondWorkers= secondWorkerService.getSecondWorker(type);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysSecondWorkers);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }
    }

    /**
     * 新增
     * @param gSysSecondWorker
     * @param request
     * @param response
     */
    @RequestMapping(value = "/addSecondWorker",method = RequestMethod.POST)
    public void addSecondWorker(@RequestBody GSysSecondWorker gSysSecondWorker,
                         HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            secondWorkerService.addSecondWorker(gSysSecondWorker);
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
    @RequestMapping(value = "/deleteSecondWorker",method = RequestMethod.POST)
    public void deleteSecondWorker(@RequestParam("workerId") String workerId,
                            HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            secondWorkerService.deleteSecondWorker(workerId);
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
            GSysSecondWorker gSysSecondWorker= secondWorkerService.getWorker(workerId);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysSecondWorker);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }

    }

    @RequestMapping(value = "/updateSecondWorker",method = RequestMethod.POST)
    public void updateSecondWorker(@RequestBody GSysSecondWorker gSysSecondWorker,
                            HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            secondWorkerService.updateSecondWorker(gSysSecondWorker);
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
