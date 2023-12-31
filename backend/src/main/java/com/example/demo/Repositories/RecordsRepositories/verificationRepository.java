package com.example.demo.Repositories.RecordsRepositories;

import com.example.demo.Entities.AccountEntites.user_account;
import com.example.demo.Entities.RecordsEntities.verification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface verificationRepository extends JpaRepository<verification, Integer>, JpaSpecificationExecutor<verification> {
    verification findByAccount(user_account account);

}
