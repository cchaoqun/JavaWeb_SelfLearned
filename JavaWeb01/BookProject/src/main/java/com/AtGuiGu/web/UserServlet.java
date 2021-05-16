package com.AtGuiGu.web;

import com.AtGuiGu.pojo.User;
import com.AtGuiGu.service.UserService;
import com.AtGuiGu.service.impl.UserServiceImpl;
import com.AtGuiGu.utils.WebUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/12-21:18
 */

public class UserServlet extends BaseServlet {

    //Web层不能操作DAO层, 只可以调用Service层, 需要一个service对象操作DAO判断用户名是否存在
    UserService userService = new UserServiceImpl();

    /**
     *处理登录的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
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

    /**
     *处理注册的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");



        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());


        //  2、检查 验证码是否正确  === 写死,要求验证码为:abcde
        if ("abcde".equalsIgnoreCase(code)) {
            //3、检查 用户名是否可用
            if (userService.existsUsername(username)) {
                System.out.println("用户名[" + username + "]已存在!");
                //把回显信息保存到request域中
                req.setAttribute("msg", "用户名已存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                //跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //可用
                //调用Sservice保存到数据库
                userService.registUser(new User(null, username, password, email));
                //跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            System.out.println("验证码[" + code + "]错误");
            //把回显信息保存到request域中
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }


}
