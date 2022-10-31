package com.bvega.petapi.controller;

import com.bvega.petapi.domain.dto.ScheduleDTO;
import com.bvega.petapi.domain.dto.ScheduleRequestDTO;
import com.bvega.petapi.service.impl.ScheduleServiceImpl;
import com.bvega.petapi.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleServiceImpl scheduleService;

    @PostMapping
    public ResponseEntity<Object> createSchedule(@RequestBody ScheduleRequestDTO scheduleRequestDTO) {
        try{
            ScheduleDTO scheduleDTO = this.scheduleService.save(scheduleRequestDTO);
            return ResponseHandler.generateOperation("Data created!!", HttpStatus.CREATED,scheduleDTO);
        }catch (Exception e){
            return ResponseHandler.generateOperation("Data could not be created!!", HttpStatus.BAD_REQUEST,e.getCause());
        }

    }

    @GetMapping
    public ResponseEntity<Object> getAllSchedules() {
        try{
            List<ScheduleDTO> scheduleDTO = this.scheduleService.findAll();
            return ResponseHandler.generateOperation("Data retrived!!", HttpStatus.CREATED,scheduleDTO);
        }catch (Exception e){
            return ResponseHandler.generateOperation("Data could not be retrived!!", HttpStatus.BAD_REQUEST,e.getCause());
        }
    }

    @GetMapping("/pet/{petId}")
    public ResponseEntity<Object>getScheduleForPet(@PathVariable Long petId) {
        try{
            List<ScheduleDTO> scheduleDTO = this.scheduleService.findByPetsId(petId);
            return ResponseHandler.generateOperation("Data retrived!!", HttpStatus.CREATED,scheduleDTO);
        }catch (Exception e){
            return ResponseHandler.generateOperation("Data could not be retrived!!", HttpStatus.BAD_REQUEST,e.getCause());
        }
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Object>getScheduleForEmployee(@PathVariable Long employeeId) {
        try{
            List<ScheduleDTO> scheduleDTO = this.scheduleService.findByEmployeesId(employeeId);
            return ResponseHandler.generateOperation("Data retrived!!", HttpStatus.CREATED,scheduleDTO);
        }catch (Exception e){
            return ResponseHandler.generateOperation("Data could not be retrived!!", HttpStatus.BAD_REQUEST,e.getCause());
        }
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Object> getScheduleForCustomer(@PathVariable Long customerId) {
        try{
            List<ScheduleDTO> scheduleDTO = this.scheduleService.findByPetsCustomerId(customerId);
            return ResponseHandler.generateOperation("Data retrived!!", HttpStatus.CREATED,scheduleDTO);
        }catch (Exception e){
            return ResponseHandler.generateOperation("Data could not be retrived!!", HttpStatus.BAD_REQUEST,e.getCause());
        }
    }
}
