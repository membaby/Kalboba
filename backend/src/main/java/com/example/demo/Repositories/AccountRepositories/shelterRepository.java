package com.example.demo.Repositories.AccountRepositories;

import com.example.demo.Entities.AccountEntites.shelter;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface shelterRepository extends JpaRepository<shelter, Integer>, JpaSpecificationExecutor<shelter> {
    @Query("SELECT MAX(s.id) FROM shelter s")
    Integer findMaxId();
}
