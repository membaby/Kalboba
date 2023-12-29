package com.example.demo.Entities.RelationEntites;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class works_atID implements Serializable {

    private com.example.demo.Entities.AccountEntites.staff staff;
    private com.example.demo.Entities.AccountEntites.shelter shelter;

    // Constructors, getters, setters, equals, and hashCode methods
}
