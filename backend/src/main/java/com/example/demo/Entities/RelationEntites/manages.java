package com.example.demo.Entities.RelationEntites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "manages")
@IdClass(managesID.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class manages {

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Id
    @MapsId("manager_id")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private com.example.demo.Entities.AccountEntites.manager manager;

    @Id
    @MapsId("shelter_id")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "shelter_id", referencedColumnName = "id")
    private com.example.demo.Entities.AccountEntites.shelter shelter;
}
