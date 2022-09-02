package servlet;

import util.DownLoadUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.io.IOException;

@WebServlet("/DownLoadServlet")
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        String filename = request.getParameter("filename");
        FileInputStream fis = new FileInputStream("javaweb03_register/download/" + filename);
        ServletOutputStream os = response.getOutputStream();
        //告知浏览器⽂件的类型：response.setContentType(⽂件的MIME类型);
        response.setContentType(
                this.getServletContext().getMimeType(filename));

        //浏览器响应头不支持中文, 需要处理filename
        String agent = request.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent,filename);

        //告示浏览器⽂件的打开⽅式是下载
        response.setHeader
                ("Content-Disposition","attachment;filename=" + filename);
        byte[] bs = new byte[1024];
        int len;
        while((len = fis.read(bs)) != -1){

        }
    }
}
