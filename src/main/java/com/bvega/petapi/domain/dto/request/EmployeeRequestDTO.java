package com.bvega.petapi.domain.dto.request;

import com.bvega.petapi.util.enums.EmployeeSkillEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class EmployeeRequestDTO {
    private Set<EmployeeSkillEnum> skills;
    @JsonFormat(pattern="yyy-MM-dd")
    private LocalDate date;
}
