package com.examples.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.examples.daos.CustomerDao;
import com.examples.daosimpl.CustomerDaoImpl;
import com.examples.models.Customer;


@WebServlet("/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String s1=request.getParameter("userId");
		String s2=request.getParameter("password");
		
		int id=Integer.parseInt(s1);
		
		
		CustomerDao daoObj=new CustomerDaoImpl();
		
		
		Customer userObj=daoObj.validateCustomer(id, s2);
		if(userObj!=null){
			
			HttpSession session=request.getSession();
			session.setAttribute("uObj",userObj);
			System.out.println("hi");
			if(userObj.getRole().equals("admin")){
				RequestDispatcher rd=request.getRequestDispatcher("AdminWelcome.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("CustomerWelcome.jsp");
				rd.forward(request, response);
			}
		}
		else {
			out.println("<div align='center' style='color:red'>Please check the id or password!</div>");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		
	}

}
