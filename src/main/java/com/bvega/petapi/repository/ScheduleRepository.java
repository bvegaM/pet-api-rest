package com.bvega.petapi.repository;

import com.bvega.petapi.domain.model.Schedule;
import com.bvega.petapi.repository.crud.ScheduleCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleRepository {

    @Autowired
    private ScheduleCrudRepository scheduleCrudRepository;

    public List<Schedule> findAll(){
        return this.scheduleCrudRepository.findAll();
    }

    public List<Schedule> findByPetsId(Long id){
        return this.scheduleCrudRepository.findByPetsId(id);
    }

    public  List<Schedule> findByEmployeesId(Long id){
        return this.scheduleCrudRepository.findByEmployeesId(id);
    }

    public List<Schedule> findByPetsCustomerId(Long id){
        return this.scheduleCrudRepository.findByPetsCustomerId(id);
    }

    public Schedule save(Schedule schedule){
        return this.scheduleCrudRepository.save(schedule);
    }
}
