package com.eme.vetclinic.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eme.vetclinic.Dto.ClinicDto;
import com.eme.vetclinic.Dto.ClinicSearchDto;
import com.eme.vetclinic.Dto.DoctorDto;
import com.eme.vetclinic.Repository.ClinicRepository;
import com.eme.vetclinic.Repository.DoctorClinicRepo;
import com.eme.vetclinic.Repository.DoctorRepository;
import com.eme.vetclinic.Utils.ObjectMapperUtils;
import com.eme.vetclinic.exceptions.ApplicationException;
import com.eme.vetclinic.exceptions.StatusResponse;
import com.eme.vetclinic.model.Clinic;
import com.eme.vetclinic.model.ClinicDoctors;
import com.eme.vetclinic.model.Doctor;

/**
 * Java Class representing Clinic Service.
 *
 * @author Mohamed Gad
 */

@Service
public class ClinicService {

	@Autowired
	private ClinicRepository clinicRepository;
	@Autowired
	private DoctorClinicRepo doctorClinicRepo;
	@Autowired
	private DoctorRepository doctorRepository;

	/**
	 * <p>
	 * This function is used to get Clinic Info by id
	 * </p>
	 * 
	 * @param clinicId clinic Id.
	 * @return ClinicDto.
	 * @throws ApplicationException if Wrong Clinic ID
	 */
	public ClinicDto getClinicByID(Integer clinicId) {
		Clinic clinic = clinicRepository.findById(clinicId).get();
		if (clinic != null) {
			return ObjectMapperUtils.map(clinic, ClinicDto.class);
		} else {
			throw new ApplicationException("400", " Wrong Clinic ID .");
		}
	}

	/**
	 * <p>
	 * This function is used to get all doctors assigned to the clinic
	 * </p>
	 * 
	 * @param clinicId clinic Id.
	 * @return List<DoctorDto>.
	 */
	public List<DoctorDto> getDoctorsByClinicId(Integer clinicId) {

		List<DoctorDto> doctors = new ArrayList<>();
		List<ClinicDoctors> clinicDoctors = (List<ClinicDoctors>) doctorClinicRepo.findByClinicId(clinicId);
		List<Integer> ids = new ArrayList<>();
		if (clinicDoctors != null && clinicDoctors.size() > 0) {

			for (ClinicDoctors clinicDoctor : clinicDoctors) {
				ids.add(clinicDoctor.getDoctorId());
			}
			doctors = ObjectMapperUtils.mapAll((List<Doctor>) doctorRepository.findAllById(ids), DoctorDto.class);
		}
		return doctors;
	}

	/**
	 * <p>
	 * This function is used to add new clinic
	 * </p>
	 * 
	 * @param ClinicDto clinicDto.
	 * @return StatusResponse with saved message.
	 */
	public StatusResponse addClinic(ClinicDto clinicDto) {
		clinicRepository.save(ObjectMapperUtils.map(clinicDto, Clinic.class));
		return new StatusResponse("200", "Data Saved Succefully");
	}

	/**
	 * <p>
	 * This function is used to search for a clinic by using phone or address
	 * </p>
	 * 
	 * @param ClinicSearchDto clinicSerchDto.
	 * @return Set<ClinicDto> all clinics that match the criteria.
	 */
	public Set<ClinicDto> searchClinic(ClinicSearchDto clinicSerchDto) {
		Set<ClinicDto> clinics = new HashSet<>();
		if (clinicSerchDto.getPhone() != null && !clinicSerchDto.getPhone().equals("")) {
			clinics.addAll(
					ObjectMapperUtils.mapAll(clinicRepository.findByPhone(clinicSerchDto.getPhone()), ClinicDto.class));
		}
		if (clinicSerchDto.getAddress() != null) {
			clinics.addAll(ObjectMapperUtils.mapAll(clinicRepository.findByAddress(clinicSerchDto.getAddress()),
					ClinicDto.class));

		}
		return clinics;
	}

}
