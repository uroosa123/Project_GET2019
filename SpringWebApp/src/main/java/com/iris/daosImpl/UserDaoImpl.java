package com.iris.daosImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.daos.UserDao;
import com.iris.models.User;

@Repository("userDao")
	public class UserDaoImpl implements UserDao {

		@Autowired
		SessionFactory sessionFactory;
		
		
		
		public boolean registerUser(User userObj) {
			try {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(userObj);
			return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return false;
		}

		
		
		public User validateUser(int Id, String password) {
			try {
			Session session=sessionFactory.getCurrentSession();
			User userObj=session.get(User.class, Id);
			
			//If object is found with the given ID 
			if(userObj!=null){
				if(userObj.getPassword().equals(password)){
					return userObj;
				}
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}



		public List<User> getAllUsers() throws Exception {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("FROM com.iris.models.User where role='customer'");
			List<User> ulist=q.list();
			return ulist;
		}
		
		
		
		public boolean deleteUser(User userObj) {
			try {
				Session session=sessionFactory.getCurrentSession();
				session.delete(userObj);
				return true;
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return false;

		}

		
		
		public boolean updateUser(User userObj) {
			try {
				Session session=sessionFactory.getCurrentSession();
				session.update(userObj);
				return true;
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return false;

			
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
