package com.eme.vetclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eme.vetclinic.Dto.VisitDto;
import com.eme.vetclinic.Repository.VisitRepository;
import com.eme.vetclinic.Utils.ObjectMapperUtils;
import com.eme.vetclinic.exceptions.ApplicationException;
import com.eme.vetclinic.exceptions.StatusResponse;
import com.eme.vetclinic.model.Visit;

/**
 * Java Class representing Visits Service.
 *
 * @author Mohamed Gad
 */
@Service
public class VisitService {

	@Autowired
	private VisitRepository visitRepository;

	/**
	 * <p>
	 * This function is used to get Owner by his ID
	 * </p>
	 * 
	 * @param Integer petId.
	 * @return PetDto.
	 * @throws ApplicationException if id not found
	 */
	public VisitDto getVisitById(Integer id) {
		return ObjectMapperUtils.map(visitRepository.findById(id).get(), VisitDto.class);
	}

	/**
	 * <p>
	 * This function is used to add new visit.
	 * </p>
	 * 
	 * @param VisitDto visitDto.
	 * @return StatusResponse with saved message.
	 */
	public StatusResponse addVisit(VisitDto visitDto) {
		visitRepository.save(ObjectMapperUtils.map(visitDto, Visit.class));
		return new StatusResponse("200", "DATA_SAVED", "Data Saved Succefully");
	}
}
