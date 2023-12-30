package com.example.demo.Entities.RelationEntites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "adopted_by")
@IdClass(adopted_byID.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class adopted_by {

        @Id
        @Column(name = "pet_id")
        private Integer pet_id;

        @Id
        @Column(name = "adopter_id")
        private Integer adopter_id;

        @MapsId("pet_id")
        @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
        @JoinColumn(name = "pet_id", referencedColumnName = "id")
        private com.example.demo.Entities.PetEntities.pet pet;

        @MapsId("adopter_id")
        @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
        @JoinColumn(name = "adopter_id", referencedColumnName = "id")
        private com.example.demo.Entities.AccountEntites.adopter adopter;
}
