package cdu.lhj;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "ValidCodeServlet", value = "/validCode")
public class ValidCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random random = new Random();
        //生成随机四位字符
        String code = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer builder = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(code.length());
            builder.append(code.charAt(index));
        }
        String validCode = builder.toString();
        //将生成的验证码存入session
        HttpSession session = request.getSession();
        session.setAttribute("validCode", validCode);
        //准备图像的画笔
        int width = 60;
        int height = 22;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        //设置背景
        g.setColor(new Color(0xffcccccc));
        g.fillRect(0, 0, width, height);
        //绘制验证码
        g.setColor(Color.red);
        g.setFont(new Font("arial", Font.BOLD, 18));
        g.drawString(validCode, 5, 18);
        //禁止客户端缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //向客户端返回图像
        ImageIO.write(image, "png", response.getOutputStream());

    }
}
