package a_request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.util.Date;
import java.io.IOException;

@WebServlet("/ServletRequestDemo03")
public class ServletRequestDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取流对象
        BufferedReader reader = request.getReader();
        //2.从流中获取数据
        String line = null;
        while(( line = reader.readLine() ) != null){
            System.out.println(line);
        }
    }
}
