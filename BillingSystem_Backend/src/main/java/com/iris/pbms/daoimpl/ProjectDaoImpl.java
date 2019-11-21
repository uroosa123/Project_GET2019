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


@Component
@Repository(value="projectDao")
@Transactional
public class ProjectDaoImpl implements ProjectDao{
	
	@Autowired

	private SessionFactory sessionFactory;

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

}
