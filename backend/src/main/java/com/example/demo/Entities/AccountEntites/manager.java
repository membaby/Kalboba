package com.example.demo.Entities.AccountEntites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "manager")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class manager {
    @Id
    @Column(name = "id")
    private Integer id;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private user_account account;
}
