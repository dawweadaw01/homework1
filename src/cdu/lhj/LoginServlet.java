package cdu.lhj;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //得到用户输入的验证码和账号密码
        String inputCode = request.getParameter("inputCode");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String saveUser = request.getParameter("saveUser");
        //处理的cookie
        Cookie cUser = new Cookie("username", username);
        Cookie cPwd = new Cookie("password", password);
        if (saveUser != null && saveUser.equals("on")) {
            cUser.setMaxAge(60 * 60 * 24);
            cPwd.setMaxAge(60 * 60 * 24);
        } else {
            cUser.setMaxAge(0);
            cPwd.setMaxAge(0);
        }
        response.addCookie(cUser);
        response.addCookie(cPwd);
        //得到session中的验证码
        HttpSession session = request.getSession();
        //判断验证码是否为空，是否正确
        String validCode = (String) session.getAttribute("validCode");
        if (validCode == null || validCode.equals("") || !validCode.equalsIgnoreCase(inputCode)) {
            //验证码错误
            request.setAttribute("msg", "验证码错误");
            response.sendRedirect("loginPage");
            return;
        }
        //判断账号密码是否为空
        if (username == null || password == null || username.equals("") || password.equals("")) {
            //账号密码为空
            response.sendRedirect("loginPage");
            return;
        }
        //判断账号密码是否正确
        if (username.equals("cxk") && password.equals("666")) {
            //账号密码正确
            response.sendRedirect("success");
            return;
        } else {
            //账号密码错误
            response.sendRedirect("loginPage");
        }
    }
}
