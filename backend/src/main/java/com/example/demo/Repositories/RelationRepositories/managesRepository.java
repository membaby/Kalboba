package com.example.demo.Repositories.RelationRepositories;

import com.example.demo.Entities.RelationEntites.manages;
import com.example.demo.Entities.RelationEntites.managesID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface managesRepository extends JpaRepository<manages, managesID>, JpaSpecificationExecutor<manages> {
    List<manages> findAllBymanager_id(Integer managerID);
}
