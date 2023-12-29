package com.example.demo.Entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class works_atID implements Serializable {

    private Integer staff_id;
    private Integer shelter_id;

    // Constructors, getters, setters, equals, and hashCode methods
}
