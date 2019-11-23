package com.iris.pbms.Controllers;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iris.pbms.daos.ProjectDao;
import com.iris.pbms.models.DataEntryOperator;
import com.iris.pbms.models.Employee;
import com.iris.pbms.models.Project;
import com.iris.pbms.models.ProjectAllocation;
import com.iris.pbms.models.ProjectConfiguration;
import com.iris.pbms.models.Roles;
import com.iris.pbms.services.EmployeeService;
import com.iris.pbms.services.ProjectService;
import com.iris.pbms.services.RolesService;
import com.iris.pbms.services.UserService;

import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class DEOController {
	
	@Autowired
    HttpSession session;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	EmployeeService employeeService;
	
	
 @RequestMapping(value="/mark",method=RequestMethod.GET)
 public ModelAndView getAttendance() throws Exception{
		
		List<Project> plist=projectService.getAllProject();
		List<Employee> elist=employeeService.getAllEmployee();
		//Roles roleObj=new Roles();
		DataEntryOperator deoObj=new DataEntryOperator();
		
		ModelAndView mv=new ModelAndView("DEO");
		mv.addObject("projList",plist);
		mv.addObject("deoObj", deoObj);
		return mv;
	}
 
 @Autowired
 ProjectDao projectDao;
 
 
 @ResponseBody
 @RequestMapping(value="/getEmployeesList",method=RequestMethod.GET)
 public List<Employee> getAllEmployees(@RequestParam("projectId")int projectId){
	 System.out.println("Given project Id : "+projectId);
	 
	 List<Employee> empList=new ArrayList<>();

	 List<ProjectConfiguration> configList=projectDao.getAllProjectConfigurations(projectId);
	 List<ProjectAllocation> allocationList=projectDao.getProjectAllocations();
	 
	 for(ProjectConfiguration config:configList) {
		 for(ProjectAllocation allocation:allocationList) {
			 if(config.getConfigurationId()==allocation.getPcObj().getConfigurationId()) {
				 Employee eObj=allocation.getdObj();
				 empList.add(eObj);
			 }
		 }
	 }
	 
	 System.out.println("empList : "+empList);
	 
	 return empList;
 }

}













