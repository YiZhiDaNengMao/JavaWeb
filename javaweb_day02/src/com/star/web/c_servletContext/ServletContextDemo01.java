package com.star.web.c_servletContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;


/*
    ServletContext对象的创建
 */
@WebServlet("/ServletContextDemo01")
public class ServletContextDemo01 extends HttpServlet {
    private ServletConfig config;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.通过Servlet对象获取 -> HttpServlet
        //this 表示 HttpServlet
        ServletContext app1 = getServletContext();
        System.out.println(app1);

        //2.通过请求对象request获取
        ServletContext app2 = request.getServletContext();
        System.out.println(app2);

        //3.通过servletConfig对象获取
//        ServletContext app3 = config.getServletContext();
//        System.out.println(app3);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(new Date().toString());
    }
}
