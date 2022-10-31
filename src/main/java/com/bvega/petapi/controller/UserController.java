package com.bvega.petapi.controller;

import com.bvega.petapi.domain.dto.CustomerDTO;
import com.bvega.petapi.domain.dto.EmployeeDTO;
import com.bvega.petapi.domain.dto.request.EmployeeRequestDTO;
import com.bvega.petapi.service.impl.CustomerServiceImpl;
import com.bvega.petapi.service.impl.EmployeeServiceImpl;
import com.bvega.petapi.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping("/customer")
    public ResponseEntity<Object> saveCustomer(@RequestBody CustomerDTO customerDTO){
        try{
            CustomerDTO customer = this.customerService.save(customerDTO);
            return ResponseHandler.generateOperation("Data created!!", HttpStatus.CREATED,customer);
        }catch (Exception e){
            return ResponseHandler.generateOperation("Data could not be created!!", HttpStatus.BAD_REQUEST,e.getCause());
        }
    }

    @GetMapping("/customer")
    public ResponseEntity<Object> getAllCustomers(){
        try{
            List<CustomerDTO> customer = this.customerService.findAll();
            return ResponseHandler.generateOperation("Data retrived!!", HttpStatus.CREATED,customer);
        }catch (Exception e){
            return ResponseHandler.generateOperation("Data could not be retrived!!", HttpStatus.BAD_REQUEST,e.getCause());
        }
    }

    @GetMapping("/customer/pet/{petId}")
    public ResponseEntity<Object> getOwnerByPet(@PathVariable("petId") long petId){
        try{
            CustomerDTO customer = this.customerService.findOwnerByPetId(petId);
            return ResponseHandler.generateOperation("Data retrived!!", HttpStatus.CREATED,customer);
        }catch (Exception e){
            return ResponseHandler.generateOperation("Data could not be retrived!!", HttpStatus.BAD_REQUEST,e.getCause());
        }
    }

    @PostMapping("/employee")
    public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        try{
            EmployeeDTO employee = this.employeeService.save(employeeDTO);
            return ResponseHandler.generateOperation("Data created!!", HttpStatus.CREATED,employee);
        }catch (Exception e){
            return ResponseHandler.generateOperation("Data could not be created!!", HttpStatus.BAD_REQUEST,e.getCause());
        }
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Object> getEmployee(@PathVariable long employeeId) {
        try{
            EmployeeDTO employee = this.employeeService.findById(employeeId);
            return ResponseHandler.generateOperation("Data retrived!!", HttpStatus.CREATED,employee);
        }catch (Exception e){
            return ResponseHandler.generateOperation("Data could not be retrived!!", HttpStatus.BAD_REQUEST,e.getCause());
        }
    }

    @PutMapping("/employee/{employeeId}")
    public ResponseEntity<Object> setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        try{
            boolean response = this.employeeService.setAvailability(daysAvailable,employeeId);
            if(response){
                return ResponseHandler.generateOperation("Data updated!!", HttpStatus.CREATED, true);
            }else {
                throw new Exception("update error");
            }
        }catch (Exception e){
            return ResponseHandler.generateOperation("Data updated!!", HttpStatus.CREATED,false);
        }

    }

    @GetMapping("/employee/availability")
    public ResponseEntity<Object> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
        try{
            List<EmployeeDTO> employee = this.employeeService.findEmployeesForService(employeeDTO);
            return ResponseHandler.generateOperation("Data retrived!!", HttpStatus.CREATED,employee);
        }catch (Exception e){
            return ResponseHandler.generateOperation("Data could not be retrived!!", HttpStatus.BAD_REQUEST,e.getCause());
        }
    }
}
