package servlet.a_cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;

/*
案例: 记住上一次访问时间
    需求：
	1.访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
	2.如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串
 */
@WebServlet("/CookieServletDemo")
public class CookieServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        Cookie[] cookies = request.getCookies();
        //1.将当前时间转换为字符串
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String now = sdf.format(date);
        //处理不支持特殊字符的问题
        now = URLEncoder.encode(now,"utf8");

        //2.创建Cookie对象
        Cookie cookie = new Cookie("date",now);
        cookie.setMaxAge(-1);

        //3.第一次访问标志
        boolean flag = true;
        if(cookies != null && cookies.length != 0){
            for(Cookie c : cookies){
                if(c.getName().equals("date")) {
                    flag = false;
                    response.getWriter().write("欢迎，您上次访问时间为:" + c.getValue());
                    response.addCookie(cookie);
                }
            }
        }

        if(cookies == null || cookies.length == 0 || flag){
            response.getWriter().write("您好，欢迎您首次访问");
            response.addCookie(cookie);
        }
    }
}
