package com.example.demo.Entities.RelationEntites;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class managesID implements java.io.Serializable {

   private com.example.demo.Entities.AccountEntites.manager manager;
    private com.example.demo.Entities.AccountEntites.shelter shelter;

    // Constructors, getters, and setters (if not generated by Lombok)...
}