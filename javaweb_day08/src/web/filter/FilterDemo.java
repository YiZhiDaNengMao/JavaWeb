package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
    过滤器（拦截器）
 */

//拦截所有资源
@WebFilter("/*")

//拦截单个资源
//@WebFilter("/index.jsp")
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        System.out.println("filter is executed...");

        //放行 filterChain
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
