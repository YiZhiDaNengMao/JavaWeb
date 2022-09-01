package a_request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;

@WebServlet("/ServletRequestDemo04")
public class ServletRequestDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 获取请求中的请求参数
            get:参数跟在链接后面
            post:出现在请求体重
            他们现在的获取参数方式一样!!
         */

        //获取用户名
        String username = request.getParameter("username");
        System.out.println(username);// post:????¤??¤§è????? | get:一头大能猫
        //获取密码
        String password = request.getParameter("password");
        System.out.println(password);

    }
}
