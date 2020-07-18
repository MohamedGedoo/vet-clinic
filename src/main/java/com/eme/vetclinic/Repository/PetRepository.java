package com.eme.vetclinic.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eme.vetclinic.model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer> {

	@Query("From Pet p where p.owner.id = :ownerId ")
	public List<Pet> findOwenerPets(Integer ownerId);
}
