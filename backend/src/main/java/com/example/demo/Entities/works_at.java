package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "works_at")
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
    @EmbeddedId
    private works_atID works_atID;

    @Column(name = "staff_role")
    private String staff_role;

    @Column(name = "start_date")
    private String start_date;

    @Column(name = "end_date")
    private String end_date;

    @MapsId("staff_id")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private staff staff;

    @MapsId("shelter_id")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "shelter_id", referencedColumnName = "id")
    private shelter shelter;
}
