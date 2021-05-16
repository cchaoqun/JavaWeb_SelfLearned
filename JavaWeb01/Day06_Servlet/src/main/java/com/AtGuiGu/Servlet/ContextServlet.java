package com.AtGuiGu.Servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/9-16:33
 */

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取 web.xml 中配置的上下文参数 context-param
        ServletContext servletContext = getServletConfig().getServletContext();
        String username = servletContext.getInitParameter("username");
        String password = servletContext.getInitParameter("password");
        System.out.println("context-param参数username的值是: "+username);
        System.out.println("context-param参数password的值是: "+password);

        //获取当前的工程路径，格式: /工程路径
        System.out.println("当前工程路径: "+servletContext.getContextPath());
        /**
         *  / 斜杠被服务器解析地址为:http://ip:port/工程名/  映射到IDEA代码的web目录<br/>
         */
        System.out.println("工程部署的路径是: : "+servletContext.getRealPath("/"));
        System.out.println("工程下css目录的绝对路径是: "+servletContext.getRealPath("/css"));
        System.out.println("工程下imgs目录1.jpg的绝对路径是: "+servletContext.getRealPath("/imgs/1.jpg"));
        //获取工程部署后在服务器硬盘上的绝对路径

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
