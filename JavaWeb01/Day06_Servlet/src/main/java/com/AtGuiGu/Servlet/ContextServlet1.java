package com.AtGuiGu.Servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/9-16:56
 */

public class ContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取servletcontext对象
        ServletContext context1 = getServletContext();
        System.out.println(context1);
        System.out.println("保存之前: conetx1 中获取域数据key1的值是: "+context1.getAttribute("key1"));
        context1.setAttribute("key1", "value1");
        System.out.println("conetx1 中获取域数据key1的值是: "+context1.getAttribute("key1"));
        System.out.println("conetx1 中获取域数据key1的值是: "+context1.getAttribute("key1"));
        System.out.println("conetx1 中获取域数据key1的值是: "+context1.getAttribute("key1"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
