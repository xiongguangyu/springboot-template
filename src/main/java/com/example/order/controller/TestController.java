package com.example.order.controller;

import com.example.order.entity.GSysUser;
import com.example.order.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class TestController {

    @RequestMapping("index")
    public String testOrder(){
        return "index";
    }

}
