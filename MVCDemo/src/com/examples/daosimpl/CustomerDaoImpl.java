package com.examples.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import com.examples.daos.CustomerDao;
import com.examples.models.Customer;
import com.examples.utility.ConnectionProvider;

public class CustomerDaoImpl implements CustomerDao {
	Connection conn=ConnectionProvider.getConn();
	
	@Override
	public boolean registerCustomer(Customer cust)  {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("insert into Customer values(?,?,?,?,?,?,'customer')");
			ps.setInt(1,cust.getCustomerId());
			ps.setString(2,cust.getCustomerName());
			ps.setString(3,cust.getGender());
			ps.setString(4,cust.getEmailAddress());
			ps.setString(5,cust.getPassword());
			ps.setString(6,cust.getCity());
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	
	public Customer validateCustomer(int id, String password) {
		try {
		PreparedStatement ps=conn.prepareStatement("select * from customer where Id=? and password=?");
		ps.setInt(1, id);
		ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			int Id=rs.getInt(1);
			String s2=rs.getString(2);
			String s3=rs.getString(3);
			String s4=rs.getString(4);
			String s5=rs.getString(5);
			String s6=rs.getString(6);
			String s7=rs.getString(7);
			Customer emp=new Customer(Id,s2,s3,s4,s5,s6,s7);
			return emp;
			
		}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
public List<Customer> getAllCustomers() throws Exception{
		
		List<Customer> custList=new ArrayList<>();
		
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from customer where role='customer'");
		while(rs.next()){
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String gen=rs.getString(3);
			String email=rs.getString(4);
			String pass=rs.getString(5);
			String city=rs.getString(6);
			String role=rs.getString(7);
			Customer cust=new Customer();
			cust.setCustomerId(id);
			cust.setCustomerName(name);
			cust.setGender(gen);
			cust.setEmailAddress(email);
			cust.setPassword(pass);
			cust.setCity(city);
			cust.setRole(role);
			
			custList.add(cust);
			
		}
		return custList;
}

}