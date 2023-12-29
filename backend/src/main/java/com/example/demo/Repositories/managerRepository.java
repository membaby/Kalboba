package com.example.demo.Repositories;

import com.example.demo.Entities.manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface managerRepository extends JpaRepository<manager, Integer>, JpaSpecificationExecutor<manager> {
}
