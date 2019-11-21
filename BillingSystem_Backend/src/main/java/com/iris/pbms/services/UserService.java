package com.iris.pbms.services;

import org.springframework.transaction.annotation.Transactional;

import com.iris.pbms.models.User;


public interface UserService {
	 public User getUserById(int Id);
	 public User validateUser(int Id,String password);
}
