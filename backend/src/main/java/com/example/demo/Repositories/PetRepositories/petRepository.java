package com.example.demo.Repositories.PetRepositories;

import com.example.demo.Entities.PetEntities.pet;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface petRepository extends JpaRepository<pet, Integer>, JpaSpecificationExecutor<pet> {
    @Query("SELECT LAST_INSERT_ID()")
    Integer findMaxId();

}
