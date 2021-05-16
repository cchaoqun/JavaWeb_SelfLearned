<%--
  Created by IntelliJ IDEA.
  User: Chaoq
  Date: 2021/5/11
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">

        table{
            width: 600px;
        }

    </style>
</head>
<body>
<%--练习一：在 练习一：在 jsp 页面中输出九九乘法口诀表--%>
<h1 align="center">九九乘法口诀表</h1>
<table align="center">

    <% for (int i = 1; i <= 9; i++) { %>
    <tr>
        <% for (int j = 1; j <=i ; j++) { %>
            <td><%= i+"x"+j +"="+ i*j %></td>
        <% } %>
        <br>
    </tr>
    <% } %>

</table>

</body>
</html>
