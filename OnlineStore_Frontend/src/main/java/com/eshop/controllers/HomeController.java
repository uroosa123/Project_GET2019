package com.eshop.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eshop.daos.ProductDao;
import com.eshop.models.Product;

@Controller
public class HomeController {
	
	
	@Autowired
	ProductDao productDao;
	
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String sayHello(ModelMap map){
		map.addAttribute("myData","Welcome to Spring Web MVC!!!");
		return "HomePage";
	}
	
	@RequestMapping(value="/getSignUpForm",method=RequestMethod.GET)
	public String addUser(ModelMap map) {
		map.addAttribute("userObj",new Product());
		map.addAttribute("btnLabel","Sign Up");
		map.addAttribute("formLabel", "SignUp Form");
		return "Register";
	}
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public ModelAndView addProduct( @ModelAttribute("userObj")  Product userObj){
		productDao.addProduct(userObj);
		ModelAndView mv=new ModelAndView("SUCCESS");
		mv.addObject("msg","PRODUCT HAS BEEN ADDED");
		return mv;
		
		}
    
	@RequestMapping(value="/viewProducts",method=RequestMethod.GET)
	public ModelAndView getAllUsers() throws Exception{
		
		List<Product> plist=productDao.getAllProducts();
		
		ModelAndView mv=new ModelAndView("UsersList");
		mv.addObject("usersList",plist);
		return mv;
	}
	
	@RequestMapping(value="/deleteUser/{uId}",method=RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable int uId) throws Exception{
		
		System.out.println("User to delete = "+uId);
		Product userObj=productDao.getProductById(uId);
		System.out.println("User Obj = "+userObj);
		
		productDao.deleteProduct(userObj);
		
		ModelAndView mv=new ModelAndView("UsersList");
		mv.addObject("usersList",productDao.getAllProducts());
		mv.addObject("msg","product deleted Succesfully...");
		return mv;
	}
	
	@RequestMapping(value="/updateUser/{uId}",method=RequestMethod.GET)
	public ModelAndView getUpdateUserForm(@PathVariable int uId){
		
		
		Product userObj=productDao.getProductById(uId);
		
		ModelAndView mv=new ModelAndView("Register");
		mv.addObject("userObj",userObj);
		mv.addObject("btnLabel","Update");
		mv.addObject("formLabel", "Update Form");
		return mv;
	}
}

