package com.example.demo.Services;

import com.example.demo.Entities.AccountEntites.shelter;
import com.example.demo.Entities.AccountEntites.staff;
import com.example.demo.Entities.PetEntities.pet;
import com.example.demo.Entities.RecordsEntities.Status;
import com.example.demo.Entities.RecordsEntities.adoption_applicationID;
import com.example.demo.Entities.RecordsEntities.adoption_application_closed;
import com.example.demo.Entities.RecordsEntities.adoption_application_open;
import com.example.demo.Entities.RelationEntites.sheltered_at;
import com.example.demo.Repositories.PetRepositories.petRepository;
import com.example.demo.Repositories.AccountRepositories.shelterRepository;
import com.example.demo.Repositories.RecordsRepositories.adoption_application_closedRepository;
import com.example.demo.Repositories.RecordsRepositories.adoption_application_openRepository;
import com.example.demo.Repositories.RelationRepositories.adopted_byRepository;
import com.example.demo.Repositories.RelationRepositories.sheltered_atRepository;
import com.example.demo.Repositories.RelationRepositories.works_atRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ShelterService {

    private works_atRepository works_atrepository;
    private shelterRepository shelterrepository;
    private sheltered_atRepository sheltered_atrepository;
    private petRepository petrepository;
    private adoption_application_closedRepository adoption_application_currentrepository;
    private adoption_application_openRepository adoption_application_openrepository;
    private NotificationService notificationService;


    @Autowired
    public ShelterService(
            shelterRepository shelterrepository,
            works_atRepository works_atrepository,
            sheltered_atRepository sheltered_atrepository,
            petRepository petrepository,
            adoption_application_closedRepository adoption_application_currentrepository,
            adoption_application_openRepository adoption_application_openrepository,
            NotificationService notificationService

    ) {
        this.shelterrepository = shelterrepository;
        this.works_atrepository = works_atrepository;
        this.sheltered_atrepository = sheltered_atrepository;
        this.petrepository = petrepository;
        this.adoption_application_currentrepository = adoption_application_currentrepository;
        this.adoption_application_openrepository = adoption_application_openrepository;
        this.notificationService = notificationService;
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

    public List<adoption_application_closed> ViewAdoptionApplications_History(int shelterID) {
        List<adoption_application_closed> adoption_application_currentList = adoption_application_currentrepository.findAdoption_application_currentsByshelter_id(shelterID);
        return adoption_application_currentList;
        // TODO implement here
    }

    public List<adoption_application_open> ViewAdoptionApplications_Current(int shelterID) {
        List<adoption_application_open> adoption_application_openList = adoption_application_openrepository.findAdoption_application_opensByshelter_id(shelterID);
        return adoption_application_openList;
        // TODO implement here
    }

    public String AcceptAdoptionApplication_UnderReview(Integer petID, Integer adopterID, Integer shelterID) {
        adoption_application_open app = adoption_application_openrepository.findById(new adoption_applicationID(petID, adopterID, shelterID)).orElse(null);
        if (app == null) {
            return "Application Not Found";
        }
        app.setStatus(Status.UnderReview);
        adoption_application_openrepository.save(app);
        notificationService.sendNotification("Your application for pet " + petID + " is under review", adopterID);

        // TODO implement here
        return "Done";
    }

    public String AcceptAdoptionApplication_InProgress(Integer petID, Integer adopterID, Integer shelterID) {
        adoption_application_open app = adoption_application_openrepository.findById(new adoption_applicationID(petID, adopterID, shelterID)).orElse(null);
        if (app == null) {
            return "Application Not Found";
        }
        app.setStatus(Status.Accepted_Open);
        adoption_application_openrepository.save(app);
        notificationService.sendNotification("Your application for pet " + petID + " is accepted waiting for pick up", adopterID);
        // TODO implement here
        return "Done";
    }

    public String AcceptAdoptionApplication_Done(Integer petID, Integer adopterID, Integer shelterID) {
        adoption_application_open app = adoption_application_openrepository.findById(new adoption_applicationID(petID, adopterID, shelterID)).orElse(null);
        if (app == null) {
            return "Application Not Found";
        }
        app.setStatus(Status.Accepted_Completed);
        adoption_application_openrepository.save(app);
        notificationService.sendNotification("Your application for pet " + petID + " is Completed", adopterID);
        // TODO implement here
        return "Done";
    }

    public String RejectAdoptionApplication(Integer petID, Integer adopterID, Integer shelterID) {
        adoption_application_open app = adoption_application_openrepository.findById(new adoption_applicationID(petID, adopterID, shelterID)).orElse(null);
        if (app == null) {
            return "Application Not Found";
        }
        app.setStatus(Status.Rejected);
        adoption_application_openrepository.save(app);
        notificationService.sendNotification("Your application for pet " + petID + " is Rejected", adopterID);
        // TODO implement here
        return "Done";
    }
    private Integer SavePet(pet mypet) {
        petrepository.save(mypet);
        return petrepository.findMaxId();
    }

    public String AddPet(pet mypet, int shelterID) {
        shelter myshelter = shelterrepository.findById(shelterID).orElse(null);
        if (myshelter == null) {
            return "Shelter Not Found";
        }
        mypet.setId(SavePet(mypet));
        sheltered_at newsheltered_at = sheltered_at.builder()
                .pet(mypet)
                .pet_id(mypet.getId())
                .shelter(myshelter)
                .shelter_id(shelterID)
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
        mypet = petrepository.findById(petID).orElse(null);
        if (mypet == null) {
            return "Pet Not Found";
        }
        sheltered_atrepository.deleteBypet_id(petID);
        // TODO implement here
        return "Done";
    }

}
