package org.servlet.teacher;

import org.bean.Students;
import org.bean.Teachers;
import org.mybatis.Student;
import org.mybatis.Teacher;
import org.servlet.Bean;
import org.servlet.student.FindAll;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TLoginServlet" ,urlPatterns = {"/tLoginServlet"})
public class TLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        int q=1;
        req.getSession().setAttribute("q", q);
        String name=req.getParameter("name");
        System.out.println(name);
        String password=req.getParameter("password");
        System.out.println(name+"\t"+password);
        Bean bean=new Bean();
        Teacher teacher = bean.session.getMapper(Teacher.class);
        Teachers s=teacher.login(name,password);
        System.out.println(s);
        if( s==null){
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }else {
            String college=s.getCollege();
            System.out.println(college);
            Student student=bean.session.getMapper(Student.class);
            List<Teachers> list1=new ArrayList<>();
            list1.add(s);
            req.setAttribute("findAllt",list1);
            List<Students> list=student.findAll(college);
            list= bean.queryScenicByArray(list,1,5);
            req.getSession().setAttribute("college",college);
            req.getSession().setAttribute("findAll",list);
            req.getRequestDispatcher("indext.jsp").forward(req,resp);
        }
    }
}
