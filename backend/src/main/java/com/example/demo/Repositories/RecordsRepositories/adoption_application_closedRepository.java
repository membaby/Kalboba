package com.example.demo.Repositories.RecordsRepositories;

import com.example.demo.Entities.RecordsEntities.adoption_applicationID;
import com.example.demo.Entities.RecordsEntities.adoption_application_closed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface adoption_application_closedRepository extends JpaRepository<adoption_application_closed, adoption_applicationID>, JpaSpecificationExecutor<adoption_application_closed> {
    List<adoption_application_closed> findAdoption_application_currentsByshelter_id(int shelterID);
}
