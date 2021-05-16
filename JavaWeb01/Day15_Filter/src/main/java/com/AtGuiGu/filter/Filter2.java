package com.AtGuiGu.filter;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/14-15:34
 */

public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter2 前置代码");
        System.out.println("Filter2线程"+Thread.currentThread().getName());
        System.out.println("Filter2 "+servletRequest.getParameter("username"));
        System.out.println("Filter2取key1: "+servletRequest.getAttribute("key1"));
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter2 后置代码");

    }

    @Override
    public void destroy() {

    }
}
