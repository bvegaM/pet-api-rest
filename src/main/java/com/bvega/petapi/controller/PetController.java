package com.bvega.petapi.controller;

import com.bvega.petapi.domain.dto.PetDTO;
import com.bvega.petapi.service.impl.PetServiceImpl;
import com.bvega.petapi.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetServiceImpl petService;

    @PostMapping
    public ResponseEntity<Object> savePet(@RequestBody PetDTO petDTO) {
        try{
            PetDTO pet = this.petService.save(petDTO);
            return ResponseHandler.generateOperation("Data creaeted!!", HttpStatus.CREATED,pet);
        }catch (Exception ex){
            return ResponseHandler.generateOperation("Data could not be created!!", HttpStatus.BAD_REQUEST,ex.getCause());
        }
    }

    @GetMapping("/{petId}")
    public ResponseEntity<Object> getPet(@PathVariable("petId") long petId) {
        try{
            PetDTO pet = this.petService.findById(petId);
            return ResponseHandler.generateOperation("Data retrived!!", HttpStatus.OK,pet);
        }catch (Exception e){
            return ResponseHandler.generateOperation("Data could not be retrived!!", HttpStatus.BAD_REQUEST,e.getCause());
        }
    }

    @GetMapping
    public ResponseEntity<Object> getPets(){
        try{
            List<PetDTO> petDTOS = this.petService.findAll();
            return ResponseHandler.generateOperation("Data retrived!!", HttpStatus.CREATED,petDTOS);
        }catch (Exception e){
            return ResponseHandler.generateOperation("Data could not be retrived!!", HttpStatus.BAD_REQUEST,e.getCause());
        }
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<Object> getPetsByOwner(@PathVariable("ownerId") long ownerId) {
        try{
            List<PetDTO> petDTOS = this.petService.findPetsByCustomerId(ownerId);
            return ResponseHandler.generateOperation("Data retrived!!", HttpStatus.CREATED,petDTOS);
        }catch (Exception e){
            return ResponseHandler.generateOperation("Data could not be retrived!!", HttpStatus.BAD_REQUEST,e.getCause());
        }
    }
}
