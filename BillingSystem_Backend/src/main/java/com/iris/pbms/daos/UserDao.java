package com.iris.pbms.daos;

import org.springframework.transaction.annotation.Transactional;

import com.iris.pbms.models.DataEntryOperator;
import com.iris.pbms.models.User;


public interface UserDao {
	 public User getUserById(int Id);
	 public User validateUser(int Id,String password);
	 public boolean setAttendance(DataEntryOperator obj);
	
	 
}
