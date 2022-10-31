package com.bvega.petapi.domain.dto.mapper;

import com.bvega.petapi.domain.dto.ScheduleDTO;
import com.bvega.petapi.domain.dto.ScheduleRequestDTO;
import com.bvega.petapi.domain.model.Schedule;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PetMapper.class,EmployeeMapper.class})
public interface ScheduleMapper {

    @Mappings({
            @Mapping(source = "date",target = "date"),
            @Mapping(source = "employees",target = "employeeDTOS"),
            @Mapping(source = "pets",target = "petDTOS"),
            @Mapping(source = "activities",target = "activities")
    })
    ScheduleDTO toScheduleDto(Schedule schedule);
    List<ScheduleDTO> toScheduleDtos(List<Schedule> schedules);


    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employees", ignore = true)
    @Mapping(target = "pets", ignore = true)
    Schedule toSchedule(ScheduleDTO scheduleDTO);
}
