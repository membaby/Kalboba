package com.example.demo.Entities.AccountEntites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Table(name = "shelter")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class shelter {
    /*CREATE TABLE shelter (
	id INT NOT NULL AUTO_INCREMENT,
    shelter_name VARCHAR(70) NOT NULL,
    location VARCHAR(200) NOT NULL,
    phone_no VARCHAR(15) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "shelter_name")
    private String shelter_name;

    @Column(name = "location")
    private String location;

    @Column(name = "phone_no")
    private String phone_no;


    @Column(name = "email")
    private String email;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        user_account useraccount1 = (user_account) o;
        return getId() != null && Objects.equals(getId(), useraccount1.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

}
