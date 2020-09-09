package com.example.order.controller;

import com.example.order.common.Constant;
import com.example.order.entity.GSysAnnouncementManagement;
import com.example.order.exception.LoginException;
import com.example.order.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.order.service.AnnouncementManagementService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description 公告Controller
 * @Author xionggy
 * @Date 2020/8/27
 * @Version 1.0
 */
@Controller
//@CrossOrigin(origins = { "*" }, allowedHeaders = { "*" }, allowCredentials = "true", methods = { RequestMethod.POST })
@RequestMapping("/api/announcement")
public class AnnouncementController {

    protected static final Logger logger = LoggerFactory.getLogger(AnnouncementController.class);



    @Value("${sysPara.isTest}")
    private String isTest;

    @Autowired
    AnnouncementManagementService announcement;


    @RequestMapping(value = "/getAnnouncementInfo",method = RequestMethod.GET)
    public void testLogin(@RequestParam(value = "announcementId") Long announcementId,
                          HttpServletRequest request, HttpServletResponse response){

        Map<String, Object> res = new HashMap<String, Object>();
        try {
            GSysAnnouncementManagement gSysAnnouncementManagement= announcement.getAnnouncementInfo(announcementId);
            res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
            res.put(Constant.RESPONSE_DATA, gSysAnnouncementManagement);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }

    }

}
