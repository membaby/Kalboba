package com.example.demo.Repositories;

import com.example.demo.Entities.works_at;
import com.example.demo.Entities.works_atID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface works_atRepository extends JpaRepository<works_at, works_atID>, JpaSpecificationExecutor<works_at> {
}
