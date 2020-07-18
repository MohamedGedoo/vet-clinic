package com.eme.vetclinic.Dto;

import java.io.Serializable;
import java.util.Set;

import com.eme.vetclinic.model.Address;
import com.eme.vetclinic.model.Pet;

public class OwnerDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3070653921928868146L;

	private Integer id;

	private String ownerName;

	private String phone;

	private String email;

	private String gender;

	private Address address;

	private Set<Pet> pets;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

}
