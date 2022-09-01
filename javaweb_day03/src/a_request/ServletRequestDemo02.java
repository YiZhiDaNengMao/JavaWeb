package a_request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;

@WebServlet("/ServletRequestDemo02")
public class ServletRequestDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.通过请求头的key 获取所对应的value (User-Agent/Cookie)
        String agent = request.getHeader("User-Agent");
        System.out.println("agent: " + agent);

        //2.获取Cookie
        String cookie = request.getHeader("Cookie");
        System.out.println("cookie: " + cookie);
    }
}
