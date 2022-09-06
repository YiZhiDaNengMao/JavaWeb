package servlet.a_cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;

@WebServlet("/CookieServlet04")
public class CookieServlet04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("name", "pytrick");

        //2.设置Cookie的默认存活时间
        cookie.setMaxAge(60);

        //表示浏览器关闭，Cookie消失。MaxAge默认为-1
        //cookie.setMaxAge(-1);

        //发送Cookie
        response.addCookie(cookie);

    }
}
