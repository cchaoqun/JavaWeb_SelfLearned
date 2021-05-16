package com.AtGuiGu.filter;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/14-15:34
 */

public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter1 前置代码");
        System.out.println("Filter1线程"+Thread.currentThread().getName());
        System.out.println("Filter1 "+servletRequest.getParameter("username"));
        servletRequest.setAttribute("key1","value1");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter1 后置代码");

    }

    @Override
    public void destroy() {

    }
}
