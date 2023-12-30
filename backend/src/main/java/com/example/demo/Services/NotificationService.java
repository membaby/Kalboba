package com.example.demo.Services;

import com.example.demo.Entities.RecordsEntities.notification;
import com.example.demo.Repositories.RecordsRepositories.notificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class NotificationService {
    private notificationRepository notificationrepository;
    @Autowired
    public NotificationService(
            notificationRepository notificationrepository
    ) {
        this.notificationrepository = notificationrepository;
    }


    public void sendNotification(String message,Integer adopterID) {
        notification myNotification = notification.builder()
                .account_id(adopterID)
                .message(message)
                .viewed(false)
                .time_stamp(new Timestamp(System.currentTimeMillis()))
                .build();
        notificationrepository.save(myNotification);
        // TODO implement here
    }

    public List<notification> ViewNotifications(Integer adopterID) {
        List<notification> myNotifications = notificationrepository.findAllByaccount_id(adopterID);
        //for every notification in myNotifications, set viewed to true
        for (notification myNotification : myNotifications) {
            myNotification.setViewed(true);
            notificationrepository.save(myNotification);
        }
        return myNotifications;
        // TODO implement here
    }

    public void DeleteNotification(Integer AdopterID) {
        notificationrepository.deleteById(AdopterID);
        System.out.println("Deleting notification");
    }

}
