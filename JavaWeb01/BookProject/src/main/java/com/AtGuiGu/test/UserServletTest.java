package com.AtGuiGu.test;

import com.AtGuiGu.web.UserServlet;

import java.lang.reflect.Method;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/12-21:41
 */

public class UserServletTest {


    public void login() {
        System.out.println("这是login()方法调用了");
    }

    public void regist() {
        System.out.println("这是regist()方法调用了");
    }

    public void updateUser() {
        System.out.println("这是updateUser()方法调用了");
    }

    public void updateUserPassword() {
        System.out.println("这是updateUserPassword()方法调用了");
    }

    public static void main(String[] args) {
        String action = "updateUser";
        try {
            //获取action业务鉴别字符串，获取相应的业务 方法反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);
            //调用目标业务 方法
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
