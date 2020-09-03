package com.example.order;

import com.example.order.entity.GSysMenu;
import com.example.order.entity.GSysUser;
import com.example.order.mapper.GSysMenuMapper;
import com.example.order.service.ExhibitionService;
import com.example.order.service.TestService;
import com.example.order.service.UserService;
import com.example.order.utils.TokenUtil;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderApplicationTests {

    @Autowired
    TestService testService;

    @Autowired
    UserService userService;

    @Autowired
    private GSysMenuMapper gSysMenuMapper;

    @Autowired
    ExhibitionService exhibitionService;

    @Value("${sysPara.isTest}")
    private String isTest;

    @Test
    public void contextLoads() {
        System.out.println();
    }

    @Test
    public void sing(){
        GSysUser gSysUser = new GSysUser();
        gSysUser.setLoginName("155655");
        gSysUser.setPassword("123123");
        String sign = TokenUtil.sign(gSysUser);

        boolean verify = TokenUtil.verify(sign);

        System.out.println(sign);
        System.out.println(verify);
    }

    @Test
    public void test1(){
        Long userId = 5L;
        System.out.println(isTest);
    }

    @Test
    public void test2(){
        exhibitionService.addRich("<p>欢迎使用 <b>wangEdito牛博你OK</b></p><p><b>缪不i就</b></p>",1);
        System.out.println();

    }

}
