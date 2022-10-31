package com.bvega.petapi.domain.dto.mapper;

import com.bvega.petapi.domain.dto.EmployeeDTO;
import com.bvega.petapi.domain.model.Employee;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "skills", target = "skills"),
            @Mapping(source = "daysAvailable", target = "daysAvailable")
    })
    EmployeeDTO toEmployeeDto(Employee employee);
    List<EmployeeDTO> toEmployeeDtos(List<Employee> employees);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    Employee toEmployee(EmployeeDTO employeeDTO);
}
