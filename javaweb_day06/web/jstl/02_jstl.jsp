<%@ page import="java.util.ArrayList" %><%--
  User: 一头大能猫
  Date: 2022/9/6
  Time: 20:02
--%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL标签库之forEach标签</title>
</head>
<body>
    <%-- 1. 模拟：for (int i = 0; i <= 5; i++) { sout(i) } --%>
    <%-- begin: 从⼏开始
     end: 到⼏结束(包含)
     var: 临时变量, 将现在循环的值 i 存⼊到了page域中
    --%>
    <j:forEach begin="1" end="6" var="i" step="2">
        ${i}
    </j:forEach>

    <hr>

    <%
        ArrayList list = new ArrayList();
        list.add("πDaStar01");
        list.add("πDaStar02");
        list.add("πDaStar03");
        pageContext.setAttribute("list",list);
    %>
    <%-- 2. 模拟：String[] strList = {"lucy", "tom", "jack"};
     for(String str : strList) { sout(str) }
    --%>
    <%-- items: 要遍历的集合或者数组
     var: 遍历出来的每⼀个元素, 将这个元素存⼊到了page域中 起名为xx
     varStatus: 记录当前遍历状态的对象, index-下标 count-序号
    --%>
    <j:forEach items="${list}" var="str" varStatus="s">
        ${s.index}<br>
        ${s.count}<br>
        ${str}<br>
    </j:forEach>
</body>
</html>
