package com.example.demo.Entities.RecordsEntities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "doc_type")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class doc_type {

    @Id
    @Column(name = "type_no")
    private Integer type_no;

    @Column(name = "type_name")
    private String type_name;

    // Getters, setters, constructors...
}
