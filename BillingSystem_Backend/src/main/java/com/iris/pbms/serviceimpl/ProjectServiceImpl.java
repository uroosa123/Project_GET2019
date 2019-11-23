package com.iris.pbms.serviceimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.pbms.daos.ProjectDao;
import com.iris.pbms.models.Project;
import com.iris.pbms.models.ProjectAllocation;
import com.iris.pbms.models.ProjectConfiguration;
import com.iris.pbms.services.ProjectService;


@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	ProjectDao projectDaoobj;

	private SessionFactory sessionFactory;

	public List<Project> getAllProject() {
		return projectDaoobj.getAllProject();

}

	public Project getProjectById(int projectId) {
		return projectDaoobj.getProjectById(projectId);
	}

	public List<ProjectConfiguration> getAllProjectConfig() {
		return projectDaoobj.getAllProjectConfig();
	}

	public boolean setProjectConfig(ProjectConfiguration obj) {
		boolean r=projectDaoobj.checkProjectConfiguration(obj);
		return r;
	}

	public List<ProjectConfiguration> getAllProjectConfigNotAllocated() {
		return projectDaoobj.getAllProjectConfigNotAllocated();
	}

	public List<ProjectConfiguration> validateProject(int projectId, int roleId, String location) {
		return projectDaoobj.validateProject(projectId, roleId, location);
	}

	public boolean setProjectAllocation(ProjectAllocation projectAllocation) {
		return projectDaoobj.setProjectAllocation(projectAllocation);
	}
}
