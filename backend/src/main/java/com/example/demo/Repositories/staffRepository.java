package com.example.demo.Repositories;

import com.example.demo.Entities.staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface staffRepository extends JpaRepository<staff, Integer>, JpaSpecificationExecutor<staff> {
}
