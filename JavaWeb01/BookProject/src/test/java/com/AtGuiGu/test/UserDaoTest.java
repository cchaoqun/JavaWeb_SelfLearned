package com.AtGuiGu.test;

import com.AtGuiGu.dao.impl.UserDao;
import com.AtGuiGu.dao.impl.UserDaoImpl;
import com.AtGuiGu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/10-15:38
 */

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if(userDao.queryUserByUsername("admin") == null){
            System.out.println("用户名可用!");
        }else{
            System.out.println("用户名已存在!");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("admin1", "admin")==null){
            System.out.println("用户名或密码错误, 登录失败");
        }else{
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"admin1", "123456", "cchaoqun@qq.com")));
    }
}