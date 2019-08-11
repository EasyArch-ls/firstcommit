package org.servlet.dormitory;

import email.Sendemail;
import org.bean.Manager;
import org.mybatis.Dormitory;
import org.servlet.Bean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Findemail",urlPatterns = {"/findemail"})
public class Findemail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String email=req.getParameter("email");
        Bean bean=new Bean();
        Dormitory dormitory=bean.session.getMapper(Dormitory.class);
        Manager manager =dormitory.findemail(email);
        if (manager==null){
            req.getRequestDispatcher("emailerror.jsp").forward(req,resp);
        }else {
            try {
                String varify=new Sendemail().sendemail(email,manager.getName());
                PrintWriter out = resp.getWriter();
                out.print(varify+"-"+manager.getName()+"-"+manager.getPassword());
                System.out.println(manager.getPassword());
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
