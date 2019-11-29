package com.examples.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.daos.CustomerDao;
import com.examples.daosimpl.CustomerDaoImpl;
import com.examples.models.Customer;

@WebServlet("/getAllCustomers")
public class getAllCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public getAllCustomers() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		CustomerDao daoObj=new CustomerDaoImpl();
		
		List<Customer> usersList;
		try {
			usersList = daoObj.getAllCustomers();
			//System.out.println(usersList);
			request.setAttribute("customerList",usersList);
			RequestDispatcher rd=request.getRequestDispatcher("CustomersList.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



}
