<%@ page import="java.util.ArrayList" %><%--
  User: 一头大能猫
  Date: 2022/9/6
  Time: 19:43
--%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL之if标签</title>
</head>
<body>
    <%--
    if标签的使用
    if(条件){}

    test="": 必须存在的属性，接受boolean类型的值
    在j:if标签中，没有else的情况，如果想要else则再定义一个j:if标签
    --%>
    <j:if test="true">
        <%--可以嵌套html代码--%>
        <h1>JSTL标签库01</h1>
    </j:if>
    <%--相当于else的情况--%>
    <j:if test="false">
        <%--可以嵌套html代码--%>
        <h1>JSTL标签库02</h1>
    </j:if>

    <%--
    需求：判断request域中的一个集合是否为空
    如果不为空，则遍历集合
    --%>
    <%
        ArrayList list = new ArrayList();
        list.add("a");
        list.add("b");
        pageContext.setAttribute("list",list);
    %>
    <%--test中条件，使用EL表达式--%>
    <j:if test="${not empty list}">
        遍历集合...
    </j:if>

    <%
        pageContext.setAttribute("num",6);
    %>
    <%--需求：判断一个数字是技术还是偶数（向域对象中存入数据）--%>
    <j:if test="${num % 2 != 0}">
        ${num}是奇数
    </j:if>
    <j:if test="${num % 2 == 0}">
        ${num}是偶数
    </j:if>
</body>
</html>
