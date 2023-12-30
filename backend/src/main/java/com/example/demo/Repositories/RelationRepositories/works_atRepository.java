package com.example.demo.Repositories.RelationRepositories;

import com.example.demo.Entities.RelationEntites.works_at;
import com.example.demo.Entities.RelationEntites.works_atID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface works_atRepository extends JpaRepository<works_at, works_atID>, JpaSpecificationExecutor<works_at> {
    static void deleteBystaff_idAndshelter_id(Integer id, Integer id1) {
    }
}
