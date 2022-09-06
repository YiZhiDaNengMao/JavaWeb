package servlet.b_session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;

@WebServlet("/SessionServlet02")
public class SessionServlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取Session对象
        HttpSession session = request.getSession();

        //2.获取数据
        Object name = session.getAttribute("JSSESION");

        //3.
        response.getWriter().write(name.toString());

    }
}
