package servlet.a_cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;

@WebServlet("/CookieServlet03")
public class CookieServlet03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("name1", "lbxx");
        Cookie cookie2 = new Cookie("name2", "pdx");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }
}
