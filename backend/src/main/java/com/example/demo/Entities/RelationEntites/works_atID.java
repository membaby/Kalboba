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

    @Column(name = "staff_id")
    private Integer staff_id;

    @Column(name = "shelter_id")
    private Integer shelter_id;


    // Constructors, getters, setters, equals, and hashCode methods
}
