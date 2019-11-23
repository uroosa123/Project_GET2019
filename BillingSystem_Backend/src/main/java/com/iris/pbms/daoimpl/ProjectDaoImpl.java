package com.iris.pbms.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iris.pbms.daos.ProjectDao;
import com.iris.pbms.models.Project;
import com.iris.pbms.models.ProjectAllocation;
import com.iris.pbms.models.ProjectConfiguration;



@Repository("projectDao")
@Transactional
public class ProjectDaoImpl implements ProjectDao{
	
	@Autowired
	SessionFactory sessionFactory;

	public List<Project> getAllProject() {
		try {

			Session session=sessionFactory.getCurrentSession();

			Query q=session.createQuery("from com.iris.pbms.models.Project");

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
	
	public Project getProjectById(int projectId)

	{

		try

		{

			Session session=sessionFactory.getCurrentSession();

			Project c=session.get(Project.class, projectId);

			return c;

		}

		catch(Exception e)

		{

			e.printStackTrace();

		}

		return null;

	}



	public List<ProjectConfiguration> getAllProjectConfig() {


		try {

			Session session=sessionFactory.getCurrentSession();

			Query q=session.createQuery("from com.iris.pbms.models.ProjectConfiguration");

			return q.list();

		}

		catch(Exception e)

		{

			e.printStackTrace();

		}

		return null;

	}

/*	public boolean setProjectConfig(ProjectConfiguration obj) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.save(obj);
			return true;
		}
		catch(Exception e)

		{

			e.printStackTrace();

		}
		return false;
	}*/

	public boolean checkProjectConfiguration(ProjectConfiguration obj) {

		try {

			Session session=sessionFactory.getCurrentSession();

			Query q=session.createQuery("from com.iris.pbms.models.ProjectConfiguration where projectId=:projectId and roleId=:roleId and location=:location");
			q.setParameter("projectId",obj.getProjectId());
			q.setParameter("roleId",obj.getRoleId());
			q.setParameter("location",obj.getLocation());
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
	
	public List<ProjectConfiguration> getAllProjectConfigNotAllocated() {

		// TODO Auto-generated method stub

		try {

			Session session=sessionFactory.getCurrentSession(); 

			Query q=session.createQuery("from ProjectConfiguration where configurationId not in(select pcObj.configurationId from ProjectAllocation)");

			return q.list();

		}

		catch(Exception e)

		{

			e.printStackTrace();

		}

		return null;

	}

	public List<ProjectConfiguration> validateProject(int projectId, int roleId, String location) {
		try {

			Session session=sessionFactory.getCurrentSession();

			Query q=session.createQuery("from com.iris.pbms.models.ProjectConfiguration where projectObj.projectId=:projectId and roleObj.roleId=:roleId and location=:location");

			 q.setParameter("projectId",projectId);

			   q.setParameter("roleId",roleId);

			   q.setParameter("location",location);

			return q.list();

		}

		catch(Exception e)

		{

			e.printStackTrace();

		}

		return null;
	}
	
	public boolean setProjectAllocation(ProjectAllocation projectAllocation) {

		try {

		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("from com.iris.pbms.models.ProjectAllocation where employeeId=:employeeId and configId=:configurationId");
		q.setParameter("employeeId",projectAllocation.getdObj().getEmployeeId());
		q.setParameter("configurationId",projectAllocation.getPcObj().getConfigurationId());
		if(q.list().size()==0) {
			session.save(projectAllocation);
			return true;
		}
		}
		catch(Exception e) {

			e.printStackTrace();

		}

		return false;

	}

	public List<ProjectConfiguration> getAllProjectConfigurations(int projectId) {
		try {

			Session session=sessionFactory.getCurrentSession();

			Query q=session.createQuery("from com.iris.pbms.models.ProjectConfiguration where projectObj.projectId=:projectId");

			 q.setParameter("projectId",projectId);

			return q.list();

		}

		catch(Exception e)

		{

			e.printStackTrace();

		}

		return null;
	}

	public List<ProjectAllocation> getProjectAllocations() {
		try {

			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from com.iris.pbms.models.ProjectAllocation");
			
			List list=q.list();
			return list;

		}

		catch(Exception e)

		{

			e.printStackTrace();

		}

		return null;
	}

}
