package org.servlet.teacher;

import email.Sendemail;
import org.bean.Teachers;
import org.mybatis.Dormitory;
import org.mybatis.Teacher;
import org.servlet.Bean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Findemailt",urlPatterns = {"/findemailt"})
public class Findemailt extends HttpServlet {
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
        Teacher teacher=bean.session.getMapper(Teacher.class);
        Teachers teachers =teacher.email(email);
        if (teachers==null){
            req.getRequestDispatcher("emailerror.jsp").forward(req,resp);
        }else {
            try {
                String varify=new Sendemail().sendemail(email,teachers.getName());
                PrintWriter out = resp.getWriter();
                out.print(varify+"-"+teachers.getName()+"-"+teachers.getPassword());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
