package com.brightaziz.app.ws.shared.dto;

import java.io.Serializable;
import java.util.Date;

public class CandidatDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6367920622634824532L;
	private long id;
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private Date datedeCandidature;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
	public Date getDatedeCandidature() {
		return datedeCandidature;
	}
	public void setDatedeCandidature(Date datedeCandidature) {
		this.datedeCandidature = datedeCandidature;
	}
	
	
	
	
	}
