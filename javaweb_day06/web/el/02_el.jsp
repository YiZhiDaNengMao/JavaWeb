<%--
  User: 一头大能猫
  Date: 2022/9/6
  Time: 20:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式获取方式二</title>
</head>
<body>
    <%--使用原始方式往域对象中存储数据--%>
    <%
        request.setAttribute("name", "πDaStar");
        session.setAttribute("age", "6");
    %>

    <%--获取域对象中的数据
        ${键名} 获取值 -> 遵循 从小到大进行获取
        用法等同于 findAttribute(String name)
    --%>
    ${name}
</body>
</html>
