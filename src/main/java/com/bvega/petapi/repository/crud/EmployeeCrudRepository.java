package com.bvega.petapi.repository.crud;

import com.bvega.petapi.domain.model.Employee;
import com.bvega.petapi.util.enums.EmployeeSkillEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

public interface EmployeeCrudRepository extends JpaRepository<Employee,Long> {

    List<Employee> findBySkillsInAndDaysAvailable(Set<EmployeeSkillEnum> skills, DayOfWeek day);
}
