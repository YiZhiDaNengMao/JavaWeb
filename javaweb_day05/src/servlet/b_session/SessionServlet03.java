package servlet.b_session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;

/*
    1.当客户端关闭后，服务器不关闭，两次获取session是否为同一个？
    ·默认情况下。不是。
    ·如果需要相同，则可以创建Cookie，键为JSESSIONID，设置最大存活时间，让cookie持久化保存。
 */
@WebServlet("/SessionServlet03")
public class SessionServlet03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取session对象
        HttpSession session = request.getSession();
        System.out.println(session);
        //期望：客户端关闭后，session也能相同
        //2.获取session的ID
        String id = session.getId();
        System.out.println(id);
        //3.创建一个一模一样的Cookie
        Cookie cookie = new Cookie("JSESSIONID", id);
        //4.设置Cookie的持久化
        cookie.setMaxAge(60 * 36);
        //5.发送cookie
        response.addCookie(cookie);
        //6.向session域对象中存储数据
        session.setAttribute("JSESSION","66");
    }
}
