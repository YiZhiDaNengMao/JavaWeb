package com.star.web;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet("/FindUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setContentType("text/html;charset=utf8");

        //1.接收请求参数  -   用户名
        String username = request.getParameter("username");

        /*2.调用service业务层的逻辑判断...
            方式一：单个参数封装成对象
            方式二： 多个参数封装成map集合
            Json字符串 = {"姓名":"派大星","性别":"男"}
        */
        //2.1创建核心对象
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        //2.2添加集合内的参数
        if ("πDaStar".equals(username)) {
            map.put("userExist", true);
            map.put("msg", "用户已存在");
        } else {
            map.put("userExist", false);
            map.put("msg", "用户不存在");
        }
        mapper.writeValue(response.getWriter(),map);
    }
}
