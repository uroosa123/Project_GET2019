package com.iris.pbms.serviceimpl;

import java.util.List;

import com.iris.pbms.daos.RolesDao;
import com.iris.pbms.daos.UserDao;
import com.iris.pbms.models.Roles;
import com.iris.pbms.services.RolesService;

import org.hibernate.Query;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("roleService")
@Transactional
public class RoleServiceImpl implements RolesService{

	@Autowired
	RolesDao roleDaoObj;

	private SessionFactory sessionFactory;//To get session factory from dbconfig.java file

	public List<Roles> getAllRoles() {

		return roleDaoObj.getAllRoles();

}
}
