package com.iris.pbms.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iris.pbms.models.User;
import com.iris.pbms.services.UserService;


@Controller
public class HomeController {

	@Autowired
    HttpSession session;
	
	@Autowired
	UserService userService;

	@RequestMapping(value= "/", method=RequestMethod.GET)
	public String home() {

		return "HomePage";

	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getSignInForm(){
		return "LoginForm";
	}

	@RequestMapping(value="/signIn",method=RequestMethod.POST)
	public String validateUser(@RequestParam int userId,@RequestParam String pass,ModelMap map){
		User uObj=userService.validateUser(userId,pass);
		if(uObj!=null){
			
			session.setAttribute("uObj",uObj);
			System.out.println("hi");
			if(uObj.getUserRole().equals("admin")){
				return "Admin";
			}
			else if(uObj.getUserRole().equals("DEO")) {
				session.setAttribute("uObj",uObj);
				return "DEO";
			}
			else {
				session.setAttribute("uObj",uObj);
				return "Manager";
			}
		}
		else {
			map.addAttribute("msg1", "user not found!Please check details!");
			return "LoginForm";
		}
		
	}

}
