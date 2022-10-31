package com.bvega.petapi.service;


import com.bvega.petapi.domain.dto.EmployeeDTO;
import com.bvega.petapi.domain.dto.request.EmployeeRequestDTO;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

public interface EmployeeService {

    List<EmployeeDTO> findAll();
    EmployeeDTO findById(Long id);
    List<EmployeeDTO> findEmployeesForService(EmployeeRequestDTO employeeRequestDTO);
    EmployeeDTO save(EmployeeDTO employeeDTO);
    boolean setAvailability(Set<DayOfWeek> daysAvailable, Long id);

}
