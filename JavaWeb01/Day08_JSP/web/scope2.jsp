<%--
  Created by IntelliJ IDEA.
  User: Chaoq
  Date: 2021/5/11
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>scope2.jsp页面</h1>

    pageContext域是否有值: <%=pageContext.getAttribute("key")%> <br>
    request: <%=request.getAttribute("key")%> <br>
    session: <%=session.getAttribute("key")%> <br>
    application: <%=application.getAttribute("key")%> <br>
</body>
</html>
