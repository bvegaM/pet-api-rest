package com.bvega.petapi.domain.model;

import com.bvega.petapi.util.enums.EmployeeSkillEnum;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonDeserialize(builder = Schedule.ScheduleBuilder.class)
@Entity
@Table(name = "t_schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sch_id")
    private Long id;
    @Column(name = "sch_date")
    private LocalDate date;
    @ManyToMany
    private List<Employee> employees;
    @ManyToMany
    private List<Pet> pets;
    @ElementCollection
    @Enumerated
    private List<EmployeeSkillEnum> activities;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ScheduleBuilder{ }
}
