package com.bvega.petapi.repository.crud;

import com.bvega.petapi.domain.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetCrudRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByCustomerId(Long id);
}
