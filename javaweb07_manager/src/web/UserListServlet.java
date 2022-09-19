package web;

import exception.LoginException;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        List<User> list = null;
        try {
            list = userService.findAll();
//            request.setAttribute("list",list);
//            request.getRequestDispatcher("/list.jsp").forward(request,response);
            HttpSession session = request.getSession();
            session.setAttribute("list",list);
            response.sendRedirect(request.getContextPath() + "/list.jsp");
        } catch (LoginException e) {
            request.setAttribute("msg",e.getMessage());
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }

    }
}
