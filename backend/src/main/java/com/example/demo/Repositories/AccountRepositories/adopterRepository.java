package com.example.demo.Repositories.AccountRepositories;

import com.example.demo.Entities.AccountEntites.adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface adopterRepository extends JpaRepository<adopter, Integer>, JpaSpecificationExecutor<adopter> {
}
