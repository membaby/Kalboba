package com.example.demo.Entities.PetEntities;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class breedID implements java.io.Serializable {
    @Column(name = "breed")
    private String breed;

    @Column(name = "species")
    private String species;
}