package com.example.demo.Repositories.AccountRepositories;

import com.example.demo.Entities.AccountEntites.user_account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface user_accountRepository extends JpaRepository<user_account, Integer>, JpaSpecificationExecutor<user_account> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    user_account findByUsername(String username);

    user_account findByEmail(String emailOrUsername);
}
