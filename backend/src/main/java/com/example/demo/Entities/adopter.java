package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "adopter")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class adopter {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "about")
    private String about;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private user_account account;
}
