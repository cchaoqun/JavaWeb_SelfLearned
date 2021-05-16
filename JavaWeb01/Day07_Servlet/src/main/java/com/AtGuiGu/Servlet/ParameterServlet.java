package com.AtGuiGu.Servlet;




import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/9-18:33
 */

public class ParameterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------doGet---------");
        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");

        System.out.println("用户名: "+username);
        System.out.println("密码: "+password);
        System.out.println("兴趣爱好: "+ Arrays.asList(hobby));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求体的字符集为UTF-8, 从而解决post请求的中文乱码问题
        //也要在获取请求参数之前调用才有效
        req.setCharacterEncoding("UTF-8");
        System.out.println("-------doPost---------");
        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");

        System.out.println("用户名: "+username);
        System.out.println("密码: "+password);
        System.out.println("兴趣爱好: "+ Arrays.asList(hobby));
    }
}
