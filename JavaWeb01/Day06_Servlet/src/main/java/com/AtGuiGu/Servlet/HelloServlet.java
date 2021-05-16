package com.AtGuiGu.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/8-23:13
 */

public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1 构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init初始化方法");
        //1. ServletConfig 类从类名上来看，就知道是 Servlet 程序的配置信息类。
        System.out.println("HelloServlet程序的别名是: "+servletConfig.getServletName());
        //2. Servlet 程序和 ServletConfig 对象都是由 Tomcat 负责创建，我们负责使用。
        System.out.println("初始化参数 username的值为: "+servletConfig.getInitParameter("username") );
        System.out.println("初始化参数 url的值为: "+servletConfig.getInitParameter("url") );
        //3. Servlet 程序默认是第一次访问的时候创建，ServletConfig 是每个 Servlet 程序创建时，就创建一个对应的ServletConfig 对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 service方法 Hello Servlet 被访问了");
        //servletRequest --> 转换成子接口 HttpServletRequest 有getMethod方法, 可以获取request的类型(GET || POST)
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取请求的方式
        String method = httpServletRequest.getMethod();

        /**
         * 请求的分发处理
         *  通过在service方法中通过ServletRequest的子接口HttpServletRequest的getMethod方法, 获取请求的类型
         *  判断请求的类型以后调用相应的 get(doGet), post(doPost)请求所需要做的方法
         */
        if("GET".equals(method)){
            doGet();
        }else if("POST".equals(method)){
            doPost();
        }

    }

    /**
     * 做get请求操作
     */
    public void doGet(){
        System.out.println("get请求");
        System.out.println("get请求");
        System.out.println("get请求");
        System.out.println("get请求");
        System.out.println("get请求");
    }

    /**
     * 做post请求操作
     */
    public void doPost(){
        System.out.println("post请求");
        System.out.println("post请求");
        System.out.println("post请求");
        System.out.println("post请求");
        System.out.println("post请求");
    }


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 destroy销毁方法");
    }
}
