package com.bvega.petapi.repository;

import com.bvega.petapi.domain.model.Pet;
import com.bvega.petapi.repository.crud.PetCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PetRepository {

    @Autowired
    private PetCrudRepository petCrudRepository;

    public List<Pet> findAll(){
        return this.petCrudRepository.findAll();
    }

    public Optional<Pet> findById(Long id){
        return this.petCrudRepository.findById(id);
    }

    public List<Pet> findPetsByCustomerId(Long id){
        return this.petCrudRepository.findByCustomerId(id);
    }

    public Pet save(Pet pet){
        return this.petCrudRepository.save(pet);
    }
}
