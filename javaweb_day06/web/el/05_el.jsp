<%@ page import="java.util.HashMap" %>
<%@ page import="bean.User" %>
<%@ page import="java.util.Date" %><%--
  User: 一头大能猫
  Date: 2022/9/6
  Time: 20:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式获取Map集合中的值</title>
</head>
<body>
    <%--存储数据--%>
    <%
        //创建map集合
        HashMap map = new HashMap();
        map.put("sname","πDa星01");
        map.put("sage","36");

        //创建user对象
        User username = new User();
        username.setName("πDa星02");
        username.setAge(66);
        username.setBirthday(new Date());

        map.put("username",username);

        //将map集合存入到域对象中
        request.setAttribute("map",map);
    %>

    <%--获取域中的数据--%>
    <%--方式一: ${键名.key名称}--%>
    ${map.sname}<br>
    <%-- 方式二: ${键名["key名称"]}--%>
    ${map["sname"]}<br>

    <%--获取集合中user对象中的name--%>
    ${map.username.name}
    ${map.username["name"]}
</body>
</html>
