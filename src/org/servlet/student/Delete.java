package org.servlet.student;

import org.mybatis.Student;
import org.mybatis.Teacher;
import org.servlet.Bean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Delete",urlPatterns = {"/delete"})
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String college=(String)req.getSession().getAttribute("college");
        String id = req.getParameter("id");
        System.out.println(id);
        Bean bean = new Bean();
            boolean b = bean.session.getMapper(Student.class).delete(id,college);
            if (b == true) {
                bean.session.commit();
                PrintWriter out = resp.getWriter();
                out.print("<script> alert(\"删除成功!\"); </script>");
            } else {
                PrintWriter out = resp.getWriter();
                out.print("<script> alert(\"删除失败!\"); </script>");
            }
        }
    }

