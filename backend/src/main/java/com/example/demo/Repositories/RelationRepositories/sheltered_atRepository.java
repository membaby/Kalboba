package com.example.demo.Repositories.RelationRepositories;

import com.example.demo.Entities.PetEntities.pet;
import com.example.demo.Entities.RelationEntites.sheltered_at;
import com.example.demo.Entities.RelationEntites.sheltered_atID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface sheltered_atRepository extends JpaRepository<sheltered_at, sheltered_atID>, JpaSpecificationExecutor<sheltered_at> {
    List<pet> findPetsByshelter_id(Integer shelterID);


    void deleteBypet_id(int petID);
}
