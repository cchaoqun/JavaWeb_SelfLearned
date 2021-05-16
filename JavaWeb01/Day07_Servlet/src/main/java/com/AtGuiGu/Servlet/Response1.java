package com.AtGuiGu.Servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/9-20:09
 */

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("到达response1");

        req.setAttribute("key1", "value1");

        //设置响应状态码302 表示重定向
        resp.setStatus(302);

        //设置Location表头, 重定向的地址
//        resp.setHeader("Location", "http://localhost:8080/Day07_Servlet/response2");
//        resp.setHeader("Location", "http://www.baidu.com");
        resp.sendRedirect("http://www.baidu.com");
    }
}
