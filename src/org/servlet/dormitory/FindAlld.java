package org.servlet.dormitory;

import org.bean.Dormitories;
import org.bean.Students;
import org.mybatis.Dormitory;
import org.servlet.Bean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindAlld", urlPatterns = {"/findAlld"})
public class FindAlld extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String currpage = String.valueOf(req.getSession().getAttribute("x"));
        String operation = req.getParameter("operation");
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
        Bean bean = new Bean();
        Dormitory dormitory = bean.session.getMapper(Dormitory.class);
        List<Dormitories> list = dormitory.findAlld();
        list = bean.queryScenicByArray(list, currentePage, 5);
        if(list.size()==0){
            req.getSession().setAttribute("x",currentePage-1);
        }
        req.setAttribute("findAlld", list);
        req.getRequestDispatcher("slist.jsp").forward(req, resp);
    }
}
