package com.eme.vetclinic.Dto;

import java.io.Serializable;
import java.util.List;

public class PetsDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1287074233124076308L;

	private List<PetDto> pets;

	public List<PetDto> getPets() {
		return pets;
	}

	public void setPets(List<PetDto> pets) {
		this.pets = pets;
	}

}
