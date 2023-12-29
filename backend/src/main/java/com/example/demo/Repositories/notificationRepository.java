package com.example.demo.Repositories;

import com.example.demo.Entities.notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface notificationRepository extends JpaRepository <notification, Integer> {
}
