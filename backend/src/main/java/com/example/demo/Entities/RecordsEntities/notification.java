package com.example.demo.Entities.RecordsEntities;

import com.example.demo.Entities.AccountEntites.user_account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "notification")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class notification {
    /*CREATE TABLE notification (
	account_id INT NOT NULL,
    viewed BOOL NOT NULL DEFAULT FALSE,
    time_stamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    message VARCHAR(255) NOT NULL,
    FOREIGN KEY (account_id) REFERENCES user_account(id)
);*/

    @Id
    @Column(name = "account_id")
    private Integer account_id;

    @Column(name = "viewed")
    private boolean viewed;

    @Column(name = "time_stamp")
    private Timestamp time_stamp;

    @Column(name = "message")
    private String message;

    @MapsId
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "account_id")
    private user_account account;

}
