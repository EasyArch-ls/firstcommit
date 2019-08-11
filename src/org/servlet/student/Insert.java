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

@WebServlet(name = "Insert", urlPatterns = {"/Insert"})
public class Insert extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String bid = req.getParameter("bid");
        String sid = req.getParameter("sid");
        String cid = req.getParameter("cid");
        String sex = req.getParameter("sex");
        String number = req.getParameter("number");
        String other = req.getParameter("other");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String college = req.getParameter("college");
        System.out.println(college+"\t"+sex);
        Bean bean = new Bean();
            boolean b = bean.session.getMapper(Student.class).insert(bid,sid,cid,name,sex,phone,number,college,other);
            if (b == true) {
                bean.session.commit();
                PrintWriter out = resp.getWriter();
                //resp.getWriter().print("<script> alert(\"添加成功!\"); </script>");
                out.print("<script> alert(\"添加成功!\"); </script>");
            } else {
                PrintWriter out = resp.getWriter();
                out.print("<script> alert(\"添加失败!\"); </script>");
            }
        }


}
