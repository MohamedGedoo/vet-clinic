package com.eme.vetclinic.Repository;

import org.springframework.data.repository.CrudRepository;

import com.eme.vetclinic.model.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer>{

}
