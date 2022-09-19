package com.star.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;

/*
    注册页面的校验
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.解决（请求或响应的编码）
        request.setCharacterEncoding("utf8");
        response.setContentType("text/html;charset=utf8");
        //2.获取请求参数
        String username = request.getParameter("username");
        //3.判断用户名是否注册过
        if ("πDaStar".equals(username)) {
            response.getWriter().write("<font color='green'>已注册</font>");
        } else {
            response.getWriter().write("<font color='red'>未注册</font>");
        }
    }
}
