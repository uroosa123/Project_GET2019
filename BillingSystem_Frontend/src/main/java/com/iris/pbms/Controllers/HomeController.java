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
				map.addAttribute(uObj);
				return "Admin";
			}
			else if(uObj.getUserRole().equals("DEO")) {
				map.addAttribute("uObj",uObj);
				
				return "WelcomeDeo";
			}
			else {
				map.addAttribute("uObj",uObj);
				return "Manager";
			}
		}
		else {
			map.addAttribute("msg1", "user not found!Please check details!");
			return "LoginForm";
		}
		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)

	public String logout() {

		session.removeAttribute("uObj");

		session.invalidate();

		return "HomePage";

	}
	
	@RequestMapping(value="/HOME", method=RequestMethod.GET)

	public String HOME() {
		return "Admin";
	}
	
	@RequestMapping(value="/HOMEe", method=RequestMethod.GET)

	public String HOMEe() {
		return "WelcomeDeo";
	}


}
