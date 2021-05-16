<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Chaoq
  Date: 2021/5/10
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    这是html页面数据(JSP)
<%--1声明属性--%>
    <%!
        private Integer id;
        private String name;
        private static Map<String, Object> map;
    %>
<%--2.声明static静态代码块--%>
    <%!
        static{
            map = new HashMap<>();
            map.put("key1", "value1");
            map.put("key2", "value2");
            map.put("key3", "value3");
        }
    %>
<%--3.声明类方法--%>
    <%!
        public int abc(){
            return 12;
        }
    %>
<%--4.声明内部类--%>
    <%!
        public static class A{
            private Integer id = 12;
            private String abc = "abc";
        }
    %>

<%--表达式脚本--%>
    <%=12 %> <br>
    <%=12.12 %> <br>
    <%="我是字符串" %> <br>
    <%=map %> <br>
    <%=request.getParameter("username") %> <br>

<%--代码脚本--%>
<%--    1. if 语句--%>
    <%
        int j = 13;
        if(j==12){
            System.out.println(12);
        }else{
            System.out.println(0);
        }
    %>
<%--2. for循环语句--%>
    <table border="1" cellspacing="0">


    <%
        for(int i=0; i<12; i++){

    %>
        <tr>
            <td>第<%=i %>行</td>
        </tr>

    <%
        }
    %>
    </table>
<%--3 翻译后java文件中_jspService方法内的代码都可以写--%>
    <%
        String name = request.getParameter("username");
        System.out.println("用户名的请求参数是: "+name);
    %>




</body>
</html>
