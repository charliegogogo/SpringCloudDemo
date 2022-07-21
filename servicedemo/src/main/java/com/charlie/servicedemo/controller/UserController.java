package com.charlie.servicedemo.controller;

import com.charlie.servicedemo.model.entity.User;
import com.charlie.servicedemo.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author charlie
 * @since 2022-07-19
 */
@RestController
@RequestMapping("/charlie/user")
public class UserController {

    @Resource
    private IUserService iUserService;

    @GetMapping("/test")
    public void test() {
        User user = new User();
        user.setName("王老五");
        iUserService.save(user);
    }

}
