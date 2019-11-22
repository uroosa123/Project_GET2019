package com.iris.pbms.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.pbms.daos.EmployeeDao;
import com.iris.pbms.models.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	SessionFactory sessionFactory;

	public List<Employee> getAllEmployee() {
		try {

			Session session=sessionFactory.getCurrentSession();

			Query q=session.createQuery("from com.iris.pbms.models.Employee");

			if (q.list()!=null) {

				System.out.println("Not null");

				return q.list();

			} else {

				System.out.println("Null");

				return null;

			}

		}

		catch(Exception e)

		{

			e.printStackTrace();

		}

		return null;
	}

}
