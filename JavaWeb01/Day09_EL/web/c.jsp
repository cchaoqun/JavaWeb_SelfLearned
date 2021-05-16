<%@ page import="com.AtGuiGu.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Chaoq
  Date: 2021/5/11
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person = new Person();
        person.setName("ccq");
        person.setPhones(new String[]{"123","1231312","123123213"});

        List<String> cities = new ArrayList<>();
        cities.add("bj");
        cities.add("sh");
        cities.add("anhui");
        cities.add("guangdong");
        person.setCities(cities);

        Map<String, Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        person.setMap(map);
        pageContext.setAttribute("p", person);

    %>

    输出Person: ${p} <br>
    输出Person的name属性 ${p.name} <br>
    输出Person的phones数组属性 ${p.phones[1]} <br>
    输出Person的cities集合属性 ${p.cities} <br>
    输出Person的cities集合个别属性 ${p.cities[0]} <br>
    输出Person的map集合属性 ${p.map} <br>
    输出Person的map集合某个key1属性 ${p.map.key1} <br>
    输出Person的age属性 ${p.age} <br>

</body>
</html>
