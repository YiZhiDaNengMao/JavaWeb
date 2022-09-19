<%@ page import="bean.User" %>
<%@ page import="java.util.Date" %><%--
  User: 一头大能猫
  Date: 2022/9/6
  Time: 20:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL获取对象值</title>
</head>
<body>
    <%-- 插入数据 --%>
    <%
        //创建user对象
        User username = new User();
        username.setName("πDa星");
        username.setAge(36);
        username.setBirthday(new Date());

        //将数据存储到request域对象中
        request.setAttribute("u",username);
    %>

    <%--获取域对象中的值 -
        根据对象中的数据获取值 -> getName()
        get去掉 -> Name首字母变小写 -> name
    --%>
    ${requestScope.u.name}
    ${u.age}
    ${u.birthday}
</body>
</html>
