package com.example.demo.Entities.RecordsEntities;

import com.example.demo.Entities.AccountEntites.adopter;
import com.example.demo.Entities.AccountEntites.shelter;
import com.example.demo.Entities.PetEntities.pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class adoption_applicationID implements java.io.Serializable{
    private pet pet_id;
    private adopter adopter_id;
    private shelter shelter_id;
}
