package org.aa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "Loginservlet" ,urlPatterns = {"/Loginservlet"})
public class Loginservlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7544229292465535287L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Object attribute = request.getParameter("method");

		String method = "";
		if(attribute != null){
	      method =  attribute.toString();
		}
		if ("GetVCode".equals(method)){

			new CapchaServlet().getVCode(request,response);
			return;
		}

		if("Login".equals(method)){
			System.out.println(request.getSession().getAttribute("loginCpacha"));
			System.out.println(request.getParameter("vcode"));
			request.setAttribute("yezheng",request.getSession().getAttribute("loginCpacha"));
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.println(request.getSession().getAttribute("loginCpacha"));
 //           request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

	}
}
		
		

