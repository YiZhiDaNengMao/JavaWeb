<%--
  User: 一头大能猫
  Date: 2022/9/6
  Time: 15:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <h1>
        <%
            Object name = session.getAttribute("name");
            out.write("Welcome" + name + "!\t\tLogin Success!!");
        %>
    </h1>
</body>
</html>
