package com.eme.vetclinic.Dto;

import java.io.Serializable;
import java.util.Set;

import com.eme.vetclinic.model.Doctor;

public class DoctorClinicDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1805256222095246665L;


	private Set<Doctor> doctors;


	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

}
