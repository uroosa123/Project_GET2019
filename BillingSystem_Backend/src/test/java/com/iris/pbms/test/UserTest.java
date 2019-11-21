package com.iris.pbms.test;

import static java.lang.System.out;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;  //Static import

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.iris.pbms.config.DBconfig;
import com.iris.pbms.daos.UserDao;
import com.iris.pbms.models.User;

public class UserTest {
	
	private static UserDao userdaoobj;
	
	@BeforeClass
	public static void init(){
		out.println("I m in init - start");
		//Created the object of Spring container
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBconfig.class);
		
		userdaoobj=context.getBean(UserDao.class,"userDao");
   	 	out.println("I m in init - end");
	}
	
	@Test
	@Ignore
	public void getUserTest() {
		User uObj=userdaoobj.getUserById(786);
		assertNotNull("user with given id doesnt exist", uObj);
	}
	
	@Test
	@Ignore
	public void showUserTest(){
		User p=new User();
		User r=userdaoobj.validateUser(786,"admin@123");
		assertNotNull("user does not exist", r);
	}

}
