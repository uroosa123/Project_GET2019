package com.examples.models;

public class Customer {
	private int customerId;
	private String customerName;
	private String gender;
	private String emailAddress;
	private String password;
	private String city;
	private String role;
	
	public Customer() {
		super();
	}
	public Customer(int customerId, String customerName, String gender, String emailAddress, String password,
			String city,String role) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.gender = gender;
		this.emailAddress = emailAddress;
		this.password = password;
		this.city = city;
		this.role=role;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", gender=" + gender
				+ ", emailAddress=" + emailAddress + ", password=" + password + ", city=" + city + ",role="+role+"]";
	}
	

}
