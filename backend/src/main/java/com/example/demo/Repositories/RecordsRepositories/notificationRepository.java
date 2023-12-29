package com.example.demo.Repositories.RecordsRepositories;

import com.example.demo.Entities.RecordsEntities.notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface notificationRepository extends JpaRepository <notification, Integer> {
}
