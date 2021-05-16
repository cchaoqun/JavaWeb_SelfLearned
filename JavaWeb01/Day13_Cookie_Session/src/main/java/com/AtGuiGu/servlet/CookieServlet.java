package com.AtGuiGu.servlet;

import com.AtGuiGu.utils.CookieUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/13-17:30
 */

public class CookieServlet extends BaseServlet{


    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cookie cookie = new Cookie("path1", "path1");
        //getContextPath()得到工程路径
        // 工程路径/abc
        cookie.setPath(req.getContextPath()+"/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有path路径的cookie");

    }



    protected void live3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cookie cookie = new Cookie("life3600", "life3600");
        cookie.setMaxAge(60*60);
        resp.addCookie(cookie);
        resp.getWriter().write("已经创建了一个存活一小时的Cookie");

    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //先找到你要删除的Cookie对象
        Cookie cookie3 = CookieUtils.findCookie("key3", req.getCookies());
        if(cookie3!=null){
            //调用setMaxAge(0)
            cookie3.setMaxAge(0);
            //调用response.addCookie(cookie)
            resp.addCookie(cookie3);
            resp.getWriter().write("key3的cookie已经被删除");
        }

    }


    protected void defaultCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cookie cookie = new Cookie("defaultLife","defaultLife");
        cookie.setMaxAge(-1);//设置存活时间
        resp.addCookie(cookie);

    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //方案一：
        //1. 先创建一个要修改的同名（指的就是 key）的 Cookie 对象
        //2. 在构造器，同时赋于新的 Cookie 值。
//        Cookie cookie = new Cookie("key1", "newValue1");
//        //3. 调用 response.addCookie( Cookie );
//        resp.addCookie(cookie);
//        resp.getWriter().write("key1的cookie已经修改好了");

        //方案二
        //1. 先查找到需要修改的 Cookie 对象
        Cookie cookie2 = CookieUtils.findCookie("key2", req.getCookies());
        if(cookie2!=null){
            //2. 调用 setValue()方法赋于新的 Cookie 值。
            cookie2.setValue("newValue2");
            //3. 调用 response.addCookie()通知客户端保存修改
            resp.addCookie(cookie2);
        }


    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie:cookies){
            //getName()方法返回Cookie的key(名)
            //getValue()方法返回Cookie的value(值)
            resp.getWriter().write("cookie["+cookie.getName()+"="+cookie.getValue()+"] <br/>");
        }

        Cookie iWantCookie = CookieUtils.findCookie("key2", cookies);
        if(iWantCookie!=null){
            resp.getWriter().write("找到了需要的cookie");
        }
    }

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1.创建Cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        //2.通知客户端保存Cookie
        resp.addCookie(cookie);
        Cookie cookie2 = new Cookie("key2", "value2");
        //2.通知客户端保存Cookie
        resp.addCookie(cookie2);
        Cookie cookie3 = new Cookie("key3", "value3");
        //2.通知客户端保存Cookie
        resp.addCookie(cookie3);

        resp.getWriter().write("Cookie创建成功");
    }

}
