package a_request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;
import java.util.Queue;

@WebServlet("/ServletRequestDemo05")
public class ServletRequestDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /*
        post:与tomcat编码方式无关，request编码默认为null
            浏览器编码 => request解码
        get:解码方式默认与tomcat一致，与request解码方式无关
            浏览器编码 => tomcat解码
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ISO-8859-1 => UTF-8: &#19968;&#21482;&#22823;&#33021;&#29483;
        // UTF-8 => ISO-8859-1: ????¤??¤§è?????

        String username = request.getParameter("username");
        System.out.println(request.getCharacterEncoding());
        System.out.println(username);
    }
}
