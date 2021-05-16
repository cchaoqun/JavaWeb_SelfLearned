<%@ page import="java.util.ArrayList" %>
<%@ page import="com.AtGuiGu.pojo.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Chaoq
  Date: 2021/5/11
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            border: 1px grey solid;
            width: 600px;
            border-collapse: collapse;
        }
        td, th{
            border: 1px grey solid;
        }
    </style>
</head>
<body>
<%--jsp  输出一个表格，里面有 10 个学生信息。--%>
<%
    List<Student> stuList = (List<Student>)request.getAttribute("stuList");
%>

<table align="center">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>电话</td>
        <td>操作</td>
    </tr>
<% for(Student stu:stuList){ %>
    <tr>
        <td><%=stu.getId()%></td>
        <td><%=stu.getName()%></td>
        <td><%=stu.getAge()%></td>
        <td><%=stu.getPhone()%></td>
        <td>删除 修改</td>
    </tr>
<% } %>
</table>
</body>
</html>
