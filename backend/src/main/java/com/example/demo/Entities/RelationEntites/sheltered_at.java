package com.example.demo.Entities.RelationEntites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "sheltered_at")
@IdClass(sheltered_atID.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class sheltered_at {

    @Id
    @Column(name = "pet_id")
    private int pet_id;

    @Id
    @Column(name = "shelter_id")
    private int shelter_id;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "reason_for_availability")
    private String reason_for_availability;

    @MapsId("pet_id")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    private com.example.demo.Entities.PetEntities.pet pet;

    @MapsId("shelter_id")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "shelter_id", referencedColumnName = "id")
    private com.example.demo.Entities.AccountEntites.shelter shelter;


}
