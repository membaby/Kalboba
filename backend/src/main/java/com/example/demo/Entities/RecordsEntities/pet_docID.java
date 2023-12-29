package com.example.demo.Entities.RecordsEntities;

import com.example.demo.Entities.PetEntities.pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class pet_docID implements java.io.Serializable {

    private com.example.demo.Entities.PetEntities.pet pet_id;
    private com.example.demo.Entities.RecordsEntities.doc_type doctype;
}
