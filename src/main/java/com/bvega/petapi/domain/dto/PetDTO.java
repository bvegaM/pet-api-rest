package com.bvega.petapi.domain.dto;

import com.bvega.petapi.util.enums.PetTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@JsonDeserialize(builder = PetDTO.PetDTOBuilder.class)
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {

    private String name;
    private PetTypeEnum type;
    @JsonFormat(pattern="yyy-MM-dd")
    private Date birthDate;
    private String notes;
    private Long ownerId;
    @JsonPOJOBuilder(withPrefix = "")
    public static class PetDTOBuilder{ }
}
