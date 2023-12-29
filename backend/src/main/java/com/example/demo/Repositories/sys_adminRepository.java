package com.example.demo.Repositories;

import com.example.demo.Entities.sys_admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface sys_adminRepository extends JpaRepository<sys_admin, Integer>, JpaSpecificationExecutor<sys_admin> {
}
