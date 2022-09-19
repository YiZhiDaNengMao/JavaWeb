package web;

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

@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
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

        UserService userService = new UserServiceImpl();
        boolean isAdd = userService.addUser(user);
        if(!isAdd){
            request.setAttribute("msg","添加失败！！");
            request.getRequestDispatcher("/add.jsp").forward(request,response);
        } else {
            response.sendRedirect(request.getContextPath() + "/UserListServlet");
        }
    }
}
