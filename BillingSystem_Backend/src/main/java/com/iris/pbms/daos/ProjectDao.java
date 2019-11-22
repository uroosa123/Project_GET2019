package com.iris.pbms.daos;

import java.util.List;

import com.iris.pbms.models.Project;
import com.iris.pbms.models.ProjectAllocation;
import com.iris.pbms.models.ProjectConfiguration;



public interface ProjectDao {
	public List<Project> getAllProject();
	public Project getProjectById(int projectId);

	
	
	public List<ProjectConfiguration> getAllProjectConfig();
	/*public boolean setProjectConfig(ProjectConfiguration obj);*/
	public boolean checkProjectConfiguration(ProjectConfiguration obj);

	
}

