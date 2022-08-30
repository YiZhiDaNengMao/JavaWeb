package web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * 实现Servlet
 *
 * Servlet的生命周期：
 *  1.init => 初始化
 *  2.service => 核心方法
 *  3.destroy => 销毁
 */
public class ServletDemo01 implements Servlet {

    /*
        初始化方法 - 创建servlet对象，就进行初始化操作
        只执行一次，在处理请求前完成一些初始化操作，例如连接数据库，获取配置信息...
    */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /*
        核心方法：提供服务的方法
        每发送一次请求，执行一次服务方法
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet01");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /*
        销毁方法
        在服务器正常关闭时执行，只执行一次
     */
    @Override
    public void destroy() {

    }
}
