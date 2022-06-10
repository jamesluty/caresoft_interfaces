package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {

//	Constructors
	public Physician(int id) {
		super(id);
		this.id = id;
	}
	
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
	@Override
	public boolean assignPin(int pin) {
		if(pin > 999 && pin < 10000) {
			return true;
		}
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(this.id == confirmedAuthID) {
			return true;
		}
		return false;
	}
	
}
