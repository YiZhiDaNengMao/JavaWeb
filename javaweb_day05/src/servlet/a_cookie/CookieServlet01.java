package servlet.a_cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/CookieServlet01")
public class CookieServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受请求
        System.out.println("接受请求");
        //2.做一系列的业务处理
        System.out.println("做一系列的业务处理");

        //3.将数据存储到cookie中，通过response对象携带到客户端中

        //3.1创建Cookie对象，设置要发送的数据
        //Cookie仅支持String数据格式，只能使用英文
        Cookie cookie = new Cookie("name", "star");

        //3.2发送Cookie到客户端中，使用response对象发送
        response.addCookie(cookie);
        //等同于 response.setHeader("Set-Cookie","Cookie的值");
//        response.setHeader("Set-Cookie","Name=Star");
    }
}
