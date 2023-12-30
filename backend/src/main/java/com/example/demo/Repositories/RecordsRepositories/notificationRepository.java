package com.example.demo.Repositories.RecordsRepositories;

import com.example.demo.Entities.RecordsEntities.notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface notificationRepository extends JpaRepository <notification, Integer> {
    List<notification> findAllByaccount_id(Integer adopterID);
}
