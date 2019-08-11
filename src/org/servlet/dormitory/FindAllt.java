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
@WebServlet(name = "FindAllt" ,urlPatterns = {"/findAllt"})
public class FindAllt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String currpage = String.valueOf(req.getSession().getAttribute("y"));
        String operation = req.getParameter("operation");
        int currentePage=1;
        if (operation != null) {
            if(operation.equals("-")){
                currentePage=Integer.parseInt(currpage)-1;
                if(currentePage<1){
                    currentePage = 1;
                }
                req.getSession().setAttribute("y",currentePage);
            }else {
                currentePage=Integer.parseInt(currpage)+1;
                req.getSession().setAttribute("y",currentePage);
            }
        }
        Bean bean=new Bean();
        Dormitory dormitory=bean.session.getMapper(Dormitory.class);
        List<Teachers> list=dormitory.findAllt();
        list= bean.queryScenicByArray(list,currentePage,5);
        if(list.size()==0){
            req.getSession().setAttribute("y",currentePage-1);
        }
        req.setAttribute("findAllt",list);
        req.getRequestDispatcher("tlist.jsp").forward(req,resp);
    }
}
