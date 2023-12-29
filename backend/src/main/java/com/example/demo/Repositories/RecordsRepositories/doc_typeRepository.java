package com.example.demo.Repositories.RecordsRepositories;

import com.example.demo.Entities.RecordsEntities.doc_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface doc_typeRepository extends JpaRepository<doc_type, Integer>, JpaSpecificationExecutor<doc_type> {
}
