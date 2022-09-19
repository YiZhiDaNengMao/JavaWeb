<%--
  User: 一头大能猫
  Date: 2022/9/6
  Time: 20:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式获取隐式对象</title>
</head>
<body>
    <%--
        pageContext
        可以获得其他⼋⼤对象
        ☆重点：${pageContext.request.contextPath}：动态获取虚拟⽬录
    --%>

    <%--获取request域中的数据--%>
    ${pageContext.request}
</body>
</html>
