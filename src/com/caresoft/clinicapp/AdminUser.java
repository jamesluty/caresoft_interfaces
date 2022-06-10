package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {

    // Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<>();
    
//    Constructors
    public AdminUser(int id, String role) {
    	super(id);
    	this.id = id;
    }
    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
	@Override
	public boolean assignPin(int pin) {
		if(pin > 99999) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(this.id == confirmedAuthID) {
			return true;
		} else {
			this.authIncident();
		}
		return false;
	}
	
	@Override
	public ArrayList<String> reportSecurityIncidents() {
//		ArrayList<String> incidents = new ArrayList<>();
//		for(String report: securityIncidents) {
//			incidents.add(report);
//		}
		return securityIncidents;
	}
	
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}

}
