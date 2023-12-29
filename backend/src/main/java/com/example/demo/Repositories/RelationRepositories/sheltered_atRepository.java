package com.example.demo.Repositories.RelationRepositories;

import com.example.demo.Entities.RelationEntites.sheltered_at;
import com.example.demo.Entities.RelationEntites.sheltered_atID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface sheltered_atRepository extends JpaRepository<sheltered_at, sheltered_atID>, JpaSpecificationExecutor<sheltered_at> {
}
