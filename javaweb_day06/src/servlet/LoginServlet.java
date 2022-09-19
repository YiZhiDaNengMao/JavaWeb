package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");

        String checkcode = request.getParameter("checkcode");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        String check = (String)session.getAttribute("checkcode_session");
        if(checkcode != null){
            if (checkcode.equals(check)) {
                if (username.equals("πDaStar") && password.equals("666")) {
                    session.setAttribute("name",username);
                    response.sendRedirect(request.getContextPath() + "/success.jsp");
                } else {
                    request.setAttribute("login_error","用户名或密码错误!!");
                    request.getRequestDispatcher("/login.jsp").forward(request,response);
                }
            } else{
                request.setAttribute("cc_error","验证码错误!!");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }
    }
}
