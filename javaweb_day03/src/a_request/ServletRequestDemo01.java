package a_request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;

@WebServlet("/ServletRequestDemo01")
public class ServletRequestDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求方式
        String method = request.getMethod();
        System.out.println(method);// GET

        //2.获取URI -> 虚拟目录 + 具体资路径
        String uri = request.getRequestURI();
        System.out.println("uri:" + uri);// /javaweb03/ServletRequestDemo01
        StringBuffer url1 = request.getRequestURL();
        String url = url1.toString();
        System.out.println("url:" + url);// http://localhost:8080/javaweb03/ServletRequestDemo01

        //4.获取虚拟目录
        ServletContext context = request.getServletContext();
        String contextPath = context.getContextPath();
        System.out.println(contextPath);// /javaweb03

        //5.获取Servlet路径
        String servletPath = request.getServletPath();
        System.out.println(servletPath);// /ServletRequestDemo01

        //6.获取请求参数 - 只适用于get的提交方式
        String query = request.getQueryString();
        System.out.println(query);// username=panda&password=123


        //3.获取协议版本
        String protocol = request.getProtocol();
        System.out.println(protocol);

    }
}
