package com.bvega.petapi.service.impl;

import com.bvega.petapi.domain.dto.PetDTO;
import com.bvega.petapi.domain.dto.mapper.PetMapper;
import com.bvega.petapi.domain.model.Customer;
import com.bvega.petapi.domain.model.Pet;
import com.bvega.petapi.repository.CustomerRepository;
import com.bvega.petapi.repository.PetRepository;
import com.bvega.petapi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PetMapper petMapper;

    @Override
    public List<PetDTO> findAll() {
        return this.petMapper.toPetDtos(this.petRepository.findAll());
    }

    @Override
    public PetDTO findById(Long id) {
        Optional<Pet> pet = this.petRepository.findById(id);
        return pet.map(value -> this.petMapper.toPetDto(value)).orElse(null);
    }

    @Override
    public List<PetDTO> findPetsByCustomerId(Long id) {
        return this.petMapper.toPetDtos(this.petRepository.findPetsByCustomerId(id));
    }

    @Override
    public PetDTO save(PetDTO petDTO) {
        Optional<Customer> customer = customerRepository.findById(petDTO.getOwnerId());
        if (customer.isPresent()){
            Pet pet = this.petMapper.toPet(petDTO);
            pet.setCustomer(customer.get());
            return this.petMapper.toPetDto(
                    this.petRepository.save(pet)
            );
        }else{
            return null;
        }
    }
}
