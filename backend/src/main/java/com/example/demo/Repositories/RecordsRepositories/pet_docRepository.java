package com.example.demo.Repositories.RecordsRepositories;

import com.example.demo.Entities.RecordsEntities.pet_doc;
import com.example.demo.Entities.RecordsEntities.pet_docID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface pet_docRepository extends JpaRepository<pet_doc, pet_docID>, JpaSpecificationExecutor<pet_doc> {
}