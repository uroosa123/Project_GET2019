package com.iris.pbms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import javax.persistence.Table;



@Entity
@Table(name="EmpAttendance")
public class DataEntryOperator {
	
	@Id
	@GeneratedValue
	@Column(name="attendanceid")
	private Integer dataEntryOperatorId;

	@Column(name="mnth")
	private String month;

	@Column(name="yrs")
	private Integer year;

	@Column(name="fullday")
	private Integer fullDay;

	@Column(name="halfday")
	private Integer halfDay;

	@OneToOne
	@JoinColumn(name="employeeid")
	Employee empObj;
	
	@ManyToOne
	@JoinColumn(name="projectid")
	Project projObj;

	

	

	public Integer getYear() {

		return year;

	}



	public void setYear(Integer year) {

		this.year = year;

	}



	public Integer getdataEntryOperatorId() {

		return dataEntryOperatorId;

	}



	public void setdataEntryOperatorId(Integer dataEntryOperatorId) {

		this.dataEntryOperatorId = dataEntryOperatorId;

	}



	public String getMonth() {

		return month;

	}



	public void setMonth(String month) {

		this.month = month;

	}



	public Integer getfullDay() {

		return fullDay;

	}



	public void setfullDay(Integer fullDay) {

		this.fullDay = fullDay;

	}



	public Integer gethalfDay() {

		return halfDay;

	}



	public void sethalfDay(Integer halfDay) {

		this.halfDay = halfDay;

	}



	public Employee getEmpObj() {

		return empObj;

	}



	public void setEmpObj(Employee empObj) {

		this.empObj = empObj;

	}



	public Project getProjObj() {
		return projObj;
	}



	public void setProjObj(Project projObj) {
		this.projObj = projObj;
	}



}
