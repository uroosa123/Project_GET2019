package com.iris.pbms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="ProjectEmpAllocation")
public class ProjectAllocation {

	@Id
	@GeneratedValue
	@Column(name="allocateid")
	private int allocationId;

	@OneToOne
	@JoinColumn(name="configid")
	ProjectConfiguration pcObj;

	@OneToOne
	@JoinColumn(name="employeeid")
	Employee empObj;

	
public ProjectAllocation() {

		super();

	}


    public int getallocationId() {

		return allocationId;

	}



	public void setallocationId(int allocationId) {

		this.allocationId = allocationId;

	}



	public ProjectConfiguration getPcObj() {

		return pcObj;

	}



	public void setPcObj(ProjectConfiguration pcObj) {

		this.pcObj = pcObj;

	}



	public Employee getdObj() {

		return empObj;

	}



	public void setdObj(Employee empObj) {

		this.empObj = empObj;

	}



	@Override

	public String toString() {

		return "ProjectAllocation [allocationId=" + allocationId + ", pcObj=" + pcObj + ", empObj=" + empObj + "]";

	}

	

	

	

}