package com.examples.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.daos.CustomerDao;
import com.examples.daosimpl.CustomerDaoImpl;
import com.examples.models.Customer;
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterController() {
        super();
        
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
	
		int s1=Integer.parseInt(request.getParameter("customerId"));
		String s2=request.getParameter("customerName");
		String s3=request.getParameter("gender");
		String s4=request.getParameter("city");
		String s5=request.getParameter("email");
		String s6=request.getParameter("password");
		
		Customer custObj=new Customer();
		custObj.setCustomerId(s1);
		custObj.setCustomerName(s2);
		custObj.setGender(s3);
		custObj.setCity(s4);
		custObj.setEmailAddress(s5);
		custObj.setPassword(s6);
		
	
		CustomerDao daoObj=new CustomerDaoImpl();
		
		boolean b=daoObj.registerCustomer(custObj);
		if(b){
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		}
		else {
			out.println("<div align='center' style='color:red'>Registeration Failed!</div>");
			RequestDispatcher rd=request.getRequestDispatcher("Registeration.jsp");
			rd.include(request, response);
		}
	}

}
