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

@WebServlet(name = "UpdateT", urlPatterns = {"/updateT"})
public class UpdateT extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String npassword = req.getParameter("npassword");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String college = req.getParameter("college");
        Bean bean = new Bean();
            int b = bean.session.getMapper(Teacher.class).update(id,name, npassword, phone, email, college);
            if (b>0) {
                bean.session.commit();
                PrintWriter out = resp.getWriter();
                out.print("<script> alert(\"修改成功!请注意重新登录\"); </script>");
            } else {
                PrintWriter out = resp.getWriter();
                out.print("<script> alert(\"修改失败!\"); </script>");
            }
        }
}

