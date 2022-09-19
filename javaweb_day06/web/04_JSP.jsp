<%--
  User: 一头大能猫
  Date: 2022/9/6
  Time: 19:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //存储到自己的域中
    pageContext.setAttribute("name", "πDaStar01", PageContext.PAGE_SCOPE);
    //存储到request域中
    pageContext.setAttribute("name", "πDaStar02", PageContext.REQUEST_SCOPE);
    //存储到Session域中
    pageContext.setAttribute("name", "πDaStar03", PageContext.SESSION_SCOPE);
    //存储到ServletContext域中
    pageContext.setAttribute("name", "πDaStar04", PageContext.APPLICATION_SCOPE);
%>
<%=
    "page === " + pageContext.getAttribute("name",PageContext.PAGE_SCOPE)
%><br>
<%=
    "request === " + pageContext.getAttribute("name",PageContext.REQUEST_SCOPE)
%><br>
<%=
    "session === " + pageContext.getAttribute("name",PageContext.SESSION_SCOPE)
%><br>
<%=
    "application === " + pageContext.getAttribute("name",PageContext.APPLICATION_SCOPE)
%>

<%--转发 为了验证--request 取出值--%>
<%
    request.getRequestDispatcher("/05_JSP.jsp")
            .forward(request,response);
%>

</body>
</html>
