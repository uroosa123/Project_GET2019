package com.iris.pbms.serviceimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.pbms.daos.ProjectDao;
import com.iris.pbms.daos.UserDao;
import com.iris.pbms.models.DataEntryOperator;
import com.iris.pbms.models.Project;
import com.iris.pbms.models.ProjectAllocation;
import com.iris.pbms.models.ProjectConfiguration;
import com.iris.pbms.models.User;
import com.iris.pbms.services.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDaoObj;
	
	@Autowired
	ProjectDao projectDaoobj;
	
	public User validateUser(int Id, String password) {
		//some business logic...
		return userDaoObj.validateUser(Id, password);
		
	}
	public User getUserById(int Id) {
		return userDaoObj.getUserById(Id);
		}
	public List<ProjectConfiguration> getAllProjectConfig() {
		return projectDaoobj.getAllProjectConfig();
	}
	public boolean setAttendance(DataEntryOperator obj) {
		return userDaoObj.setAttendance(obj);
	}
	
	
	
	}


