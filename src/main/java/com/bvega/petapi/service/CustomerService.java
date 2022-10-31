package com.bvega.petapi.service;

import com.bvega.petapi.domain.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> findAll();
    CustomerDTO findOwnerByPetId(Long id);
    CustomerDTO save(CustomerDTO customerDTO);
}
