package com.iris.pbms.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.iris.pbms.models.DataEntryOperator;
import com.iris.pbms.models.ProjectConfiguration;
import com.iris.pbms.models.User;


public interface UserService {
	 public User getUserById(int Id);
	 public User validateUser(int Id,String password);
	 List<ProjectConfiguration> getAllProjectConfig();
	 public boolean setAttendance(DataEntryOperator obj);

	

}
