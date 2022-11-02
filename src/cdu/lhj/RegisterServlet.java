package cdu.lhj;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;

@WebServlet(name = "RegisterServlet", value = "/reg")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //账密
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //性别
        String sex = request.getParameter("sex");
        //年龄
        String age = request.getParameter("age");
        //爱好
        String hobby = Arrays.toString(request.getParameterValues("hobby"));

        String driver = "com.mysql.cj.jdbc.Driver";  //驱动程序名称
        String url = "jdbc:mysql://localhost:3306/mydb?user=root&password=123456";
        System.out.println(username+password+sex+age+hobby);
        try {
            //加载驱动程序
            Class.forName(driver).newInstance();
            //建立数据库连接
            Connection conn = DriverManager.getConnection(url);
            //创建Statement对象
            Statement stmt = conn.createStatement();
            //执行SQL语句,添加账号,密码,性别,年龄,爱好
            String sql = "INSERT INTO user_table(username,password,sex,age,hobby)"
                    +"VALUES('"+username+"','"+password+"'," +
                    "'"+sex+"','"+age+"','"+hobby+"')";
            int rows = stmt.executeUpdate(sql);
            System.out.println(rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
