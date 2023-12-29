package com.example.demo.Repositories;

import com.example.demo.Entities.manages;
import com.example.demo.Entities.managesID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface managesRepository extends JpaRepository<manages, managesID>, JpaSpecificationExecutor<manages> {
}
