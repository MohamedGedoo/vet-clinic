package com.eme.vetclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eme.vetclinic.Dto.PetDto;
import com.eme.vetclinic.Repository.OwnerRepository;
import com.eme.vetclinic.Repository.PetRepository;
import com.eme.vetclinic.Utils.ObjectMapperUtils;
import com.eme.vetclinic.exceptions.ApplicationException;
import com.eme.vetclinic.exceptions.StatusResponse;
import com.eme.vetclinic.model.Owner;
import com.eme.vetclinic.model.Pet;

/**
 * Java Class representing Pets Service.
 *
 * @author Mohamed Gad
 */
@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;
	@Autowired
	private OwnerRepository ownerRepository;

	/**
	 * <p>
	 * This function is used to get Owner by his ID
	 * </p>
	 * 
	 * @param Integer petId.
	 * @return PetDto.
	 * @throws ApplicationException if id not found
	 */
	public PetDto getById(Integer id) {
		Pet pet = petRepository.findById(id).get();
		if (pet != null) {
			return ObjectMapperUtils.map(pet, PetDto.class);
		} else {
			throw new ApplicationException("400", " Wrong Owner ID .");
		}

	}

	/**
	 * 
	 * */
	public List<PetDto> getAll() {
		return ObjectMapperUtils.mapAll((List<Pet>) petRepository.findAll(), PetDto.class);
	}

	/**
	 * <p>
	 * This function is used to List all owner’s pets by owner id.
	 * </p>
	 * 
	 * @param Integer ownerId.
	 * @return List<PetDto>.
	 */
	public List<PetDto> getOwenerPets(Integer ownerId) {
		return ObjectMapperUtils.mapAll((List<Pet>) petRepository.findOwenerPets(ownerId), PetDto.class);

	}

	/**
	 * <p>
	 * This function is used to add new Pet.
	 * </p>
	 * 
	 * @param Integer ownerId.
	 * @param PetDto  petDto
	 * @return StatusResponse with saved message.
	 * @throws ApplicationException with Can not find Owner with this ID
	 */
	public StatusResponse addPet(Integer ownerId, PetDto petDto) {

		if (ownerId > 0 && petDto.getType().getId() > 0 && ownerRepository.existsById(ownerId)) {
			Owner OwnerDB = ownerRepository.findById(ownerId).get();

			Pet petDB = ObjectMapperUtils.map(petDto, Pet.class);
			petDB.setPhoto(((petDto.getPhoto() != null) ? petDto.getPhoto().getBytes() : null));
			petDB.setOwner(OwnerDB);
			petRepository.save(petDB);

		} else {
			throw new ApplicationException(
					new StatusResponse("400", "INVALID_DATA", "Can not find Owner with this ID"));
		}

		return new StatusResponse("200", "DATA_SAVED", "Data Saved Succefully");

	}

}
