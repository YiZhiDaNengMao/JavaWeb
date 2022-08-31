package com.star.web.b_servletCoonfig;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;

/*
    配置与使用
 */
@WebServlet("/ServletConfigDemo")
public class ServletConfigDemo extends HttpServlet {
    //创建ServletConfig对象
    private ServletConfig config;

    //在servlet对象创建时,就随之产生
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(new Date().toString());
    }
}
