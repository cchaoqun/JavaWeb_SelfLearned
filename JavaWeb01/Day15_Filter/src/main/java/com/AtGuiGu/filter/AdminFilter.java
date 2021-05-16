package com.AtGuiGu.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/14-12:37
 */

public class AdminFilter implements Filter {


    public AdminFilter(){
        System.out.println("1.Filter构造器方法AdminFilter()");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.Filter的init()初始化");

        //1 、获取 Filter 的名称 filter-name 的内容
        System.out.println("filtername-name的值是: "+filterConfig.getFilterName());
        //2 、获取在 web.xml 中配置的 init-param 初始化参数
        System.out.println("初始化参数username的值是: "+filterConfig.getInitParameter("username"));
        System.out.println("初始化参数username的值是: "+filterConfig.getInitParameter("password"));
        //3 、获取 ServletContext 对象
        System.out.println(filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("3.Filter的doFilter()");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
// 如果等于 null ，说明还没有登录
        if (user == null) {
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        } else {
// 让程序继续往下访问用户的目标资源
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("4.Filter的destroy()方法");
    }
}


