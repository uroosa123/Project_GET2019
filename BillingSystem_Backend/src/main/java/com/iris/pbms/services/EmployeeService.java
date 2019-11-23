package com.iris.pbms.services;
import java.util.List;

import com.iris.pbms.models.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployee();
	public List<Employee> getAllEmployeeNotAllocated();
	public Employee getEmployeeById(int id);
}
