package org.flow.controller;
import javax.annotation.Resource;

import org.flow.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController{
    @Resource
    private UserService userService ;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object list() { // 通过model可以实现内容的传递
        return this.userService.findAll() ;
    }
}
