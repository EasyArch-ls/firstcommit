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

@WebServlet(name = "Update",urlPatterns = {"/update"})
public class Update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String bid = req.getParameter("bid");
        String sid = req.getParameter("sid");
        String cid = req.getParameter("cid");
        String other = req.getParameter("other");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String college=req.getParameter("college");
      //  System.out.println(bid+"qqqqqqqqqqqqq");
        System.out.println(college);
        Bean bean = new Bean();
            int b = bean.session.getMapper(Student.class).update(id,bid,sid,cid,name,phone,other,college);
        System.out.println(b);
            if (b >0) {
                bean.session.commit();
                PrintWriter out = resp.getWriter();
                out.print("<script> alert(\"修改成功!\"); </script>");
            } else {
                bean.session.commit();
                PrintWriter out = resp.getWriter();
                out.print("<script> alert(\"修改失败!\"); </script>");
            }
        }
}
