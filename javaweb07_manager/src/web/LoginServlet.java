package web;

import exception.LoginException;
import org.apache.commons.beanutils.BeanUtils;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.io.IOException;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        User user = new User();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        String verifycode = request.getParameter("verifycode");
        HttpSession session = request.getSession();
        String checkcode = (String)session.getAttribute("CHECKCODE_SERVER");

        if(checkcode != null){
            if(!checkcode.equalsIgnoreCase(verifycode)){
                request.setAttribute("msg","验证码错误！！");
                request.getRequestDispatcher
                        ("/login.jsp").forward(request,response);
                return;
            }
        }


        UserService userService = new UserServiceImpl();
        try {
            User usr = userService.login(user);
            request.getSession().setAttribute("user",usr);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } catch (LoginException e) {
            request.setAttribute("msg",e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
