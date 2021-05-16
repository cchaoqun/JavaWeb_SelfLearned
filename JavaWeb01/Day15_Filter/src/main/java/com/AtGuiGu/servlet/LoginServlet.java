package com.AtGuiGu.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/14-13:29
 */

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if("admin".equals(username) && "admin".equals(password)){
            req.getSession().setAttribute("user", username);
            resp.getWriter().write("登录成功");
        }else{
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
