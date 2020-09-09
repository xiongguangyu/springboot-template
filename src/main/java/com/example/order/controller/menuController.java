package com.example.order.controller;

import com.example.order.common.Constant;

import com.example.order.entity.GSysMenu;
import com.example.order.exception.LoginException;
import com.example.order.service.LoginService;
import com.example.order.service.menuService;
import com.example.order.utils.ServletUtils;
import com.example.order.utils.TokenUtil;
import com.example.order.vo.ValidateCodeVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description 菜单Controller
 * @Author xionggy
 * @Date 2020/8/27
 * @Version 1.0
 */
@Controller
//@CrossOrigin(origins = { "*" }, allowedHeaders = { "*" }, allowCredentials = "true", methods = { RequestMethod.POST })
@RequestMapping("/api/menu")
public class menuController {

    protected static final Logger logger = LoggerFactory.getLogger(menuController.class);

    @Autowired
    menuService menuService;

    @Value("${sysPara.isTest}")
    private String isTest;




    @RequestMapping(value = "/doDelete",method = RequestMethod.POST)
    public void testLogin(@RequestParam("menuId") String menuId,
                          @RequestParam(value = "loginCode",required = false) String loginCode,
                          HttpServletRequest request, HttpServletResponse response){

        Map<String, Object> res = new HashMap<String, Object>();

        try {
            Boolean gSysUser = menuService.doUpdate(menuId);
           if(gSysUser){
               //res.put(Constant.RESPONSE_DATA, gSysUser);
               res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
               res.put(Constant.RESPONSE_CODE_MSG, "删除成功!");
           }else {
               //res.put(Constant.RESPONSE_DATA, gSysUser);
               res.put(Constant.RESPONSE_CODE, Constant.OTHER_CODE_VALUE);
               res.put(Constant.RESPONSE_CODE_MSG, "删除失败!");
           }
           // res.put(Constant.RESPONSE_DATA, gSysUser);
            ServletUtils.writeToResponse(response, res);
        } catch (LoginException e) {
            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
            ServletUtils.writeToResponse(response, res);
        }

    }
    @RequestMapping(value = "/getMenuByMenuId",method = RequestMethod.POST)
    public void getMenus(HttpServletRequest request, HttpServletResponse response,
                         @RequestParam("menuId") String menuId){
        Map<String, Object> res = new HashMap<String, Object>();
        List<GSysMenu> menus = menuService.getMenuByMenuId(menuId);
        GSysMenu menu =  new GSysMenu();
        for (int i = 0; i < menus.size(); i++) {
            menu = menus.get(0);
        }
        res.put(Constant.RESPONSE_DATA, menu);
        res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
        ServletUtils.writeToResponse(response,res);
    }

//    @RequestMapping(value = "/doUpdate",method = RequestMethod.POST)
//    public void testLogin(@RequestParam("menuId") String menuId,
//                          @RequestParam(value = "loginCode",required = false) String loginCode,
//                          HttpServletRequest request, HttpServletResponse response){
//
//        Map<String, Object> res = new HashMap<String, Object>();
//
//        try {
//            Boolean gSysUser = menuService.doUpdate(menuId);
//            if(gSysUser){
//                //res.put(Constant.RESPONSE_DATA, gSysUser);
//                res.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
//                res.put(Constant.RESPONSE_CODE_MSG, "删除成功!");
//            }else {
//                //res.put(Constant.RESPONSE_DATA, gSysUser);
//                res.put(Constant.RESPONSE_CODE, Constant.OTHER_CODE_VALUE);
//                res.put(Constant.RESPONSE_CODE_MSG, "删除失败!");
//            }
//            // res.put(Constant.RESPONSE_DATA, gSysUser);
//            ServletUtils.writeToResponse(response, res);
//        } catch (LoginException e) {
//            res.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
//            res.put(Constant.RESPONSE_CODE_MSG, e.getMessage());
//            ServletUtils.writeToResponse(response, res);
//        }
//
//    }

}
