package com.bvega.petapi.domain.dto;

import com.bvega.petapi.util.enums.EmployeeSkillEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@JsonDeserialize(builder = ScheduleDTO.ScheduleDTOBuilder.class)
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {

    @JsonFormat(pattern="yyy-MM-dd")
    private LocalDate date;
    private List<EmployeeDTO> employeeDTOS;
    private List<PetDTO> petDTOS;
    private List<EmployeeSkillEnum> activities;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ScheduleDTOBuilder{ }
}
