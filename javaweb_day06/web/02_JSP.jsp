<%--
  User: 一头大能猫
  Date: 2022/9/6
  Time: 14:15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--① request：获取用户请求信息--%>
    <%
//        request.getRequestDispatcher("").forward(request,response);
    %>

    <%--② response：后去客户端的响应信息，并处理--%>
    <%
        response.getWriter().write("response...");
    %>

    <%--out输出在response之后--%>

    <%--③ out：输出内容到界面上--%>
    <%
        out.print("πDaStar");
    %>


</body>
</html>
