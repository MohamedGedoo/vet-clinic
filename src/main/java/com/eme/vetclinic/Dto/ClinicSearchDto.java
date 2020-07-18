package com.eme.vetclinic.Dto;

import java.io.Serializable;

import com.eme.vetclinic.model.Address;

public class ClinicSearchDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5906763634161298336L;

	private String phone;

	private Address address;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
