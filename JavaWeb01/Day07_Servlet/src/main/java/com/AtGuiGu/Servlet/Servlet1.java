package com.AtGuiGu.Servlet;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/9-19:06
 */

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数(办事的材料查看)
        String username = req.getParameter("username");
        System.out.println("在Servlet1(柜台1)中查看参数(材料): "+username);

        //给材料盖章 并传递到Servlet2(柜台2)查看
        req.setAttribute("key1", "柜台1的章");

        //问路: Servlet2(柜台2)怎么走
        /**
         * 请求转发必须要以斜杠大头, / 表示 http://ip:port/工程名/, 银蛇到IDEA代码的web目录<br>
         */
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/form.html");

        //走向Servlet2(柜台2)
        requestDispatcher.forward(req, resp);
    }
}
