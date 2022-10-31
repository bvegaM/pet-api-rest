package com.bvega.petapi.domain.model;

import com.bvega.petapi.util.enums.EmployeeSkillEnum;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonDeserialize(builder = Employee.EmployeeBuilder.class)
@Entity
@Table(name = "t_employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;
    @Column(name = "emp_name")
    private String name;
    @ElementCollection
    @Enumerated
    private Set<EmployeeSkillEnum> skills;
    @ElementCollection
    private Set<DayOfWeek> daysAvailable;

    @JsonPOJOBuilder(withPrefix = "")
    public static class EmployeeBuilder{

    }
}

