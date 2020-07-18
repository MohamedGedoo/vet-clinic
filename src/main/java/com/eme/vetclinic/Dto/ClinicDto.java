package com.eme.vetclinic.Dto;

import java.io.Serializable;

import com.eme.vetclinic.model.Address;
import com.eme.vetclinic.model.SocialURLs;

public class ClinicDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6289301801008300046L;

	private Integer id;

	private String name;

	private String phone;

	private String email;

	private Address address;

	private SocialURLs socialURLs;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public SocialURLs getSocialURLs() {
		return socialURLs;
	}

	public void setSocialURLs(SocialURLs socialURLs) {
		this.socialURLs = socialURLs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClinicDto other = (ClinicDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
