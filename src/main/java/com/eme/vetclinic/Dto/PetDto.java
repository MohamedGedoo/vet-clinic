package com.eme.vetclinic.Dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.eme.vetclinic.model.PetType;

public class PetDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1653927029243286665L;

	private Integer id;

	private String name;

	private LocalDate birthDate;

	private String photo;

	private String weight;

	private String gender;

	private PetType type;

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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {

		this.photo = photo.toString();
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public PetType getType() {
		return type;
	}

	public void setType(PetType type) {
		this.type = type;
	}

}