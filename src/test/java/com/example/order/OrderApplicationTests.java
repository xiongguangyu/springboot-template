package com.example.order;

import com.example.order.entity.GSysUser;
import com.example.order.service.TestService;
import com.example.order.utils.TokenUtil;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderApplicationTests {

    @Autowired
    TestService testService;

    @Test
    public void contextLoads() {
        testService.doLogin("1556677889","123456");
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
}
