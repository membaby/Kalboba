package com.example.demo.Entities.RecordsEntities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "adoption_application_open")
@IdClass(adoption_applicationID.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class adoption_application_open {

        @Id
        @Column(name = "pet_id")
        private int pet_id;

        @Id
        @Column(name = "adopter_id")
        private int adopter_id;

        @Id
        @Column(name = "shelter_id")
        private int shelter_id;

        @Column(name = "time_stamp")
        private java.sql.Timestamp time_stamp;

        @Column(name = "status")
        private Status status;

        @Column(name = "first_pet")
        private Boolean first_pet;

        @Column(name = "children_ages")
        private String children_ages;

        @Column(name = "place_for_pet")
        private String place_for_pet;

        @Column(name = "tolerance")
        private String tolerance;

        @Column(name = "adopters_time")
        private String adopters_time;

        @MapsId("pet_id")
        @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
        @JoinColumn(name = "pet_id", referencedColumnName = "id")
        private com.example.demo.Entities.PetEntities.pet pet;

        @MapsId("adopter_id")
        @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
        @JoinColumn(name = "adopter_id", referencedColumnName = "id")
        private com.example.demo.Entities.AccountEntites.adopter adopter;

        @MapsId("shelter_id")
        @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
        @JoinColumn(name = "shelter_id", referencedColumnName = "id")
        private com.example.demo.Entities.AccountEntites.shelter shelter;

}
