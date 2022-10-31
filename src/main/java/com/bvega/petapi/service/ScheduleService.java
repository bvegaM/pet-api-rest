package com.bvega.petapi.service;

import com.bvega.petapi.domain.dto.ScheduleDTO;
import com.bvega.petapi.domain.dto.ScheduleRequestDTO;

import java.util.List;

public interface ScheduleService {

    List<ScheduleDTO> findAll();
    List<ScheduleDTO> findByPetsId(Long id);
    List<ScheduleDTO> findByEmployeesId(Long id);
    List<ScheduleDTO> findByPetsCustomerId(Long id);
    ScheduleDTO save(ScheduleRequestDTO scheduleRequestDTO);
}
