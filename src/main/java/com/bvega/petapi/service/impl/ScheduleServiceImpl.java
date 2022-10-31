package com.bvega.petapi.service.impl;

import com.bvega.petapi.domain.dto.ScheduleDTO;
import com.bvega.petapi.domain.dto.ScheduleRequestDTO;
import com.bvega.petapi.domain.dto.mapper.ScheduleMapper;
import com.bvega.petapi.domain.model.Employee;
import com.bvega.petapi.domain.model.Pet;
import com.bvega.petapi.domain.model.Schedule;
import com.bvega.petapi.repository.EmployeeRepository;
import com.bvega.petapi.repository.PetRepository;
import com.bvega.petapi.repository.ScheduleRepository;
import com.bvega.petapi.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PetRepository petRepository;


    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public List<ScheduleDTO> findAll() {
        return scheduleMapper.toScheduleDtos(scheduleRepository.findAll());
    }

    @Override
    public List<ScheduleDTO> findByPetsId(Long id) {
        return scheduleMapper.toScheduleDtos(scheduleRepository.findByPetsId(id));
    }

    @Override
    public List<ScheduleDTO> findByEmployeesId(Long id) {
        return scheduleMapper.toScheduleDtos(scheduleRepository.findByEmployeesId(id));
    }

    @Override
    public List<ScheduleDTO> findByPetsCustomerId(Long id) {
        return scheduleMapper.toScheduleDtos(scheduleRepository.findByPetsCustomerId(id));
    }

    @Override
    public ScheduleDTO save(ScheduleRequestDTO scheduleRequestDTO) {
        List<Employee> employees = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();

        //verify employees exists
        scheduleRequestDTO.getEmployeesId().forEach(id -> {
            Optional<Employee> employee = employeeRepository.findById(id);
            try {
                employee.map(employees::add).orElseThrow(ClassNotFoundException::new);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        //verify pets exists
        scheduleRequestDTO.getPetsId().forEach(id -> {
            Optional<Pet> pet = petRepository.findById(id);
            try {
                pet.map(pets::add).orElseThrow(ClassNotFoundException::new);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        Schedule schedule = Schedule.builder().date(scheduleRequestDTO.getDate())
                .activities(scheduleRequestDTO.getActivities())
                .employees(employees)
                .pets(pets).build();
        return scheduleMapper.toScheduleDto(scheduleRepository.save(schedule));
    }
}
