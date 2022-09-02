package b_forward;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;

@WebServlet("/ForwardServlet01")
public class ForwardServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Forward01: " + request);
        System.out.println("Forward01转发请求...");

        //1.获取虚拟目录
        String context = request.getContextPath();
        System.out.println(context);

        //2.request作为域对象使用
        request.setAttribute("name","Π大星");

        //3.做请求转发功能，在ForwardServlet02中取出域对象的数据
        //3.1获取请求的转发器 - 参数：要转发到哪个servlet资源
//        RequestDispatcher rd = request.getRequestDispatcher("/ForwardServlet02");
        //3.2转发请求
//        rd.forward(request,response);

        //合并以上操作
        request.getRequestDispatcher("/ServletResponseDemo02").forward(request,response);
    }
}
