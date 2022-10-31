package com.bvega.petapi.repository;


import com.bvega.petapi.domain.dto.request.EmployeeRequestDTO;
import com.bvega.petapi.domain.model.Employee;
import com.bvega.petapi.repository.crud.EmployeeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    public List<Employee> findAll(){
        return this.employeeCrudRepository.findAll();
    }

    public Optional<Employee> findById(Long id){
        return this.employeeCrudRepository.findById(id);
    }

    public List<Employee> findEmployeesForService(EmployeeRequestDTO employeeRequestDTO){
        return this.employeeCrudRepository.findBySkillsInAndDaysAvailable(employeeRequestDTO.getSkills(),
                employeeRequestDTO.getDate().getDayOfWeek());
    }

    public Employee save(Employee employee){
        return this.employeeCrudRepository.save(employee);
    }
}
