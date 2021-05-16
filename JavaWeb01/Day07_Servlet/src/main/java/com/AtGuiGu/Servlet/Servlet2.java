package com.AtGuiGu.Servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/9-19:06
 */

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数(办事的材料查看)
        String username = req.getParameter("username");
        System.out.println("在Servlet2(柜台2)中查看参数(材料): "+username);

        //查看柜台1是否盖章
        Object key1 = req.getAttribute(("key1"));
        System.out.println("柜台1是否有章: "+key1);

        //处理自己的业务
        System.out.println("柜台2处理自己的业务");
    }
}
