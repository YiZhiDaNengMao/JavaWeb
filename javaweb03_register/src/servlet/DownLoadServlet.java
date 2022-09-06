package servlet;

import util.DownLoadUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
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
        //设置响应的编码集和浏览器解析方式
//        response.setContentType("text/html;charset=utf-8");
        System.out.println(response.getCharacterEncoding());
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type","text/html;charset=utf-8");

        //1.获取要下载的文件名称 -> 获取请求参数
        String filename = request.getParameter("filename");
        System.out.println(filename);

        //2.实现文件的下载(文件的复制) -> 字节流
        ServletOutputStream os = response.getOutputStream();
        //获取路径 : /download + 动态值
        String path = getServletContext().getRealPath("/download/"+ filename);

        //3.将读取到的内容写入
        FileInputStream fis = new FileInputStream(path);

        //3.1告知浏览器⽂件的类型：response.setContentType(⽂件的MIME类型);
        response.setContentType(
                this.getServletContext().getMimeType(filename));

        //5.浏览器响应头不支持中文, 需要处理filename
//        String agent = request.getHeader("user-agent");
//        filename = DownLoadUtils.getFileName(agent,filename);

        //3.2告诉浏览器⽂件的打开⽅式是下载
        response.setHeader
                ("Content-Disposition","attachment;filename=" + filename);

        //4.文件的复制
        byte[] bs = new byte[1024];
        int len;
        while((len = fis.read(bs)) != -1){
            os.write(bs);
        }
    }
}
