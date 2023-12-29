package com.example.demo.Repositories.AccountRepositories;

import com.example.demo.Entities.AccountEntites.manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface managerRepository extends JpaRepository<manager, Integer>, JpaSpecificationExecutor<manager> {
}
