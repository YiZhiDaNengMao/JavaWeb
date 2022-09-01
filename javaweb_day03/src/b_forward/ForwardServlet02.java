package b_forward;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;

@WebServlet("/ForwardServlet02")
public class ForwardServlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //测试数据
        System.out.println("Forward02: " + request);
        System.out.println("Forward02收到转发的请求...");

        //获取request域中的数据
        Object name = request.getAttribute("name");
        System.out.println(name);
    }
}
