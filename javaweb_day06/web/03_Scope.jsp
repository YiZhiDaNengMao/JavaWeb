<%--
  User: 一头大能猫
  Date: 2022/9/6
  Time: 17:26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope</title>
</head>
<body>
  <%-- 四大域对象: 可以通过pageContext对象来获取
      ①.pageContext(page 域对象)
      ②.request(request 域对象)
      ③.session(session 域对象)
      ④.application(application 域对象)
  --%>

  <%
    //作用一: 作为域对象使用
    //往pageContext域对象中存入数据: 域范围: 当前页面
    pageContext.setAttribute("name","πDaStar");

    //取出pageContext域对象的数据
    String name = (String)pageContext.getAttribute("name");
    System.out.println(name);

    //作用二: 通过pageContext 获取其他内置对象
    HttpSession session1 = pageContext.getSession();

    //作用三: 通过pageContext,向其他域对象中存储数据

    //存储到ServletContext域中

    //存储到自己的域中
    pageContext.setAttribute("name","πDaStar01",PageContext.PAGE_SCOPE);

    //存储到request域中
    pageContext.setAttribute("name","πDaStar02",PageContext.REQUEST_SCOPE);

    //存储到Session域中
    pageContext.setAttribute("name","πDaStar03",PageContext.SESSION_SCOPE);

    //存储到ServletContext域中
    pageContext.setAttribute("name","πDaStar04",PageContext.APPLICATION_SCOPE);
  %>

</body>
</html>
