package com.bvega.petapi.service.impl;

import com.bvega.petapi.domain.dto.EmployeeDTO;
import com.bvega.petapi.domain.dto.mapper.EmployeeMapper;
import com.bvega.petapi.domain.dto.request.EmployeeRequestDTO;
import com.bvega.petapi.domain.model.Employee;
import com.bvega.petapi.repository.EmployeeRepository;
import com.bvega.petapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public List<EmployeeDTO> findAll() {
        return this.employeeMapper.toEmployeeDtos(employeeRepository.findAll());
    }

    @Override
    public EmployeeDTO findById(Long id) {
        Optional<Employee> employee = this.employeeRepository.findById(id);
        return employee.map(value -> this.employeeMapper.toEmployeeDto(value)).orElse(null);
    }

    @Override
    public List<EmployeeDTO> findEmployeesForService(EmployeeRequestDTO employeeRequestDTO) {
        return this.employeeMapper.toEmployeeDtos(this.employeeRepository.findEmployeesForService(employeeRequestDTO));
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        Employee employee = this.employeeMapper.toEmployee(employeeDTO);
        return this.employeeMapper.toEmployeeDto(
                this.employeeRepository.save(employee)
        );
    }

    @Override
    public boolean setAvailability(Set<DayOfWeek> daysAvailable, Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            employee.get().getDaysAvailable().addAll(daysAvailable);
            employeeRepository.save(employee.get());
            return true;
        }else{
            return false;
        }
    }
}
