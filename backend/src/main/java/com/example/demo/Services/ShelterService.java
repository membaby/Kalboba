package com.example.demo.Services;

import com.example.demo.Entities.AccountEntites.shelter;
import com.example.demo.Entities.AccountEntites.staff;
import com.example.demo.Entities.PetEntities.pet;
import com.example.demo.Entities.RelationEntites.sheltered_at;
import com.example.demo.Repositories.PetRepositories.petRepository;
import com.example.demo.Repositories.AccountRepositories.shelterRepository;
import com.example.demo.Repositories.RelationRepositories.sheltered_atRepository;
import com.example.demo.Repositories.RelationRepositories.works_atRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ShelterService {

    private shelterRepository shelterrepository;
    private works_atRepository works_atrepository;
    private sheltered_atRepository sheltered_atrepository;
    private petRepository petrepository;

    @Autowired
    public ShelterService(
            shelterRepository shelterrepository,
            works_atRepository works_atrepository,
            sheltered_atRepository sheltered_atrepository,
            petRepository petrepository
    ) {
        this.shelterrepository = shelterrepository;
        this.works_atrepository = works_atrepository;
        this.sheltered_atrepository = sheltered_atrepository;
        this.petrepository = petrepository;
    }

    public shelter ViewShelterInformation(int shelterID) {
        shelter Myshelter = shelterrepository.findById(shelterID).orElse(null);
        return Myshelter;
        // TODO implement here
    }

    public List<staff> ViewShelterStaff(int shelterID) {
        List<staff> staffList = works_atrepository.findStaffByshelter_id(shelterID);
        return staffList;
    }

    public List<pet> ViewShelterPets(int shelterID) {
        List<pet> petList = sheltered_atrepository.findPetsByshelter_id(shelterID);
        return petList;
    }

    public void ViewAdoptionApplications_Current(int shelterID) {
        // TODO implement here
    }

    public void ViewAdoptionApplications_History(int shelterID) {
        // TODO implement here
    }

    public String AcceptAdoptionApplication_InProgress() {
        // TODO implement here
        return null;
    }

    public String AcceptAdoptionApplication_Done() {
        // TODO implement here
        return null;
    }

    public String RejectAdoptionApplication() {
        // TODO implement here
        return null;
    }

    public String AddPet(pet mypet, int shelterID) {
        shelter myshelter = shelterrepository.findById(shelterID).orElse(null);
        if (myshelter == null) {
            return "Shelter Not Found";
        }
        sheltered_at newsheltered_at = sheltered_at.builder()
                .pet(mypet)
                .shelter(myshelter)
                .start_date(new Date(System.currentTimeMillis()))
                .end_date(null)
                .build();
        sheltered_atrepository.save(newsheltered_at);

        return "Done";
    }

    public String EditPetInformation(pet mypet) {
        pet pet1 = petrepository.findById(mypet.getId()).orElse(null);
        if (pet1 == null) {
            return "Pet Not Found";
        }
        petrepository.save(mypet);
        return "Done";
    }

    public String AddDocumentForThePet() {
        // TODO implement here
        return null;
    }

    public String RemovePet(int petID, int shelterID) {
        shelter myshelter = shelterrepository.findById(shelterID).orElse(null);
        if (myshelter == null) {
            return "Shelter Not Found";
        }
        pet mypet = petrepository.findById(petID).orElse(null);
        if (mypet == null) {
            return "Pet Not Found";
        }
        petrepository.delete(mypet);
        // TODO implement here
        return "Done";
    }

}
