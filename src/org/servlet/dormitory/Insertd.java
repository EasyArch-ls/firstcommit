package org.servlet.dormitory;

import org.mybatis.Dormitory;
import org.mybatis.Teacher;
import org.servlet.Bean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Insertd",urlPatterns = {"/Insertd"})
public class Insertd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String bid=req.getParameter("bid");
        String sid=req.getParameter("sid");
        String tfuze=req.getParameter("tfuze");
        String pfuze=req.getParameter("pfuze");
        String pnumber=req.getParameter("pnumber");
        String pphone=req.getParameter("pphone");
        String ttphone=req.getParameter("ttphone");
        Bean bean=new Bean();
            boolean b=bean.session.getMapper(Dormitory.class).dinsert(bid,sid,tfuze,pfuze,pnumber,pphone,ttphone);
            if(b==true){
                bean.session.commit();
                PrintWriter out=resp.getWriter();
                resp.getWriter().print("<script> alert(\"请确认您的账号密码!\"); </script>");
                out.print("<script> alert(\"添加成功!\"); </script>");
            }else {
                PrintWriter out=resp.getWriter();
                out.print("<script> alert(\"添加失败!\"); </script>");
            }
        }
}
