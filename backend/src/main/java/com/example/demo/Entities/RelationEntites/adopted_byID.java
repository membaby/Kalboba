package com.example.demo.Entities.RelationEntites;

import com.example.demo.Entities.AccountEntites.adopter;
import com.example.demo.Entities.PetEntities.pet;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class adopted_byID implements java.io.Serializable {
        @Column(name = "pet_id")
        private Integer pet_id;

        @Column(name = "adopter_id")
        private Integer adopter_id;

        // Constructors, getters, and setters (if not generated by Lombok)...
}
