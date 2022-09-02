package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.PrintWriter;
import java.util.Date;
import java.io.IOException;

@WebServlet("/ServletResponseDemo03")
public class ServletResponseDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取字符流 -> 输出内容（页面）
        PrintWriter writer = response.getWriter();
        //2.获取字节流 -> 文件复制（文件下载）
        ServletOutputStream os = response.getOutputStream();
        //以上两种流 不能同时使用！！
    }
}
