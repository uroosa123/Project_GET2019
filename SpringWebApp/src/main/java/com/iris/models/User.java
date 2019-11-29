package com.iris.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="User_14Nov")
public class User {
	
	@Id
	@NotNull(message="id required")
	private Integer userId;
	
	@NotEmpty(message="username cannot be empty")
	private String userName;
	
	@NotEmpty(message="password cannot be empty")
	private String password;
	
	@NotEmpty(message="only male and female allowed!")
	private String gender;
	private String role;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", gender=" + gender + ", role="
				+ role + "]";
	}
	
	
	
}