package cdu.lhj;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "LoginPageServlet", value = "/loginPage")
public class LoginPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        //读取cookie
        String username = "";
        String password = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("username")) {
                username = c.getValue();
            }
            if (c.getName().equals("password")) {
                password = c.getValue();
            }
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>用户登录差不多得了😓</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>用户登录</h1>");
        out.println("<form action='login' method='post'>");
        out.println("用户名：<input type='text' name='username' value='"+username+"'><br>");
        out.println("密码： <input type='password' name='password' value='"+password+"'><br>");
        out.println("验证码：<input type='text' name='inputCode'>");
        out.println("<img src='validCode' width='60' height='22'<br>");
        out.println("<input type='checkbox' name='saveUser'>保存用户名和密码<br>");
        out.println("<input type='submit' value='登录'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
