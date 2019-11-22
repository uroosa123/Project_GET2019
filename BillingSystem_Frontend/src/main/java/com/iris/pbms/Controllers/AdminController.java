package com.iris.pbms.Controllers;

import org.springframework.stereotype.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.iris.pbms.models.Employee;
import com.iris.pbms.models.Project;
import com.iris.pbms.models.ProjectConfiguration;
import com.iris.pbms.models.Roles;
import com.iris.pbms.services.EmployeeService;
import com.iris.pbms.services.ProjectService;
import com.iris.pbms.services.RolesService;
import com.iris.pbms.services.UserService;


@Controller
public class AdminController {
	
	@Autowired
    HttpSession session;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	RolesService roleService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/configure",method=RequestMethod.GET)
	public ModelAndView getAllconfigure() throws Exception{
		
		List<ProjectConfiguration> projCon=userService.getAllProjectConfig();
		List<Project> plist=projectService.getAllProject();
		List<Roles> rlist=roleService.getAllRoles();
		//Roles roleObj=new Roles();
		ProjectConfiguration projObj=new ProjectConfiguration();
		
		ModelAndView mv=new ModelAndView("configure");
		mv.addObject("configList", projCon);
		mv.addObject("projList",plist);
		System.out.println(plist);
		mv.addObject("roleList",rlist);
		//mv.addObject("roleob",roleObj);
		mv.addObject("pObj", projObj);
		return mv;
	}
	
	@RequestMapping(value="/submitConfig",method=RequestMethod.GET)
	public ModelAndView setConfig(@ModelAttribute(name="pObj") ProjectConfiguration pObj) throws Exception{
		
		System.out.println(pObj);
		boolean saved=projectService.setProjectConfig(pObj);
		System.out.println("saved : "+saved);
		
		
		List<ProjectConfiguration> projCon=userService.getAllProjectConfig();
		List<Project> plist=projectService.getAllProject();
		List<Roles> rlist=roleService.getAllRoles();
		//Roles roleObj=new Roles();
		ProjectConfiguration projObj=new ProjectConfiguration();
		
		ModelAndView mv=new ModelAndView("configure");
		mv.addObject("configList", projCon);
		mv.addObject("projList",plist);
		System.out.println(plist);
		mv.addObject("roleList",rlist);
		//mv.addObject("roleob",roleObj);
		mv.addObject("pObj", projObj);
		
		if(saved) {
			mv.addObject("msg", "Configuration done!");
			return mv;
			
		}
		else {
		mv.addObject("msg", "Configuration error!");
		return mv;
		}
	}
	
	@RequestMapping(value="/allocate",method=RequestMethod.GET)
	public ModelAndView getAllocated() throws Exception{
		List<Project> plist=projectService.getAllProject();
		List<Roles> rlist=roleService.getAllRoles();
		List<Employee> elist=employeeService.getAllEmployee();
		ModelAndView mv=new ModelAndView("allocate");
		mv.addObject("projList",plist);
		mv.addObject("roleList",rlist);
		mv.addObject("empList",elist);
		return mv;

}
}
