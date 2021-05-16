<%--
  Created by IntelliJ IDEA.
  User: Chaoq
  Date: 2021/5/14
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    这是登陆页面 login.jsp
    <form action="http://localhost:8080/Day15_Filter/loginServlet" method="get">
        用户名: <input type="text" name="username"> <br>
        密码: <input type="password" name="password"> <br>
        <input type="submit" >
    </form>

</body>
</html>
