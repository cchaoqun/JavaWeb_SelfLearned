<%--
  Created by IntelliJ IDEA.
  User: Chaoq
  Date: 2021/5/14
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("a.jsp页面执行了");
        Object user = session.getAttribute("user");

        //如果等于null 说明未登陆
        if(user==null){
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
    %>


    a.jsp
</body>
</html>
