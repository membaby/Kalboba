package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pet")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "breed")
    private String breed;

    @Column(name = "species")
    private String species;

    @Column(name = "color")
    private String color;

    @Column(name ="age_years")
    private Integer age_years;

    @Column(name ="age_months")
    private Integer age_months;

    @Column(name ="appearance")
    private String appearance;

    @Column(name ="gender")
    private Gender gender;

    @Column(name = "behavior")
    private String behavior;

    @Column(name = "health")
    private String health;

    @Column(name = "fertility")
    private Fertility fertility;

    @Column(name = "adopted")
    private boolean adopted;




}
