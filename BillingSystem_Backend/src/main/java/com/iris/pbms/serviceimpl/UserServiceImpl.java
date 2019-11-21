package com.iris.pbms.serviceimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.pbms.daos.UserDao;
import com.iris.pbms.models.User;
import com.iris.pbms.services.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDaoObj;
	
	public User validateUser(int Id, String password) {
		//some business logic...
		return userDaoObj.validateUser(Id, password);
		
	}
	public User getUserById(int Id) {
		return userDaoObj.getUserById(Id);
		}
	}


