package com.iris.controllers;

import java.util.List;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iris.daos.UserDao;
import com.iris.models.User;
import com.iris.validators.GenerateValidator;

    @Controller
	public class HomeController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	GenerateValidator myValidator;
	
		@RequestMapping(value="/",method=RequestMethod.GET)
		public String sayHello(ModelMap map){
			//can perform business logic here
			map.addAttribute("myData","Welcome to Spring Web MVC!!!");
			
			return "HomePage";
		}
		
		@RequestMapping(value="/getSignUpForm",method=RequestMethod.GET)
		public String addUser(ModelMap map) {
			map.addAttribute("userObj",new User());
			map.addAttribute("btnLabel","Sign Up");
			map.addAttribute("formLabel", "SignUp Form");
			return "Register";
		}
		
		@RequestMapping(value="/registerUser",method=RequestMethod.POST)
		public ModelAndView registerUser(@Valid @ModelAttribute("userObj")  User userObj,
				BindingResult result){
			//Will write the code to insert the object into the database
			
			myValidator.validate(userObj, result);
			
			if(result.hasErrors()){
				System.out.println("I m here..");
				ModelAndView mv=new ModelAndView("Register");
				//mv.addObject("userObj",new User());
				mv.addObject("btnLabel","Sign Up");
				mv.addObject("formLabel", "SignUp Form");
				return mv;
			}
			else {
			userObj.setRole("customer");
			userDao.registerUser(userObj);
			
			ModelAndView mv=new ModelAndView("LogInForm");
			mv.addObject("msg","User has been registered succesfully. Now u can Login");
			return mv;
			}
		}
		
		@RequestMapping(value="/getSignInForm",method=RequestMethod.GET)
		public String getSignInForm(){
			return "LogInForm";
		}
		@Autowired
		HttpSession session;
		
		@RequestMapping(value="/signIn",method=RequestMethod.POST)
		public String validateUser(@RequestParam int userId,@RequestParam String pass,ModelMap map){
			User uObj=userDao.validateUser(userId,pass);
			if(uObj!=null){
				
				session.setAttribute("uObj",uObj);
				System.out.println("hi");
				if(uObj.getRole().equals("admin")){
					return "Admin";
				}
				else {
					session.setAttribute("uObj",uObj);
					return "Success";
				}
			}
			else {
				map.addAttribute("msg1", "user not found!Please check details!");
				return "LogInForm";
			}
			
		}
		
		@RequestMapping(value="/viewAllUsers",method=RequestMethod.GET)
		public ModelAndView getAllUsers() throws Exception{
			
			List<User> users=userDao.getAllUsers();
			
			ModelAndView mv=new ModelAndView("UsersList");
			mv.addObject("usersList",users);
			return mv;
		}
		
		@RequestMapping(value="/deleteUser/{uId}",method=RequestMethod.GET)
		public ModelAndView deleteUser(@PathVariable int uId) throws Exception{
			
			System.out.println("User to delete = "+uId);
			User userObj=userDao.getUserById(uId);
			System.out.println("User Obj = "+userObj);
			
			userDao.deleteUser(userObj);
			
			ModelAndView mv=new ModelAndView("UsersList");
			mv.addObject("usersList",userDao.getAllUsers());
			mv.addObject("msg","User deleted Succesfully...");
			return mv;
		}
		
		@RequestMapping(value="/updateUser/{uId}",method=RequestMethod.GET)
		public ModelAndView getUpdateUserForm(@PathVariable int uId){
			
			
			User userObj=userDao.getUserById(uId);
			
			ModelAndView mv=new ModelAndView("Register");
			mv.addObject("userObj",userObj);
			mv.addObject("btnLabel","Update");
			mv.addObject("formLabel", "Update Form");
			return mv;
		}
}
