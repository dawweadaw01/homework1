package cdu.lhj;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SuccessServlet", value = "/success")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='zh-CN'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>登陆成功</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>用户登录成功</h1>");
        //获取session中的用户名
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        out.println("欢迎您，" + username);
        //注销
        out.println("<a href='logout'>注销</a>");
        out.println("</body>");
        out.println("</html>");

    }
}
