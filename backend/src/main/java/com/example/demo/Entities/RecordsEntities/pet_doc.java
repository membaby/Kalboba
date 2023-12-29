package com.example.demo.Entities.RecordsEntities;


import com.example.demo.Entities.PetEntities.pet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pet_doc")
@IdClass(pet_docID.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class pet_doc {
    @Id
    @MapsId("pet_id")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    private pet pet_id;

    @Id
    @MapsId("doctype")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "doctype", referencedColumnName = "type_no")
    private doc_type doctype;

    @Column(name = "document")
    private byte[] document;
}
