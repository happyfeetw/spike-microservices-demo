package com.spike.demoserviced;

import com.spike.demoserviced.entity.User;
import com.spike.demoserviced.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@SpringBootTest
class DemoServiceDApplicationTests {

    @Resource
    UserService userService;
    @Test
    void contextLoads() {
        User jack = new User();
        jack.setUsername("jack");
        jack.setPassword("jack123");

        User tom = new User();
        tom.setUsername("tom");
        tom.setPassword("tom123");

        User jerry = new User();
        jerry.setUsername("jerry");
        jerry.setPassword("jerry123");

        Long jackId = userService.createUser(jack);



        System.out.println("jack_id = " + jackId);

    }

}
