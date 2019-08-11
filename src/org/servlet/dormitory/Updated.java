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


@WebServlet(name = "Updated",urlPatterns = {"/updated"})
public class Updated extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String id=req.getParameter("id");
        String bid=req.getParameter("bid");
        String sid=req.getParameter("sid");
        String tfuze=req.getParameter("tfuze");
        String pfuze=req.getParameter("pfuze");
        String pnumber=req.getParameter("pnumber");
        String pphone=req.getParameter("pphone");
        String ttphone=req.getParameter("ttphone");
        Bean bean=new Bean();
        int b=bean.session.getMapper(Dormitory.class).dupdate(id,bid,sid,tfuze,pfuze,pnumber,pphone,ttphone);
        if(b >0){
            bean.session.commit();
            PrintWriter out=resp.getWriter();
            out.print("<script> alert(\"修改成功!\"); </script>");
        }else {
            bean.session.commit();
            PrintWriter out=resp.getWriter();
            out.print("<script> alert(\"修改失败!\"); </script>");
        }
    }
}
