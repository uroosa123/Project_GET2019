package com.examples.daos;



import java.util.List;

import com.examples.models.Customer;

public interface CustomerDao {
	public boolean registerCustomer(Customer cust) ;
public Customer validateCustomer(int Id,String password);
public List<Customer> getAllCustomers() throws Exception;
	

}
