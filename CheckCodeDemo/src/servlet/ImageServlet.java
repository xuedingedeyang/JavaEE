package servlet;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedImage bi = new BufferedImage(68,22,BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        Color c = new Color(200,150,255);
        g.setColor(c);
        g.fillRect(0,0,68,22);

        char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random r = new Random();
        int len = ch.length,index;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            index = r.nextInt(len);
            g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
            g.drawString(ch[index]+"",(i*15)+3,18);
            sb.append(ch[index]);
        }
        req.getSession().setAttribute("picCode",sb.toString());
        ImageIO.write(bi,"JPG",resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
