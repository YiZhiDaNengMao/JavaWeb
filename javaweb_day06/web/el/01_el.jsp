<%--
  User: 一头大能猫
  Date: 2022/9/6
  Time: 20:30
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式获取值的方式</title>
</head>
<body>
    <%-- 四大域对象: 可以通过pageContext对象来获取
        ①.pageContext(page 域对象)
        ②.request(request 域对象)
        ③.session(session 域对象)
        ④.application(application 域对象)
    --%>
    <%--使用原始方式往域对象中存储数据--%>
    <%
        request.setAttribute("name", "πDaStar");
        session.setAttribute("age", "6");
    %>

    <%-- EL表达式的语法: ${表达式} --%>
    <%--获取域对象中的内容--%>
    ${requestScope.name}
    ${sessionScope.age}

</body>
</html>
