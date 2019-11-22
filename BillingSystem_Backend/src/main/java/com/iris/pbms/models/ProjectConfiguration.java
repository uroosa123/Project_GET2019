package com.iris.pbms.models;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.Table;


@Entity
@Table(name="RoleConfigure")
public class ProjectConfiguration {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="configid")
   private int configurationId;

	@Column(name="perHourBill")
    private int perHourBilling;

	@Column(name="location")
    private String location;

	@ManyToOne
    @JoinColumn(name="projectid",insertable=false,updatable=false)
    Project projectObj;

	@ManyToOne
    @JoinColumn(name="roleid",insertable=false,updatable=false)
    Roles roleObj;

	@Column(name="projectid")
	int projectId;
	
	@Column(name="roleid")
	int roleId;

	public int getConfigurationId() {
		return configurationId;
	}

	public void setConfigurationId(int configurationId) {
		this.configurationId = configurationId;
	}

	public int getPerHourBilling() {
		return perHourBilling;
	}

	public void setPerHourBilling(int perHourBilling) {
		this.perHourBilling = perHourBilling;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Project getProjectObj() {
		return projectObj;
	}

	public void setProjectObj(Project projectObj) {
		this.projectObj = projectObj;
	}

	public Roles getRoleObj() {
		return roleObj;
	}

	public void setRoleObj(Roles roleObj) {
		this.roleObj = roleObj;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "ProjectConfiguration [configurationId=" + configurationId + ", perHourBilling=" + perHourBilling
				+ ", location=" + location + ", projectId=" + projectId + ", roleId=" + roleId + "]";
	}

	


		

}