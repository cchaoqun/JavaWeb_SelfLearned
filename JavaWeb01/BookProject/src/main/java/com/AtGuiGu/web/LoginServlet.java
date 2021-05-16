package com.AtGuiGu.web;

import com.AtGuiGu.pojo.User;
import com.AtGuiGu.service.UserService;
import com.AtGuiGu.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/10-18:23
 */

public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = userService.login(new User(null, username, password, null));
        //2 调用login 方法检查用户名密码是否匹配
        if(loginUser==null){
            //登录失败
            System.out.println("用户名或密码错误, 登录失败");//请输入用户名和密码
            //把错误的信息和回显的表单项信息, 保存到Request域中
            req.setAttribute("msg", "用户或密码错误");
            req.setAttribute("username", username);
            //跳转回登录界面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }else{
            //登录成功
            //跳转到登录成功界面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }
}
