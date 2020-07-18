package com.eme.vetclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eme.vetclinic.Dto.AssignDoctor;
import com.eme.vetclinic.Dto.DoctorDto;
import com.eme.vetclinic.Repository.DoctorClinicRepo;
import com.eme.vetclinic.Repository.DoctorRepository;
import com.eme.vetclinic.Utils.ObjectMapperUtils;
import com.eme.vetclinic.exceptions.ApplicationException;
import com.eme.vetclinic.exceptions.StatusResponse;
import com.eme.vetclinic.model.ClinicDoctors;
import com.eme.vetclinic.model.Doctor;

/**
 * Java Class representing Doctor Service.
 *
 * @author Mohamed Gad
 */

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private DoctorClinicRepo doctorClinicRepo;

	/**
	 * <p>
	 * This function is used to get doctor by his ID
	 * </p>
	 * 
	 * @param Integer doctorId.
	 * @return DoctorDto.
	 * @throws ApplicationException if id not found
	 */
	public DoctorDto getDoctorByID(Integer doctorId) {
		Doctor doctor = doctorRepository.findById(doctorId).get();
		if (doctor != null) {
			return ObjectMapperUtils.map(doctor, DoctorDto.class);
		} else {
			throw new ApplicationException("400", " Wrong Doctor ID .");
		}
	}

	/**
	 * <p>
	 * This function is used to add new doctor
	 * </p>
	 * 
	 * @param DoctorDto doctorDto.
	 * @return StatusResponse with saved message.
	 */
	public StatusResponse addDoctor(DoctorDto doctorDto) {
		doctorRepository.save(ObjectMapperUtils.map(doctorDto, Doctor.class));
		return new StatusResponse("200", "DATA_SAVED", "Data Saved Succefully");
	}

	/**
	 * <p>
	 * This function is used to Assign/de-assign doctor to clinic
	 * </p>
	 * 
	 * @param AssignDoctor assignDoctor.
	 * @return StatusResponse with saved message.
	 * @throws ApplicationException if Doctor Already assigned to this Clinic
	 */
	public StatusResponse assignDoctor(AssignDoctor assignDoctor) {

		if (assignDoctor.isAssign()) {
			ClinicDoctors clinicDoctors = doctorClinicRepo.findByDoctorIdAndClinicId(assignDoctor.getDoctorId(),
					assignDoctor.getClinicId());
			if (clinicDoctors == null) {
				clinicDoctors = new ClinicDoctors();
				clinicDoctors.setClinicId(assignDoctor.getClinicId());
				clinicDoctors.setDoctorId(assignDoctor.getDoctorId());
				doctorClinicRepo.save(clinicDoctors);
			} else {
				throw new ApplicationException("400", " Doctor Already assigned to this Clinic");
			}
		} else {
			doctorClinicRepo.deleteByDoctorId(assignDoctor.getDoctorId());
		}
		return new StatusResponse("200", "DATA_SAVED", "Data Saved Succefully");
	}

}
