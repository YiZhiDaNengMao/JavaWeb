package com.star.web.c_servletContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;

@WebServlet("/ServletContextDemo02")
public class ServletContextDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建对象
        ServletContext context = getServletContext();

        //2.获取应用初始化的参数
        String configPath = context.getInitParameter("ConfigPath");
        System.out.println(configPath);

        //3.获取虚拟目录
        //Returns the context path of the web application.
        String path = context.getContextPath();
        System.out.println(path);// /javaweb_day02

        //4.1 src下
        //D:\workspace_idea\javaweb\out\artifacts\javaweb_day02\WEB-INF\classes\bai.txt
        String path1 = context.getRealPath("WEB-INF/classes/bai.txt");
        System.out.println(path1);

        //4.2 WEB-INF下
        //D:\workspace_idea\javaweb\out\artifacts\javaweb_day02\WEB-INF\web.xml
        String path2 = context.getRealPath("WEB-INF/web.xml");
        System.out.println(path2);

        //4.3 web下
        //D:\workspace_idea\javaweb\out\artifacts\javaweb_day02\index.jsp
        String path3 = context.getRealPath("index.jsp");
        System.out.println(path3);
        //4.4 工程下，不编译
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(new Date().toString());
    }
}
