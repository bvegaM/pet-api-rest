package com.bvega.petapi.repository.crud;

import com.bvega.petapi.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerCrudRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findByPetsId(Long id);
}
