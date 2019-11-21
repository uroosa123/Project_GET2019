package com.iris.pbms.daoimpl;

import java.util.List;

import com.iris.pbms.daos.RolesDao;
import com.iris.pbms.models.Roles;

import org.hibernate.Query;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;


@Component
@Repository(value="roleDao")
@Transactional
public class RoleDaoImpl implements RolesDao{

	@Autowired

	private SessionFactory sessionFactory;//To get session factory from dbconfig.java file

	public List<Roles> getAllRoles() {

		try {

			Session session=sessionFactory.getCurrentSession();

			Query q=session.createQuery("from com.iris.pbms.models.Roles");

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
