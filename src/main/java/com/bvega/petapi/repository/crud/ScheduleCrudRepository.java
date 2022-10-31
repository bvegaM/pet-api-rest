package com.bvega.petapi.repository.crud;

import com.bvega.petapi.domain.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleCrudRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByPetsId(Long id);
    List<Schedule> findByEmployeesId(Long id);
    List<Schedule> findByPetsCustomerId(Long id);
}
