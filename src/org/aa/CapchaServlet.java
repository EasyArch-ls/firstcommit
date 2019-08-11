package org.aa;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
@WebServlet(name = "CapchaServlet" ,urlPatterns = {"/capchaServlet"})
public class CapchaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /*
    防止异常
     */
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        Object attribute=req.getParameter("method");
        String method="";
            if (attribute!=null){
                method=attribute.toString();
            }
    /*
    "GetVCode".equals(method) 防止异常
     */
            if ("GetVCode".equals(method)){

                getVCode(req,resp);
                return;
            }



    }

    public void getVCode(HttpServletRequest req, HttpServletResponse resp) {
        CpachaUtil cpachaUtil=new CpachaUtil();
        /*
        验证码
         */
        String generatorVCode=cpachaUtil.generatorVCode();
        //将生成的验证码保存到session中
        req.getSession().setAttribute("loginCpacha",generatorVCode);
        //System.out.println( req.getSession().getAttribute("generatorVCode")+"1111111111111111");
        /*

         */
        BufferedImage  generatorRotateVCodeImage=cpachaUtil.generatorRotateVCodeImage(generatorVCode,true);
        try {
            ServletOutputStream outputStream=resp.getOutputStream();
            ImageIO.write(generatorRotateVCodeImage,"gif",outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
