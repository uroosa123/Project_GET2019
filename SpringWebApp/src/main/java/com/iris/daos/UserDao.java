package com.iris.daos;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.iris.models.User;

@Transactional
public interface UserDao {
	  
		public boolean registerUser(User userObj);
	    public User validateUser(int Id,String password);
	    public List<User> getAllUsers() throws Exception;
	    public boolean deleteUser(User  userObj);
		public boolean updateUser(User userObj);
		public User getUserById(int Id);
}


