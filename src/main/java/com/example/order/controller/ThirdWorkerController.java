package com.example.order.controller;

import com.example.order.common.Constant;
import com.example.order.entity.GSysThirdWorker;
import com.example.order.exception.LoginException;
import com.example.order.service.ThirdWorkerService;
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
@RequestMapping("/api/thirdWorker")
public class ThirdWorkerController {

    protected static final Logger logger = LoggerFactory.getLogger(ThirdWorkerController.class);

    @Autowired
    ThirdWorkerService thirdWorkerService;


    /**
     * 查询
     * @param type
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getThirdWorker",method = RequestMethod.POST)
    public void getThirdWorker(@RequestParam("type") String type,
                        HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            List<GSysThirdWorker> gSysThirdWorkers= thirdWorkerService.getThirdWorker(type);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysThirdWorkers);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }
    }

    /**
     * 新增
     * @param gSysThirdWorker
     * @param request
     * @param response
     */
    @RequestMapping(value = "/addThirdWorker",method = RequestMethod.POST)
    public void addThirdWorker(@RequestBody GSysThirdWorker gSysThirdWorker,
                         HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            thirdWorkerService.addThirdWorker(gSysThirdWorker);
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
    @RequestMapping(value = "/deleteThirdWorker",method = RequestMethod.POST)
    public void deleteThirdWorker(@RequestParam("workerId") String workerId,
                            HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            thirdWorkerService.deleteThirdWorker(workerId);
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
            GSysThirdWorker gSysThirdWorker= thirdWorkerService.getWorker(workerId);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysThirdWorker);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }

    }

    @RequestMapping(value = "/updateThirdWorker",method = RequestMethod.POST)
    public void updateThirdWorker(@RequestBody GSysThirdWorker gSysThirdWorker,
                            HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            thirdWorkerService.updateThirdWorker(gSysThirdWorker);
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
