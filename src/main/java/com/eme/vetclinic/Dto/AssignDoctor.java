package com.eme.vetclinic.Dto;

import java.io.Serializable;

public class AssignDoctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2135811741065083867L;

	private boolean assign;

	private Integer doctorId;

	private Integer clinicId;

	public boolean isAssign() {
		return assign;
	}

	public void setAssign(boolean assign) {
		this.assign = assign;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getClinicId() {
		return clinicId;
	}

	public void setClinicId(Integer clinicId) {
		this.clinicId = clinicId;
	}

}
