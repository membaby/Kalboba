package com.example.demo.Entities.PetEntities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class breedID implements java.io.Serializable {
    private String breed;
    private species speciesOfBreed;
}