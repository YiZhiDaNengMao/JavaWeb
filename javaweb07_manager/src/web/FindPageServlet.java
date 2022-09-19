package web;

import pojo.PageBean;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.io.IOException;

@WebServlet("/FindPageServlet")
public class FindPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if(currentPage == null || currentPage.equals("")){
            currentPage = "1";
        }

        if (rows == null || "".equals(rows)){
            rows = "5";
        }

        UserService userService = new UserServiceImpl();
        PageBean page = userService.findUserByPage( currentPage,rows);
        System.out.println(page.getList());


        request.setAttribute("page",page);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}
