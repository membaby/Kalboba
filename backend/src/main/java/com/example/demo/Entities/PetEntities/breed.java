package com.example.demo.Entities.PetEntities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "breed")
@Data
@IdClass(breedID.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class breed {

    @Id
    @Column(name = "breed")
    private String breed;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "species")
    private species speciesOfBreed;
}