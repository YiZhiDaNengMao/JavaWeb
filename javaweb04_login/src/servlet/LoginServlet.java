package servlet;

import bean.User;
import dao.impl.UserDaoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
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

        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        UserDaoImpl dao = new UserDaoImpl();
        User loginUser = dao.login(user);
        if(loginUser == null){
            request.getRequestDispatcher("/FailServlet").forward(request,response);
        } else {
            response.sendRedirect(request.getContextPath() + "/SuccessServlet");
        }
    }
}
