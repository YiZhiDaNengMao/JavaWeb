<%--
  Created by IntelliJ IDEA.
  User: 一头大能猫
  Date: 2022/9/1
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
    <style>
        div {
            size: 66px;
            color: #ed4290;
        }
    </style>
    <script src="js/jquery-1.11.0.min.js"></script>
    <script>
        $(function () {
            $("#img_check").click(function () {
                this.src = "/javaweb_day06/CheckImgServlet?random=" + Math.random();
            });
        });
    </script>
</head>
<body>
<form action="/javaweb_day06/LoginServlet" method="post">
    <table>
        <tr>
            <td class="td_left">用户名</td>
            <td class="td_right">
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td class="td_left">密码</td>
            <td class="td_right">
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td class="td_left">验证码</td>
            <td class="td_right">
                <input type="text" name="checkcode" placeholder="请输入验证码">
            </td>
        </tr>
        <tr>
            <td>
                <img id="img_check" src="/javaweb_day06/CheckImgServlet">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="登录">
            </td>
        </tr>
    </table>
</form>
<%--登录失败信息--%>
<div>
    <%=
    request.getAttribute("login_error") == null ?
            "" : request.getAttribute("login_error")
    %>
</div>
<div>
    <%=
    request.getAttribute("cc_error") == null ?
            "" : request.getAttribute("cc_error")
    %>
</div>
</body>
</html>
