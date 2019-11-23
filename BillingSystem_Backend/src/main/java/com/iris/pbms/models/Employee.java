package com.iris.pbms.models;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="Employee")
public class Employee {



	@Id
	@Column(name="employeeid")
	private int employeeId;

	@Column(name="employeename")
	private String employeeName;
	
	


	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
	}

	

	

}
