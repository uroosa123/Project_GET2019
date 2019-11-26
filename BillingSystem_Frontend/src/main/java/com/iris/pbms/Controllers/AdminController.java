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
	
	public boolean checkSession(ModelMap map) {
		if(session.getAttribute("uObj")==null) {
			map.addAttribute("msg","Session does not exist");
			return true;
		}
		return false;
	}
	
	@RequestMapping(value="/configure",method=RequestMethod.GET)
	public ModelAndView getAllconfigure(ModelMap map) throws Exception{
		
		if(checkSession(map)) {
			ModelAndView mv=new ModelAndView("LoginForm");
			return mv;
		}
		
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
	public ModelAndView setConfig(@ModelAttribute(name="pObj") ProjectConfiguration pObj,ModelMap map) throws Exception{
		
		if(checkSession(map)) {
			ModelAndView mv=new ModelAndView("LoginForm");
			return mv;
		}
		
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
	public ModelAndView getAllocated(ModelMap map) throws Exception{
		
		if(checkSession(map)) {
			ModelAndView mv=new ModelAndView("LoginForm");
			return mv;
		}
		List<Project> plist=projectService.getAllProject();
		List<Roles> rlist=roleService.getAllRoles();
		List<Employee> elist=employeeService.getAllEmployee();
		ModelAndView mv=new ModelAndView("allocate");
		mv.addObject("projList",plist);
		mv.addObject("roleList",rlist);
		mv.addObject("empList",elist);
		return mv;}
	
	@RequestMapping(value="/submitAllocate",method=RequestMethod.GET)

	public String validateConfigr(@RequestParam int projectId,@RequestParam int roleId,@RequestParam String location,@RequestParam int employeeId,ModelMap map){

		System.out.println(projectId+""+roleId+""+location+""+employeeId);
		
		if(checkSession(map)) {
			return "LoginForm";
		}
		
		List<Project> plist=projectService.getAllProject();
		List<Roles> rlist=roleService.getAllRoles();
		List<Employee> elist=employeeService.getAllEmployee();
		map.addAttribute("projList",plist);
		map.addAttribute("roleList",rlist);
		map.addAttribute("empList",elist);

	List<ProjectConfiguration> Obj=projectService.validateProject(projectId,roleId,location);

	ProjectConfiguration configObj=Obj.get(0);

	Employee devObj=employeeService.getEmployeeById(employeeId);

	ProjectAllocation ab=new ProjectAllocation();

	
	ab.setdObj(devObj);

	ab.setPcObj(configObj);

	boolean saved=projectService.setProjectAllocation(ab);
	if(saved) {
		map.addAttribute("msg","Allocation done");
		return "allocate";
		
	}
	else {
		map.addAttribute("msg","Allocation error");
	return "allocate";
	}

	}
	
	@RequestMapping(value= "/viewReport",method=RequestMethod.GET)

	public String DevBill(ModelMap map)

	{	

		if(checkSession(map)) {

			return "LoginForm";

		}

		

		//List<ProjectAllocation> dList = adminDao.getAllAllocate();

		List<DataEntryOperator> dList=userService.getAllDeoAttendance();

		map.addAttribute("devL", dList);

		return "viewEmployee";

	}

	

	@RequestMapping(value= "/Billing",method=RequestMethod.GET)

	public ModelAndView DevBills(@RequestParam(name="month") String month,@RequestParam(name="employeeId") int employeeId,@RequestParam(name="year") int year,ModelMap map)

	{	

		if(checkSession(map)) {

			return new ModelAndView("LoginForm");

		}

		

		try 

		{

			System.out.println("month");

			ProjectAllocation configObj = userService.getConfig(employeeId);

			double perHourBilling=configObj.getPcObj().getPerHourBilling();

			String name = employeeService.getEmployeeById1(employeeId);

			map.addAttribute("name", name);

			DataEntryOperator deo=userService.getDEO(employeeId, month,year);

			System.out.println(deo.getfullDay());

			double bill = userService.getBill(perHourBilling,deo);

			map.addAttribute("bill",bill);

			map.addAttribute("de", employeeId);

			map.addAttribute("mo",(month.charAt(0)+"").toUpperCase()+(month.substring(1).toLowerCase()));

			map.addAttribute("y",year);

			ModelAndView mv=new ModelAndView("ViewEmpDetails");

			mv.addObject("msg","Developer Allocated Succesfully..");

			System.out.println("enter in the bill controller");

			return mv;

		}

		catch(Exception e)

		{

			ModelAndView mv=new ModelAndView("Admin");

			mv.addObject("errorMsg","Developer not  allocated ..");

			System.out.println("catch of bill");

			return mv;

		}

		

	}

}

