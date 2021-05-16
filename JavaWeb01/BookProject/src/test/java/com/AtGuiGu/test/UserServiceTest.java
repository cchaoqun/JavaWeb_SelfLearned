package com.AtGuiGu.test;

import com.AtGuiGu.pojo.User;
import com.AtGuiGu.service.UserService;
import com.AtGuiGu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/10-15:58
 */

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null, "admin2", "123", "admin2@qq.com"));
        userService.registUser(new User(null, "admin3", "123", "admin3@qq.com"));
        userService.registUser(new User(null, "admin4", "123", "admin4@qq.com"));

    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "admin2", "123", "admin2@qq.com")));
        System.out.println(userService.login(new User(null, "admin22", "123", "admin2@qq.com")));
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("admin22")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名可以使用");
        }
    }
}