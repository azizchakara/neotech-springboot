package com.brightaziz.app.ws.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="candidats")
public class CandidatEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3477964903154982084L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String userId;
	@Column(nullable=false, length=50)
	private String firstName;
	@Column(nullable=false, length=50)
	private String lastName;
	@Column(nullable=false, unique=true)
	private String email;
	@Column(nullable=false)
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
