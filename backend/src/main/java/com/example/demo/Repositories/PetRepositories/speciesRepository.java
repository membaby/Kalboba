package com.example.demo.Repositories.PetRepositories;

import com.example.demo.Entities.PetEntities.species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface speciesRepository extends JpaRepository<species, String> , JpaSpecificationExecutor<species> {

}