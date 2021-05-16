package com.AtGuiGu.web;

import com.AtGuiGu.pojo.Book;
import com.AtGuiGu.service.BookService;
import com.AtGuiGu.service.impl.BookServiceImpl;
import com.AtGuiGu.utils.WebUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/13-13:41
 */

public class BookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数==封装成Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2.把全部图书保存到request域中
        bookService.addBook(book);
        //3重定向回图书列表管理页面 到/managerServlet?action=list
        resp.sendRedirect(req.getContextPath()+ "/manager/bookServlet?action=list");

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数id, 图书编程
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2.调用bookService.deleteBookById()删除图书
        bookService.deleteBookById(id);
        //3重定向回图书列表管理页面 到/managerServlet?action=list
        resp.sendRedirect(req.getContextPath()+ "/manager/bookServlet?action=list");


    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2把全部图书保存到Request域中
        req.setAttribute("books", books);
        //3请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
