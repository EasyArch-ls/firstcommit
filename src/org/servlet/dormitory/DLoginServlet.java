package org.servlet.dormitory;

import org.bean.Dormitories;
import org.bean.Students;
import org.bean.Teachers;
import org.mybatis.Dormitory;
import org.servlet.Bean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DLoginServlet" ,urlPatterns = {"/dLoginServlet"})
public class DLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        int x=1;
        int y=1;
        int z=1;
        int w=1;
        req.getSession().setAttribute("x", x);
        req.getSession().setAttribute("y", y);
        req.getSession().setAttribute("z", z);
        req.getSession().setAttribute("w", w);

        String name=req.getParameter("name");
        String password=req.getParameter("password");
        Bean bean=new Bean();
        Dormitory dormitory= bean.session.getMapper(Dormitory.class);
        String s=dormitory.dlogin(name,password);
        if( s==null|| s==""){
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }else {
            List<Dormitories> list = dormitory.findAlld();
            list = bean.queryScenicByArray(list, 1, 5);
            req.getSession().setAttribute("findAlld", list);
            /*List<Students> list1=dormitory.findAlls();
            list1= bean.queryScenicByArray(list,1,5);
            req.getSession().setAttribute("findAllx",list1);
            List<Teachers> list2  =dormitory.findAllt();
            list2 = bean.queryScenicByArray(list2, 1, 5);
            req.getSession().setAttribute("findAllt", list2);*/
            System.out.println((Integer) req.getSession().getAttribute("x")+1);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

    }
}
