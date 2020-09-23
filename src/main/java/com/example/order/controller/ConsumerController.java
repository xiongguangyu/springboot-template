package com.example.order.controller;

import com.example.order.common.Constant;
import com.example.order.entity.GSysConsumer;
import com.example.order.entity.GSysManagement;
import com.example.order.exception.LoginException;
import com.example.order.service.ConsumerService;
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
@RequestMapping("/api/consumer")
public class ConsumerController {

    protected static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    ConsumerService consumerService;



    @RequestMapping(value = "/getList",method = RequestMethod.POST)
    public void getList(@RequestParam("type") String type,
                        HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            List<GSysConsumer> gSysConsumer= consumerService.getList(type);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysConsumer);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }
    }

    @RequestMapping(value = "/addconsumerList",method = RequestMethod.POST)
    public void addconsumerList(@RequestBody GSysConsumer gSysConsumer,
                            HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            consumerService.addconsumerList(gSysConsumer);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作成功!");
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作失败!");
            ServletUtils.writeToResponse(response,res);
        }

    }

    @RequestMapping(value = "/deleteConsumer",method = RequestMethod.POST)
    public void deleteConsumer(@RequestParam("consumerId") String consumerId,
                               HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            consumerService.deleteConsumer(consumerId);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作成功!");
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作失败!");
            ServletUtils.writeToResponse(response,res);
        }
    }

    @RequestMapping(value = "/updateInfo",method = RequestMethod.POST)
    public void updateInfo(@RequestParam("consumerId") String consumerId,
                            HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            GSysConsumer gSysConsumer= consumerService.updateInfo(consumerId);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysConsumer);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }

    }

    @RequestMapping(value = "/updateInformation",method = RequestMethod.POST)
    public void updateInformation(@RequestBody GSysConsumer gSysConsumer,
                               HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            consumerService.updateInformation(gSysConsumer);
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
