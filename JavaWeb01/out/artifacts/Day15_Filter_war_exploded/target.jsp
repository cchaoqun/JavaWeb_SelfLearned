<%--
  Created by IntelliJ IDEA.
  User: Chaoq
  Date: 2021/5/14
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("target.jsp执行了");
        System.out.println("target.jsp线程: "+Thread.currentThread().getName());
        System.out.println("target.jsp "+request.getParameter("username"));
    %>
</body>
</html>
