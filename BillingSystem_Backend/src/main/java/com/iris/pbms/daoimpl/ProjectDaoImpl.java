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
	

}
