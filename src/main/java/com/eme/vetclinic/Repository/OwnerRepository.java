package com.eme.vetclinic.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eme.vetclinic.model.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Integer> {
	

}
