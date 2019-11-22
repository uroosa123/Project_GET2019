package com.iris.pbms.serviceimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.pbms.daos.EmployeeDao;
import com.iris.pbms.models.Employee;
import com.iris.pbms.services.EmployeeService;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService  {
	
	@Autowired
	EmployeeDao employeeDao;
	
	private SessionFactory sessionFactory;

	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

}
