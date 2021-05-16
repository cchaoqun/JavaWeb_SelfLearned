package com.AtGuiGu.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/10-21:28
 */

public class PrintHtml extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

//        org.apache.jasper.runtime.HttpJspBase a;
        PrintWriter writer = resp.getWriter();
        writer.write("<!DOCTYPE html>\r\n");
        writer.write("  <html lang=\"en\">\r\n");
        writer.write("  <head>\r\n");
        writer.write("      <meta charset=\"UTF-8\">\r\n");
        writer.write("      <title>Title</title>\r\n");
        writer.write("  </head>\r\n");
        writer.write(" <body>\r\n");
        writer.write("    这是html页面数据 \r\n");
        writer.write("  </body>\r\n");
        writer.write("</html>\r\n");
        writer.write("\r\n");
    }
}
