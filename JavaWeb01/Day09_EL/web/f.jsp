<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Chaoq
  Date: 2021/5/11
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Map<String,Object> map1 = new HashMap<String, Object>();
    map1.put("a.a.a", "aaaValue");
    map1.put("b+b+b", "bbbValue");
    map1.put("c-c-c", "cccValue");
    map1.put("c-c-c-c", "ccccValue");
    request.setAttribute("m", map1);
%>
${ m['a.a.a'] } <br>
${ m["b+b+b"] } <br>
${ m['c-c-c'] } <br>
${ m['c-c-c-c'] } <br>
</body>
</html>
