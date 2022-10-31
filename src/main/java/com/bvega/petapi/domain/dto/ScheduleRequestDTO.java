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
@JsonDeserialize(builder = ScheduleRequestDTO.ScheduleRequestDTOBuilder.class)
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleRequestDTO {

    @JsonFormat(pattern="yyy-MM-dd")
    private LocalDate date;
    private List<Long> employeesId;
    private List<Long> petsId;
    private List<EmployeeSkillEnum> activities;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ScheduleRequestDTOBuilder{}
}
