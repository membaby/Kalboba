package com.example.demo.Repositories.PetRepositories;

import com.example.demo.Entities.PetEntities.breed;
import com.example.demo.Entities.PetEntities.breedID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface breedRepository extends JpaRepository<breed, breedID>, JpaSpecificationExecutor<breed> {
}
