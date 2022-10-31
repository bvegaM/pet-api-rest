package com.bvega.petapi.service;


import com.bvega.petapi.domain.dto.PetDTO;

import java.util.List;

public interface PetService {

    List<PetDTO> findAll();
    PetDTO findById(Long id);
    List<PetDTO> findPetsByCustomerId(Long id);
    PetDTO save(PetDTO petDTO);
}
