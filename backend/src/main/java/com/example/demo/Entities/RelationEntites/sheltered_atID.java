package com.example.demo.Entities.RelationEntites;

import com.example.demo.Entities.AccountEntites.shelter;
import com.example.demo.Entities.PetEntities.pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class sheltered_atID implements java.io.Serializable {
    private pet pet_id;
    private shelter shelter_id;
}
