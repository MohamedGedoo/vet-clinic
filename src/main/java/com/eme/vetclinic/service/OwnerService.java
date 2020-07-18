package com.eme.vetclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eme.vetclinic.Dto.OwnerDto;
import com.eme.vetclinic.Repository.OwnerRepository;
import com.eme.vetclinic.Utils.ObjectMapperUtils;
import com.eme.vetclinic.exceptions.ApplicationException;
import com.eme.vetclinic.exceptions.StatusResponse;
import com.eme.vetclinic.model.Owner;

/**
 * Java Class representing Owner Service.
 *
 * @author Mohamed Gad
 */

@Service
public class OwnerService {

	@Autowired
	private OwnerRepository ownerRepository;

	/**
	 * <p>
	 * This function is used to get Owner by his ID
	 * </p>
	 * 
	 * @param Integer ownerId.
	 * @return OwnerDto.
	 * @throws ApplicationException if id not found
	 */
	public OwnerDto getOwnerById(Integer ownerId) {
		Owner owner = ownerRepository.findById(ownerId).get();
		if (owner != null) {
			return ObjectMapperUtils.map(owner, OwnerDto.class);
		} else {
			throw new ApplicationException("400", " Wrong Owner ID .");
		}
	}

	/**
	 * <p>
	 * This function is used to add new Owner
	 * </p>
	 * 
	 * @param Integer doctorId.
	 * @return StatusResponse.
	 * 
	 */
	public StatusResponse addNewOwner(OwnerDto ownerDto) {

		ownerRepository.save(ObjectMapperUtils.map(ownerDto, Owner.class));

		return new StatusResponse("200", "DATA_SAVED", "Data Saved Succefully");
	}
}
