package com.iris.pbms.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.pbms.daos.UserDao;
import com.iris.pbms.models.User;

@Repository("userDao")
public class UserDaoimpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public User validateUser(int Id, String password) {
		try {
			Session session=sessionFactory.getCurrentSession();
			User userObj=session.get(User.class, Id);
			
			//If object is found with the given ID 
			if(userObj!=null){
				if(userObj.getUserpass().equals(password)){
					return userObj;
				}
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		
	}
	public User getUserById(int Id) {
		try {
			Session session=sessionFactory.getCurrentSession();
			User userObj=session.get(User.class, Id);
			return userObj;
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
	}


