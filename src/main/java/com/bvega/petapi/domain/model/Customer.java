package com.bvega.petapi.domain.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonDeserialize(builder = Customer.CostumerBuilder.class)
@Entity
@Table(name = "t_costumers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ctm_id")
    private Long id;
    @Column(name = "ctm_name")
    private String name;
    @Column(name = "ctm_phone")
    private String phoneNumber;
    @Column(name = "ctm_notes")
    private String notes;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Pet> pets;

    @JsonPOJOBuilder(withPrefix = "")
    public static class CostumerBuilder{ }

}
