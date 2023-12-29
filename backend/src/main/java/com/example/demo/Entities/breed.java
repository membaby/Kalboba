package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "breed")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class breed {
    @Id
    @Column(name = "breed")
    private String breed;

    @Id
    @Column(name = "species_name")
    private String species_name;

    @MapsId
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "species_name")
    private species species;
}
