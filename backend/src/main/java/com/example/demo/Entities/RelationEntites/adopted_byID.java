package com.example.demo.Entities.RelationEntites;

import com.example.demo.Entities.AccountEntites.adopter;
import com.example.demo.Entities.PetEntities.pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class adopted_byID implements java.io.Serializable {
    private pet pet_id;
    private adopter adopter_id;
}
