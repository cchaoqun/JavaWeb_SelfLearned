package com.AtGuiGu.Servlet;

import com.AtGuiGu.pojo.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/11-16:04
 */

public class SearchStuServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数
        // 发 sql 语句查询学生的信息
        // 使用 for 循环生成查询到的数据做模拟
        List<Student> stuList = new ArrayList<Student>();
        for(int i=0; i<10; i++){
            int t = i+1;
            stuList.add(new Student(t, "name"+t, 18+t, "phone"+t));
        }
        // 保存查询到的结果（学生信息）到 request 域中
        req.setAttribute("stuList", stuList);
        // 请求转发到 showStudent.jsp 页面
        req.getRequestDispatcher("/test/showStudent.jsp").forward(req, resp);
    }
}
