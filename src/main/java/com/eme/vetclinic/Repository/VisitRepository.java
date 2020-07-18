package com.eme.vetclinic.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eme.vetclinic.model.Visit;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Integer> {

}
