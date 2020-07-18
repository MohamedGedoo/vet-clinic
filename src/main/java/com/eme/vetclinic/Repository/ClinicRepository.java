package com.eme.vetclinic.Repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.eme.vetclinic.model.Address;
import com.eme.vetclinic.model.Clinic;

public interface ClinicRepository extends CrudRepository<Clinic, Integer> {

	public Set<Clinic> findByPhone(String phone);

	public Set<Clinic> findByAddress(Address address);

}
