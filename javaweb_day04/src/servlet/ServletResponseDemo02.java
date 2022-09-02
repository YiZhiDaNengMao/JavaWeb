package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;

@WebServlet("/ServletResponseDemo02")
public class ServletResponseDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object name = request.getAttribute("name");
        System.out.println(name);
        //1.动态获取项目的虚拟目录
        String contextPath = request.getContextPath();
        //2.重定向到自定义的资源地址
        response.sendRedirect(contextPath + "/ServletResponseDemo01");
    }
}
