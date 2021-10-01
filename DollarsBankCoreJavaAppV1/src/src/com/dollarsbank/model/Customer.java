package com.dollarsbank.model;

public class Customer {

	


	private String userId;
	private String password;
	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", password=" + password + "]";
	}

	
	
	
	
	
	
	
}
