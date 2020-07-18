package com.eme.vetclinic.Dto;

import java.io.Serializable;


public class DoctorDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8152647636745408610L;

	private Integer id;

	private String name;

	private String phone;

	private byte[] photo;

	private String bio;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

}
