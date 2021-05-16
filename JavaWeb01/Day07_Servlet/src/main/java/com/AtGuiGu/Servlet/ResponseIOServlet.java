package com.AtGuiGu.Servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/9-19:49
 */

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(resp.getCharacterEncoding()); //默认 ISO-8859-1
        //方法一
//        //设置服务器字符集为UTF-8
//        resp.setCharacterEncoding("UTF-8");
//
//        //通过响应头设置浏览器也使用UTF-8字符集
//        resp.setHeader("Content-type", "text/html; charset=UTF-8");

        //方法二
        //他会同时设置服务器和客户端都使用UTF-8字符集, 还设置了响应头
        //此方法一定要在获取流对象之前调用才有效
        resp.setContentType("text/html; charset=UTF-8");
        System.out.println(resp.getCharacterEncoding()); //默认 ISO-8859-1
//        resp.getOutputStream();
        PrintWriter writer = resp.getWriter();
        writer.write("程超群");
    }
}
