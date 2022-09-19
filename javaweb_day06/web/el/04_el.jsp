<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.User" %><%--
  User: 一头大能猫
  Date: 2022/9/6
  Time: 20:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式获取List集合值</title>
</head>
<body>
    <%--存储数据--%>
    <%
        ArrayList list = new ArrayList();
        list.add("πDa星01");
        list.add("πDa星02");

        //创建user对象
        User username = new User();
        username.setName("πDa星");
        username.setAge(36);
        username.setBirthday(new Date());

        list.add(username);

        //将集合存入域对象中
        request.setAttribute("list",list);
    %>

    <%--获取域中的list集合中的数据--%>
    ${requestScope.list[0]}<br>
    ${list[1]}<br>
    ${list[2]}<br>
    <%--获取集合中,自定义对象中的name属性--%>
    ${list[2].name}

</body>
</html>
