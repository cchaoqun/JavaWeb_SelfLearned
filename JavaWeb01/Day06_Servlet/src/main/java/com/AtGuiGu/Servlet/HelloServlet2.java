package com.AtGuiGu.Servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/9-14:57
 */

public class HelloServlet2 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        //重写了init方法一定要调用父类的init(config)
        super.init(config);
        System.out.println("重写了init初始化方法做了一些工作");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2 的 doGet方法");

        //每个servlet都有自己对于的ServletConfig对象, 但是不同的Servlet对于的config不同
        ServletConfig servletConfig = getServletConfig();
        System.out.println("初始化参数 username的值为: "+servletConfig.getInitParameter("username") );
        System.out.println("初始化参数 url的值为: "+servletConfig.getInitParameter("url") );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2 的 doPost方法");
    }
}
