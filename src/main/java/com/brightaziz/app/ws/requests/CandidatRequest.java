package com.brightaziz.app.ws.requests;

import java.util.Date;

public class CandidatRequest {
		private String firstName;
		private String lastName;
		private String email;
		private Date datedeCandidature;
		
		
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
