package com.example.order.controller;

import com.example.order.common.Constant;
import com.example.order.entity.GSysCompany;
import com.example.order.exception.LoginException;
import com.example.order.service.CompanyService;
import com.example.order.service.ManageService;
import com.example.order.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.order.entity.GSysManage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ManageController
 * @Description 小程序端Controller
 * @Author xionggy
 * @Date 2020/9/10
 * @Version 1.0
 */
@Controller
@RequestMapping("/api/vchart/manage")
public class ManageController {

    protected static final Logger logger = LoggerFactory.getLogger(ManageController.class);

    @Autowired
    ManageService manageService;

    @Autowired
    CompanyService companyService;

    /**
     * 小程序首页轮播图，公告，新闻列表
     * @param type
     * @param searchContent
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    public void getInfo(@RequestParam("type") String type,@RequestParam(value="searchContent",required=false)String searchContent,
                        HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            List<GSysManage> gSysManageList= manageService.getManageList(type,searchContent);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysManageList);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }
    }

    /**
     * 小程序首页轮播图，公告，新闻详细信息
     * @param objId
     * @param type
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    public void getList(@RequestParam("objId") Long objId,
                            @RequestParam("type") String type,
                            HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            GSysManage gSysManage= manageService.getManageInfo(objId,type);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysManage);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }
    }

    /**
     * 小程序单位下拉
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getCompanyList",method = RequestMethod.GET)
    public void getCompanyList(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> res = new HashMap<String, Object>();
        try {
            List<Map<String,Object>> gSysCompany= companyService.getCompanyList();
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysCompany);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }
    }
}
