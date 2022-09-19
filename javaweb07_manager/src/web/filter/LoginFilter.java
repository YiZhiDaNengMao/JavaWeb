package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //1.强制转换成Servlet中使用的HttpServletRequest
        HttpServletRequest req = (HttpServletRequest) request;
        //2.获取请求资源路径
        String uri = req.getRequestURI();
        //3.判断是否包含和登录相关的资源(cs/js/验证码)
        if(uri.contains("/login.jsp")
                || uri.contains("/LoginServlet")
                || uri.contains("/css/")
                || uri.contains("/js/")
                || uri.contains("/fonts/")
                || uri.contains("/checkCode")){
            chain.doFilter(request, response);
        } else {
            //4.不包含登录验证所需资源 - 判断登录状态
            //判断session域中是否存在有user用户
            Object user = req.getSession().getAttribute("user");
            if(user != null){
                chain.doFilter(request, response);
            } else {
                req.setAttribute("msg","尚未登录，请登录！！");
                req.getRequestDispatcher("/login.jsp").forward(req,response);
            }

        }


    }
}
