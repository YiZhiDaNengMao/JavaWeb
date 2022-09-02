package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.PrintWriter;
import java.util.Date;
import java.io.IOException;

@WebServlet("/ServletResponseDemo04")
public class ServletResponseDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置response缓冲区的字符集
        //response.setCharacterEncoding("utf8");

        //3.设置浏览器的响应类型
        response.setContentType("text/html;charset=utf8");

        //1.获取字符流 -> 输出内容（页面）
        PrintWriter writer = response.getWriter();

        /*2.写入内容
            response缓冲区的编码集数：ISO-8859-1
         */
        writer.println("<h1>字符流输出（println）</h1");
        writer.write("<h1>字符流输出（write）</h1>");
    }
}
