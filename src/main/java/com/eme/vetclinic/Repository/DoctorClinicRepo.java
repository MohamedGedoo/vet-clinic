package com.eme.vetclinic.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eme.vetclinic.model.ClinicDoctors;

public interface DoctorClinicRepo extends CrudRepository<ClinicDoctors, Integer> {

	public ClinicDoctors findByDoctorIdAndClinicId(Integer doctorId, Integer clinicId);

	
	public List<ClinicDoctors> findByClinicId(Integer clinicId);

	@Transactional
	@Modifying
	@Query("delete  ClinicDoctors cd  where cd.doctorId =:doctorId ")
	public void deleteByDoctorId(@Param("doctorId") Integer doctorId);

}
