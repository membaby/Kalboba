package com.example.demo.Repositories.AccountRepositories;

import com.example.demo.Entities.AccountEntites.shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface shelterRepository extends JpaRepository<shelter, Integer>, JpaSpecificationExecutor<shelter> {
}
