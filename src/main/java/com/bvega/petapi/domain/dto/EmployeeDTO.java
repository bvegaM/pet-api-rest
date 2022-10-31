package com.bvega.petapi.domain.dto;

import com.bvega.petapi.util.enums.EmployeeSkillEnum;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonDeserialize(builder = EmployeeDTO.EmployeeDTOBuilder.class)
public class EmployeeDTO {

    private String name;
    private Set<EmployeeSkillEnum> skills;
    private Set<DayOfWeek> daysAvailable;

    @JsonPOJOBuilder(withPrefix = "")
    public static class EmployeeDTOBuilder{ }
}
