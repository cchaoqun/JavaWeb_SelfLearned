package com.AtGuiGu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/13-19:35
 */

public class SessionServlet extends BaseServlet{


    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取Session会话对象
        HttpSession session = req.getSession();
        //判断当前session会话是否是新创建出来的
        boolean isNew = session.isNew();
        //获取session会话的唯一id
        String id = session.getId();

        resp.getWriter().write("得到的session,他的id是:<br/> "+id+"<br/>");
        resp.getWriter().write("这个session是否是新创建的:<br/> "+isNew+"<br/>");
    }

    /**
     * 在session中保存数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getSession().setAttribute("key1", "value1");
        resp.getWriter().write("已经向Session中存放了数据");
    }

    /**
     * 获取session域中的数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Object key1 = req.getSession().getAttribute("key1");
        resp.getWriter().write("从Seesion中获取的key1的value是: "+key1);
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("Session默认的超时时长为: "+maxInactiveInterval +"秒");

    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //获取session对象
        HttpSession session = req.getSession();
        //设置当前session3秒后超时
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("当前session3秒后超时");

    }

    protected void invalidNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //获取session对象
        HttpSession session = req.getSession();
        //让session马上超时
        session.invalidate();

        resp.getWriter().write("当前session已超时");

    }
}
