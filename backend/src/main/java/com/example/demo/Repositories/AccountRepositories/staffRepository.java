package com.example.demo.Repositories.AccountRepositories;

import com.example.demo.Entities.AccountEntites.staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface staffRepository extends JpaRepository<staff, Integer>, JpaSpecificationExecutor<staff> {
    staff findByEmail(String staffEmail);
}
