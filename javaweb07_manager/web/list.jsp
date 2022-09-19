<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(id) {
            if (confirm("确认删除？")) {
                location.href = "${pageContext.request.contextPath
                }/UserDeleteServlet?id=" + id;

            }
        }

        $(function () {
            $("#delSelected").click(function () {
                if(confirm("确认删除？")){
                    $("#form").submit();
                }
            })

            $("#first").click(function () {
                var checkedFlag = $(this).prop("checked");
                $("input").prop("checked",checkedFlag);
            })
        })
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left">
        <form class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">籍贯</label>
                <input type="email" class="form-control" id="exampleInputEmail2">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" class="form-control" id="exampleInputEmail3">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float: right">
        <tr>
            <td colspan="8" align="center"><a class="btn btn-primary" href="add.jsp">添加联系人</a></td>
        </tr>
        <tr>
            <td colspan="8" align="center">
                <a class="btn btn-primary" href="javascript:void(0)" id="delSelected">删除选中</a>
            </td>
        </tr>
    </div>
    <form id="form" action="${pageContext.request.contextPath}/DelSelectedServlet" method="post">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="first" name="first" /></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${page.list}" var="user" varStatus="i">
            <tr>
                <td><input type="checkbox" name="uid" value="${user.id}" /></td>
                <td>${i.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn-update" href="${pageContext.request.contextPath
                        }/UserFindServlet?id=${user.id}">修改</a>&nbsp;
                    <a class="btn-delete" href="javascript:deleteUser(${user.id})">删除
                            <%--href="${pageContext.request.contextPath}/UserDeleteServlet?id=${user.id}">删除--%>

                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="${pageContext.request.contextPath
                    }/FindPageServlet?currentPage=${page.currentPage-1}&rows=${page.rows}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${page.totalPage}" var="p">
                    <li><a href="${pageContext.request.contextPath
                    }/FindPageServlet?currentPage=${p}&rows=${page.rows}">${p}</a></li>
                </c:forEach>
                <li>
                    <a href="${pageContext.request.contextPath
                    }/FindPageServlet?currentPage=${page.currentPage+1}&rows=5" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 10px">共${page.totalCount}条记录,共${page.totalPage}页</span>
            </ul>

        </nav>

    </div>
</div>
</body>
</html>
