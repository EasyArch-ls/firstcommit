package org.servlet.student;

import org.bean.Students;
import org.mybatis.Dormitory;
import org.mybatis.Student;
import org.servlet.Bean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindAll",urlPatterns = {"/findAll"})
public class FindAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String college=req.getParameter("college");
       // String college1=(String) req.getSession().getAttribute("college");
        String currpage = String.valueOf(req.getSession().getAttribute("q"));
        String operation = req.getParameter("operation");
       // System.out.println(college1+"aaaaaaaaa");
        int currentePage = 1;
        if (operation != null) {
            if(operation.equals("-")){
                currentePage=Integer.parseInt(currpage)-1;
                if(currentePage<1){
                    currentePage = 1;
                }
                req.getSession().setAttribute("x",currentePage);
            }else {
                currentePage=Integer.parseInt(currpage)+1;
                req.getSession().setAttribute("x",currentePage);
            }
        }
        Bean bean=new Bean();
        Student student=bean.session.getMapper(Student.class);
        List<Students> list=student.findAll(college);
        list= bean.queryScenicByArray(list,currentePage,5);
        if(list.size()==0){
            req.getSession().setAttribute("x",currentePage-1);
        }
        req.getSession().setAttribute("findAll",list);
        req.getRequestDispatcher("tslist.jsp").forward(req,resp);
    }
}
