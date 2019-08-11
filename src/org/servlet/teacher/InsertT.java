package org.servlet.teacher;

import org.mybatis.Teacher;
import org.servlet.Bean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "InsertT",urlPatterns = {"/InsertT"})
public class InsertT extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String phone=req.getParameter("phone");
        String email=req.getParameter("email");
        String college=req.getParameter("college");
        Bean bean=new Bean();
        boolean bb=bean.session.getMapper(Teacher.class).findemail(email);
        if(bb!=true){
            boolean b=bean.session.getMapper(Teacher.class).insert(name,password,phone,email,college);
            if(b==true){
                bean.session.commit();
                PrintWriter out=resp.getWriter();
                resp.getWriter().print("<script> alert(\"请确认您的账号密码!\"); </script>");
                out.print("<script> alert(\"添加成功!\"); </script>");
            }else {
                PrintWriter out=resp.getWriter();
                out.print("<script> alert(\"添加失败!\"); </script>");
            }
        }else {
            PrintWriter out=resp.getWriter();
            out.print("<script> alert(\"email已存在!\"); </script>");
        }

    }
}
