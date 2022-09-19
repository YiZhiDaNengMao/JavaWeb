<%--
  User: 一头大能猫
  Date: 2022/9/6
  Time: 19:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%=
    "application === " + pageContext.getAttribute("name", PageContext.APPLICATION_SCOPE)
%><br>
<%=
    "session === " + pageContext.getAttribute("name", PageContext.SESSION_SCOPE)
%><br>
<%=
    "request === " + pageContext.getAttribute("name", PageContext.REQUEST_SCOPE)
%><br>
<%=
    "page === " + pageContext.getAttribute("name", PageContext.PAGE_SCOPE)
%>--%>

<%--简化方式: 从小到大进行获取,如果当前域对象中的值为null,就往上一层的域获取--%>
<%=
    pageContext.findAttribute("name")
%>

</body>
</html>
