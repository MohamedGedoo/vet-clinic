package com.eme.vetclinic.Dto;

import java.io.Serializable;
import java.time.LocalDateTime;


public class VisitDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1054824425903792859L;

	private Integer id;

	private Integer petId;
	
	private Integer doctorId;
	
	private Integer clinicID;

	
	private LocalDateTime visitDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getClinicID() {
		return clinicID;
	}

	public void setClinicID(Integer clinicID) {
		this.clinicID = clinicID;
	}

	public LocalDateTime getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDateTime visitDate) {
		this.visitDate = visitDate;
	}

}
