package com.example.demo.Entities.RelationEntites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "works_at")
@IdClass(works_atID.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class works_at {
    /*CREATE TABLE works_at (
	staff_id INT NOT NULL,
    shelter_id INT NOT NULL,
    staff_role VARCHAR(100) NOT NULL DEFAULT 'No specific role yet.',
    start_date DATE NOT NULL,
    end_date DATE,
    PRIMARY KEY (staff_id, shelter_id),
    FOREIGN KEY (staff_id) REFERENCES staff(id),
    FOREIGN KEY (shelter_id) REFERENCES shelter(id)
);*/
    @Column(name = "staff_role")
    private String staff_role;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Id
    @Column(name = "staff_id")
    private int staff_id;

    @Id
    @Column(name = "shelter_id")
    private int shelter_id;


    @MapsId("staff_id")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private com.example.demo.Entities.AccountEntites.staff staff;

    @MapsId("shelter_id")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "shelter_id", referencedColumnName = "id")
    private com.example.demo.Entities.AccountEntites.shelter shelter;
}
