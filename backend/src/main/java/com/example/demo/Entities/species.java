package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "species")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class species {
    @Id
    @Column(name = "species_name")
    private String species_name;

    @OneToMany(mappedBy = "species", cascade = CascadeType.ALL)
    private List<breed> breeds;
}
