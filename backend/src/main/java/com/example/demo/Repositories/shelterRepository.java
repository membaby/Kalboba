package com.example.demo.Repositories;

import com.example.demo.Entities.shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface shelterRepository extends JpaRepository<shelter, Integer>, JpaSpecificationExecutor<shelter> {
}
