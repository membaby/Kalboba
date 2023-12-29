package com.example.demo.Entities.RecordsEntities;

import com.example.demo.Entities.AccountEntites.user_account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "verification")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class verification {
    /*CREATE TABLE verification (
	account_id INT NOT NULL,
    time_stamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    otp VARCHAR(10) NOT NULL,
    PRIMARY KEY (account_id, time_stamp),
    FOREIGN KEY (account_id) REFERENCES user_account(id)
);*/
    @Id
    @Column(name = "account_id")
    private Integer account_id;

    @Column(name = "time_stamp")
    private Timestamp time_stamp;

    @Column(name = "otp")
    private String otp;

    @MapsId
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "account_id")
    private user_account account;
}
