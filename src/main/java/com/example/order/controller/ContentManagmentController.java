package com.example.order.controller;


import com.example.order.common.Constant;
import com.example.order.entity.GSysContentManagement;
import com.example.order.service.ContentManagementService;
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
 * 轮播图显示Controller
 */
@Controller
@RequestMapping("/api/vchart/banner")
public class ContentManagmentController {
    protected static final Logger logger = LoggerFactory.getLogger(ExhibitionController.class);

    @Autowired
    ContentManagementService contentManagementService;

    @RequestMapping(value = "/getBannerList", method = RequestMethod.GET)
    public void getBannerList(HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> res = new HashMap<String, Object>();
        //显示所有轮播图
        List<GSysContentManagement> bannerList = contentManagementService.getBannerList();
        res.put(Constant.RESPONSE_DATA, bannerList);
        res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
        ServletUtils.writeToResponse(response, res);

    }

    @RequestMapping(value = "/getBannerInfo", method = RequestMethod.GET)
    public void getBannerInfo(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam("contentId") Long contentId) {

        Map<String, Object> res = new HashMap<String, Object>();
        //轮播图详情展示
        GSysContentManagement gSysContentManagement = contentManagementService.getBannerInfo(contentId);

        res.put(Constant.RESPONSE_DATA, gSysContentManagement);
        res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
        ServletUtils.writeToResponse(response, res);

    }

}
