package org.flow;

import javax.annotation.Resource;

import org.flow.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = SpringBootMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestUserService {
    @Resource
    private UserService userService;
    @Test
    public void testList() throws Exception {
        System.out.println(this.userService.findAll());
    }
}
