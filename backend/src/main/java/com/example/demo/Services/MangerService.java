package com.example.demo.Services;

import com.example.demo.Entities.AccountEntites.shelter;
import com.example.demo.Entities.AccountEntites.staff;
import com.example.demo.Entities.RelationEntites.works_at;
import com.example.demo.Entities.RelationEntites.works_atID;
import com.example.demo.Repositories.AccountRepositories.staffRepository;
import com.example.demo.Repositories.RelationRepositories.shelterRepository;
import com.example.demo.Repositories.RelationRepositories.works_atRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class MangerService {
    private shelterRepository shelterrepository;
    private staffRepository staffrepository;
    private works_atRepository works_atrepository;

    @Autowired
    public MangerService(
            shelterRepository shelterrepository,
            staffRepository staffrepository,
            works_atRepository works_atrepository
    ) {
        this.shelterrepository = shelterrepository;
        this.staffrepository = staffrepository;
        this.works_atrepository = works_atrepository;
    }


    /*public void EditProfile() {
        // TODO implement here
    }*/

    public String EditShelterInformation(shelter myshelter) {
        shelter shelter1 = shelterrepository.findById(myshelter.getId()).orElse(null);
        if (shelter1 == null) {
            return "Shelter Not Found";
        }
        shelterrepository.save(myshelter);
        return "Done";
    }

    public String AddStaffToShelter(String staffEmail,Integer shelterID,String staffType) {
        /*staff newStaff = staffrepository.findByEmail(staffEmail);
        shelter myshelter = shelterrepository.findById(shelterID).orElse(null);
        if (newStaff == null) {
            return "Staff Not Found";
        }
        if (myshelter == null) {
            return "Shelter Not Found";
        }
        Date date = new Date(System.currentTimeMillis());
        works_atID works_atID = new works_atID(newStaff,myshelter);
        works_at newWorks_at = works_at.builder()

                .date(date)
                .staffType(staffType)
                .build();*/
        return "Done";

    }

    public String RemoveStaffFromShelter(String staffEmail,Integer shelterID) {
        /*staff newStaff = staffrepository.findByEmail(staffEmail);
        shelter myshelter = shelterrepository.findById(shelterID).orElse(null);
        if (newStaff == null) {
            return "Staff Not Found";
        }
        if (myshelter == null) {
            return "Shelter Not Found";
        }*/
        return "Done";
        // TODO implement here
    }

    public void AddShelter(shelter newShelter) {
        // TODO implement here
    }


}
