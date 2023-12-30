package com.example.demo.Repositories.RelationRepositories;

import com.example.demo.Entities.PetEntities.pet;
import com.example.demo.Entities.RelationEntites.adopted_by;
import com.example.demo.Entities.RelationEntites.adopted_byID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface adopted_byRepository extends JpaRepository<adopted_by, adopted_byID>, JpaSpecificationExecutor<adopted_by> {
    List<pet> findPetsByadopter_id(Integer adopterID);
}
