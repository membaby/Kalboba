package com.example.demo.Services;

import com.example.demo.Entities.AccountEntites.manager;
import com.example.demo.Entities.AccountEntites.shelter;
import com.example.demo.Entities.AccountEntites.user_account;
import com.example.demo.Entities.RelationEntites.manages;
import com.example.demo.Entities.RelationEntites.works_at;
import com.example.demo.Repositories.AccountRepositories.managerRepository;
import com.example.demo.Repositories.AccountRepositories.staffRepository;
import com.example.demo.Repositories.AccountRepositories.user_accountRepository;
import com.example.demo.Repositories.RelationRepositories.managesRepository;
import com.example.demo.Repositories.AccountRepositories.shelterRepository;
import com.example.demo.Repositories.RelationRepositories.works_atRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class MangerService {
    private shelterRepository shelterrepository;
    private staffRepository staffrepository;
    private works_atRepository works_atrepository;

    private user_accountRepository accountRepository;

    private managesRepository mannagesrepository;
    private managerRepository ManagerRepository;

    @Autowired
    public MangerService(
            shelterRepository shelterrepository,
            staffRepository staffrepository,
            works_atRepository works_atrepository,
            user_accountRepository accountRepository,
            managesRepository mannagesrepository,
            managerRepository ManagerRepository
    ) {
        this.shelterrepository = shelterrepository;
        this.staffrepository = staffrepository;
        this.works_atrepository = works_atrepository;
        this.accountRepository = accountRepository;
        this.mannagesrepository = mannagesrepository;
        this.ManagerRepository = ManagerRepository;
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
        user_account newstaff = accountRepository.findByEmail(staffEmail);
        shelter myshelter = shelterrepository.findById(shelterID).orElse(null);
        if (newstaff == null) {
            return "Staff Not Found";
        }
        if (myshelter == null) {
            return "Shelter Not Found";
        }
        works_at newworks_at = works_at.builder()
                .staff_id(newstaff.getId())
                .shelter_id(myshelter.getId())
                .staff_role(staffType)
                .start_date(new Date(System.currentTimeMillis()))
                .end_date(null)
                .build();

        works_atrepository.save(newworks_at);
        return "Done";

    }

    public String RemoveStaffFromShelter(String staffEmail,Integer shelterID) {
        user_account newstaff = accountRepository.findByEmail(staffEmail);
        shelter myshelter = shelterrepository.findById(shelterID).orElse(null);
        if (newstaff == null) {
            return "Staff Not Found";
        }
        if (myshelter == null) {
            return "Shelter Not Found";
        }
        works_atRepository.deleteBystaff_idAndshelter_id(newstaff.getId(),myshelter.getId());
        return "Done";
        // TODO implement here
    }

    private synchronized int saveShelter(shelter sh) {
        shelterrepository.save(sh);
        return shelterrepository.findMaxId();
    }

    public String AddShelter(shelter newShelter,int managerID) {
        if (newShelter.getId() == null) {
            manager newmanager = ManagerRepository.findById(managerID).orElse(null);
            if (newmanager == null) {
                return "Manager Not Found";
            }

            int shelterID = saveShelter(newShelter);

            manages newmanages = manages.builder()
                    .manager(newmanager)
                    .manager_id(newmanager.getId())
                    .shelter(newShelter)
                    .shelter_id(shelterID)
                    .start_date(new Date(System.currentTimeMillis()))
                    .end_date(null)
                    .build();
            mannagesrepository.save(newmanages);
        }
        return "Shelter Already Exists";
    }

    public List<shelter> ViewShelters(int managerID) {
        List<manages> managesList = mannagesrepository.findAllBymanager_id(managerID);
        List<shelter> shelterList = new ArrayList<>();
        for (manages manages : managesList) {
            shelterList.add(manages.getShelter());
        }
        return shelterList;

    }


}
