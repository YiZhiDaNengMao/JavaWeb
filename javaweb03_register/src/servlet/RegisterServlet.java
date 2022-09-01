package servlet;


import bean.User;
import dao.UserDao;
import dao.UserDaoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置请求的解码集
        request.setCharacterEncoding("UTF-8");

        //2.获取请求参数
        Map<String, String[]> map = request.getParameterMap();

        //3.将获取到的请求参数封装到User对象中
        User user = new User();

        /*
            3.1使用BeanUtils分装JavaBean数据
            参数1：封装的类
            参数2：map集合 - 请求参数返回的map集合
         */
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        //4.调用DAO方法，操作数据库
        UserDao dao = new UserDaoImpl();
        dao.addUser(user);

    }
}
