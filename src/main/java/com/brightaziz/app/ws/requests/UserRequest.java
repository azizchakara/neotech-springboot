package com.brightaziz.app.ws.requests;

import java.sql.Timestamp;

public class UserRequest {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Timestamp datedeCandidature;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getDatedeCandidature() {
		return datedeCandidature;
	}
	public void setDatedeCandidature(Timestamp datedeCandidature) {
		this.datedeCandidature = datedeCandidature;
	}
	
	
	
}
