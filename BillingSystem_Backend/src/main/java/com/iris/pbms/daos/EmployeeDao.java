package com.iris.pbms.daos;

import java.util.List;

import com.iris.pbms.models.Employee;



public interface EmployeeDao {
	public List<Employee> getAllEmployee();
	public List<Employee> getAllEmployeeNotAllocated();
	public Employee getEmployeeById(int id);

}
