<%@ page import="jdk.nashorn.internal.ir.Flags" %><%--
  User: 一头大能猫
  Date: 2022/9/6
  Time: 11:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1>JSP,HELLO!!</h1>
    <%
      if(flag){
        System.out.println("True");
      } else{
        System.out.println(a);
      }
    %>
    <%!
      int a = 6;
      boolean flag;
//      if(flag){
//
//      }
    %>
    <%=
    "πDaStar"
    %>
  </body>
</html>
