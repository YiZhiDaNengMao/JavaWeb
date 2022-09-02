package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;

@WebServlet("/ServletResponseDemo01")
public class ServletResponseDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置相应行信息 - 状态码设置为重定向
        response.setStatus(302);
        //2.设置响应头的信息 - 重定向地址
        response.setHeader("location","https://xn--4gqz7l70efr5aopo.run/");
        //设置自定义的资源地址(/javaweb_day01)
        //重定向后，后续代码仍然执行，但是不携带到另一个Servlet资源中

    }
}
