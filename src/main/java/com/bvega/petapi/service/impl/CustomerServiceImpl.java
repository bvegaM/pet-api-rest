package com.bvega.petapi.service.impl;

import com.bvega.petapi.domain.dto.CustomerDTO;
import com.bvega.petapi.domain.dto.mapper.CustomerMapper;
import com.bvega.petapi.domain.model.Customer;
import com.bvega.petapi.repository.CustomerRepository;
import com.bvega.petapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> findAll() {
        return this.customerMapper.toCostumerDtos(this.customerRepository.findAll());
    }

    @Override
    public CustomerDTO findOwnerByPetId(Long id) {
        Optional<Customer> customer = this.customerRepository.findOwnerByPetId(id);
        return customer.map(value -> this.customerMapper.toCostumerDto(value)).orElse(null);
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        return this.customerMapper.toCostumerDto(
                this.customerRepository.save(
                        customerMapper.toCostumer(customerDTO)));
    }
}
