package com.bvega.petapi.repository;

import com.bvega.petapi.domain.model.Customer;
import com.bvega.petapi.repository.crud.CustomerCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {

    @Autowired
    private CustomerCrudRepository customerRepository;

    public List<Customer> findAll(){
        return this.customerRepository.findAll();
    }

    public Optional<Customer> findById(Long id){
        return this.customerRepository.findById(id);
    }

    public Optional<Customer> findOwnerByPetId(Long id){
        return this.customerRepository.findByPetsId(id);
    }

    public Customer save(Customer customer){
        return this.customerRepository.save(customer);
    }
}
