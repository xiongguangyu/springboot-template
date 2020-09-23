package com.example.order.controller;

import com.example.order.common.Constant;
import com.example.order.entity.GSysCompany;
import com.example.order.exception.LoginException;
import com.example.order.service.CompanyService;
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
 * @ClassName PcCompanyController
 * @Description 单位Controller
 * @Author xionggy
 * @Date 2020/9/10
 * @Version 1.0
 */
@Controller
@RequestMapping("/api/company")
public class PcCompanyController {

    protected static final Logger logger = LoggerFactory.getLogger(PcCompanyController.class);

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/getList",method = RequestMethod.POST)
    public void getList(@RequestParam("companyId") Long objId,
                            HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            GSysCompany gSysCompany= companyService.getList(objId);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysCompany);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }

    }

    @RequestMapping(value = "/getInfo",method = RequestMethod.POST)
    public void getInfo(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            List<GSysCompany> gSysCompany= companyService.getInfo();
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysCompany);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }

    }

    @RequestMapping(value = "/addList",method = RequestMethod.POST)
    public void addList(@RequestBody GSysCompany gSysCompany,
                            HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            companyService.addInfo(gSysCompany);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作成功!");
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作失败!");
            ServletUtils.writeToResponse(response,res);
        }

    }

    @RequestMapping(value = "/updateList",method = RequestMethod.POST)
    public void updateList(@RequestBody GSysCompany gSysCompany,
                            HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            companyService.updateList(gSysCompany);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作成功!");
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, "操作失败!");
            ServletUtils.writeToResponse(response,res);
        }

    }
    @RequestMapping(value = "/doDelete",method = RequestMethod.POST)
    public void doDelete(@RequestParam("companyId") String companyId,
                         HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            companyService.doDelete(companyId);
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
