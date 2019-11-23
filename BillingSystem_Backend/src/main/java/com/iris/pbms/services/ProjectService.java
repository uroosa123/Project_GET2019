package com.iris.pbms.services;

import java.util.List;

import com.iris.pbms.models.Project;
import com.iris.pbms.models.ProjectAllocation;
import com.iris.pbms.models.ProjectConfiguration;



public interface ProjectService {
	public List<Project> getAllProject();
	public Project getProjectById(int projectId);
	public List<ProjectConfiguration> getAllProjectConfig();
	public boolean setProjectConfig(ProjectConfiguration obj);
	public List<ProjectConfiguration> getAllProjectConfigNotAllocated();
	public List<ProjectConfiguration> validateProject(int projectId,int roleId,String location) ;
	public boolean setProjectAllocation(ProjectAllocation projectAllocation);

}
