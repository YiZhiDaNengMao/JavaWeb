package com.star.web.c_servletContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/ServletContextDemo04")
public class ServletContextDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        Object name = context.getAttribute("name");
        Object date = context.getAttribute("date");
        System.out.println(name);
//        response.setCharacterEncoding("GBK");
        response.getWriter().write( name + "\n" +  date);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(new Date().toString());
    }
}
