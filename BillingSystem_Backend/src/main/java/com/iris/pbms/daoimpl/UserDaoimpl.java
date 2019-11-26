package com.iris.pbms.daoimpl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.pbms.daos.UserDao;
import com.iris.pbms.models.DataEntryOperator;
import com.iris.pbms.models.ProjectAllocation;
import com.iris.pbms.models.User;

@Repository("userDao")
public class UserDaoimpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public User validateUser(int Id, String password) {
		try {
			Session session=sessionFactory.getCurrentSession();
			User userObj=session.get(User.class, Id);
			
			//If object is found with the given ID 
			if(userObj!=null){
				if(userObj.getUserpass().equals(password)){
					return userObj;
				}
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		
	}
	public User getUserById(int Id) {
		try {
			Session session=sessionFactory.getCurrentSession();
			User userObj=session.get(User.class, Id);
			return userObj;
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
	public boolean setAttendance(DataEntryOperator obj) {
		try

		{

			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from com.iris.pbms.models.DataEntryOperator where projectId=:projectId and employeeId=:employeeId");
			q.setParameter("projectId",obj.getProjectId());
			q.setParameter("employeeId",obj.getEmployeeId());
			if(q.list().size()==0) {
			session.save(obj);
			return true;

		}
		}
		catch(Exception e)

		{

			e.printStackTrace();

		}

		return false;

	}
	public List<DataEntryOperator> getAllDeoAttendance() {
		try {

			Session session=sessionFactory.getCurrentSession();

			Query q=session.createQuery("from com.iris.pbms.models.DataEntryOperator");

			return q.list();

		}

		catch(Exception e)

		{

			e.printStackTrace();

		}

		return null;
	}
	public ProjectAllocation getConfig(int id) {
		try

		{

			Session session=sessionFactory.getCurrentSession();			

			Query q=session.createQuery("from com.iris.pbms.models.ProjectAllocation where empObj.employeeId=:i ");

			q.setParameter("i",id);

			

			

			List<ProjectAllocation> allProAllocation = q.list();

			if(allProAllocation.size()==0) {

				return null;

			}

			else {

			ProjectAllocation ProAllocation = (ProjectAllocation)allProAllocation.get(0);

			System.out.println(ProAllocation);

			return ProAllocation;

			}

		}

		catch(Exception e)

		{

			e.printStackTrace();

		}

		return null;
	}
	public DataEntryOperator getDEO(Integer id, String month, int year) {
		try {

			Session session=sessionFactory.getCurrentSession();

			Query q=session.createQuery("from com.iris.pbms.models.DataEntryOperator where empObj.employeeId=:i and month=:m and year=:y");

			q.setParameter("i",id);

			q.setParameter("m",month);

			q.setParameter("y",year);

			

			List<DataEntryOperator> deoList=q.list();

			if(deoList.size()!=0) {

				System.out.println("obj");

				return deoList.get(0);

			}

		}

		catch(Exception e)

		{

			e.printStackTrace();

		}

		return null;
		
	}
	public double getBill(double perHourBilling, DataEntryOperator deo) {
		double halfDay=deo.getHalfDay()*4.5;

		double fullDay=deo.getFullDay()*9;

		double bill=((halfDay*perHourBilling)+(fullDay*perHourBilling));

		return bill;
	}
	}
	


